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
package java8.thread.async;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AsyncShopClient {

	public static void doSomethingElse() {
		for (int i = 0; i < 10; i++) {
			System.out.print("doing something else");
			System.out.print("=");
			try {
				TimeUnit.MILLISECONDS.sleep(400);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(final String[] args) {
		final AsyncShop shop = new AsyncShop("BestShop");
		final long start = System.nanoTime();
		final Future<Double> futurePrice = shop.getPrice("myPhone");
		final long incocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Invocation returned after " + incocationTime + " msecs");
		doSomethingElse();
		try {
			System.out.println("Price is " + futurePrice.get());
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
		final long retrivalTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Price returned after " + retrivalTime + " msecs");
	}
}

