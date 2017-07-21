/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2016).
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package java8.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {
	StampedLock lock = new StampedLock();

	public void testStampedLock() {
		final ExecutorService executor = Executors.newFixedThreadPool(2);
		final Map<String, String> map = new HashMap<>();
		executor.submit(() -> {
			final long stamp = this.lock.writeLock();
			try {
				sleep(1);
				map.put("foo", "bar");
			} finally {
				this.lock.unlockWrite(stamp);
			}
		});

		final Runnable readTask = () -> {
			final long stamp = this.lock.readLock();
			try {
				System.out.println(map.get("foo"));
				sleep(1);
			} finally {
				this.lock.unlockRead(stamp);
			}
		};

		executor.submit(readTask);
		executor.submit(readTask);

		stop(executor);
	}

	private void sleep(final long number) {
		try {
			TimeUnit.SECONDS.sleep(number);
		} catch (final InterruptedException e) {
		}
	}

	private void stop(final ExecutorService executor) {
		try {
			System.out.println("attempt to shutdown executor");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (final InterruptedException e) {
			System.err.println("tasks interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}
	}

	public static void main(final String[] args) {
		new StampedLockTest().testStampedLock();
	}

}

