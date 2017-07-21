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
package java8.thread;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class AsynchronousPopulation {
	private static Random rand = new Random();
	private static long t = System.currentTimeMillis();

	static int prePopulation() {
		System.out.println("begin to prepopulate");
		try {
			Thread.sleep(10000);
		} catch (final InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("end prepopulation, passed " + (System.currentTimeMillis() - t) / 1000 + " seconds");
		return rand.nextInt(1000);
	}

	static void prePopulationLong() {
		System.out.println("begin to prepopulate Long");
		try {
			Thread.sleep(10000);
		} catch (final InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("end prepopulation, passed " + (System.currentTimeMillis() - t) / 1000 + " seconds");
	}

	public static void main(final String[] args) throws Exception {
		// final CompletableFuture<Integer> future = CompletableFuture.supplyAsync(AsynchronousPopulation::prePopulation);
		// System.out.println("I can do other things...");
		// final Future<Integer> f = future.whenComplete((v, e) -> {
		// System.out.println(v);
		// });
		// System.out.println(f.get());
		// System.in.read();

		// final CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
		// return 100;
		// });
		// final CompletableFuture<Void> f = future.thenAccept(System.out::println);
		// // System.out.println(f.get());

		CompletableFuture.runAsync(() -> {
			AsynchronousPopulation.prePopulationLong();
		});
		
		System.out.println("Done");

	}
}

