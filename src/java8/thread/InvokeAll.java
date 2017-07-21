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

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAll {

	public static void main(final String[] args) throws InterruptedException {
		final ExecutorService executor = Executors.newWorkStealingPool();
		final List<Callable<String>> callables = Arrays.asList(() -> "task1", () -> "task2", () -> "task3");
		executor.invokeAll(callables).stream().map(future -> {
			try {
				return future.get();
			} catch (final Exception e) {
				throw new IllegalStateException();
			}
		}).forEach(System.out::println);
	}

}

