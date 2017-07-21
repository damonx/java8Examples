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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreTest {
	ExecutorService executor = Executors.newFixedThreadPool(10);

	Semaphore semaphore = new Semaphore(5);

	public void runTest(){
		final Runnable longRunningTask = () -> {
		    boolean permit = false;
		    try {
		        permit = this.semaphore.tryAcquire(1, TimeUnit.SECONDS);
		        if (permit) {
		            System.out.println("Semaphore acquired");
		            TimeUnit.SECONDS.sleep(5);
		        } else {
		            System.out.println("Could not acquire semaphore");
		        }
		    } catch (final InterruptedException e) {
		        throw new IllegalStateException(e);
		    } finally {
		        if (permit) {
		            this.semaphore.release();
		        }
		    }
		};

		IntStream.range(0, 10)
		    .forEach(i -> this.executor.submit(longRunningTask));

		stop(this.executor);
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
		new SemaphoreTest().runTest();
	}
}

