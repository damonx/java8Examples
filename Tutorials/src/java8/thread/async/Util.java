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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Util {
	private static final DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

	public static void delay() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (final InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static double format(final double number) {
		synchronized (formatter) {
			return new Double(formatter.format(number));
		}
	}

	public static <T> CompletableFuture<List<T>> sequence(final List<CompletableFuture<T>> futures) {
		/*
		 * CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])); return
		 * allDoneFuture.thenApply(v -> futures.stream(). map(future -> future.join()). collect(Collectors.<T>toList()) );
		 */
		return CompletableFuture.supplyAsync(() -> futures.stream().map(future -> future.join()).collect(Collectors.<T>toList()));
	}

	private static final Random random = new Random();

	public static void randomDelay() {
		final int delay = 500 + random.nextInt(2000);
		try {
			Thread.sleep(delay);
		} catch (final InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}

