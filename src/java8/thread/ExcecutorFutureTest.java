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

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExcecutorFutureTest {

	public static void main(final String[] args) throws InterruptedException, ExecutionException {
		 final Callable<Integer> task = () -> {
			 try {
				TimeUnit.SECONDS.sleep(1);
				return 123;
			} catch ( final InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};

		final ExecutorService executor = Executors.newFixedThreadPool(1);
		final Future<Integer> future = executor.submit(task);
		System.out.println("future done? " + future.isDone());
		final Integer result = future.get();

		System.out.println("future done? " + future.isDone());
		System.out.print("result: " + result);

	}

}

