/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2017).
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package chapter11;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class ExchangeService {
	public enum Money {
		USD(1.0),
		EUR(1.35387),
		GBP(1.69715),
		CAD(.92106),
		MXN(.07683);

		private final double rate;

		Money(final double rate) {
			this.rate = rate;
		}
	}

	public static double getRate(final Money source, final Money destination) {
		return getRateWithDelay(source, destination);
	}

	private static double getRateWithDelay(final Money source, final Money destination) {
		Util.delay();
		return destination.rate / source.rate;
	}

	public Future<Double> findFuturePriceInUSD(final String product, final Shop shop){
		return CompletableFuture.supplyAsync(() -> shop.getUnitPrice(product))
				.thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(Money.EUR, Money.USD)),
						(price, rate) -> price * rate);

   }

}

