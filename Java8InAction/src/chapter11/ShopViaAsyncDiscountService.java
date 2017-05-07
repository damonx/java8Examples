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

import java.util.ArrayList;
import java.util.List;

public class ShopViaAsyncDiscountService {
	public static void main(final String[] args) {
		final List<Shop> shops = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			shops.add(new Shop("shopAuckland" + (i + 1)));
		}

		final AsyncDiscountService ds = new AsyncDiscountService()
				.with(shops);
		final long start = System.nanoTime();
		ds.findPrices("iPhone7").forEach(System.out::println);
		final long retrivalTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Price returned after " + retrivalTime + " msecs");
	}
}

