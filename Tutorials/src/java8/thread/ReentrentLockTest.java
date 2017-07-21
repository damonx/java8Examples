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
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class ReentrentLockTest {
	ReentrantLock lock = new ReentrantLock();
	ReadWriteLock rwLock = new ReentrantReadWriteLock();
	int count = 0;

	private void increment() {
		this.lock.lock();
		try {
			this.count++;
		} finally {
			this.lock.unlock();
		}
	}

	public void test() {
		final ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 50000)
				.forEach(i -> executor.submit(this::increment));

		stop(executor);

		System.out.println(this.count);
	}

	public void testTryLock() {
		final ExecutorService executor = Executors.newFixedThreadPool(2);

		executor.submit(() -> {
			this.lock.lock();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (final InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.lock.unlock();
			}
		});

		executor.submit(() -> {
			System.out.println("Locked: " + this.lock.isLocked());
			System.out.println("Held by me: " + this.lock.isHeldByCurrentThread());
			final boolean locked = this.lock.tryLock();
			System.out.println("Lock acquired: " + locked);
		});

		stop(executor);
	}

	public void testReadWriteLock() {
		final ExecutorService executor = Executors.newFixedThreadPool(2);
		final Map<String, String> map = new HashMap<>();
		executor.submit(() -> {
			this.rwLock.writeLock().lock();
			try {
				TimeUnit.SECONDS.sleep(5);
				map.put("foo", "bar");
			} catch (final InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.rwLock.writeLock().unlock();
			}
		});

		final Runnable readTask = () -> {
			this.rwLock.readLock().lock();
			try {
				System.out.println(map.get("foo"));
				TimeUnit.SECONDS.sleep(1);
			} catch (final InterruptedException e) {
			} finally {
				this.rwLock.readLock().unlock();
			}
		};

		executor.submit(readTask);
		executor.submit(readTask);
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stop(executor);
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
		new ReentrentLockTest().testReadWriteLock();
	}

}

