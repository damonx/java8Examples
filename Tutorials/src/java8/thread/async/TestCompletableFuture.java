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

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestCompletableFuture {
	private static ExecutorService service = Executors.newCachedThreadPool();

	public static void main(final String[] args) {
		final CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (final InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("running async task");
		}, service);
		// utility testing method
		while (!future.isDone()) {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (final InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("+");
		}
	}
}

