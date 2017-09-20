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
package forkandjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

	private static final long serialVersionUID = 1L;
	private final long[] numbers;
	private final int start;
	private final int end;


	public static final long THRESHOLD = 10_000;

	public ForkJoinSumCalculator(final long[] numbers) {
		this(numbers, 0, numbers.length);
    }

	private ForkJoinSumCalculator(final long[] numbers, final int start, final int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		final int length = this.end - this.start;
		if (length <= THRESHOLD) {
			return computeSequentially();
		}

		final ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(this.numbers, this.start, this.start + length / 2);
		leftTask.fork();

		final ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(this.numbers, this.start + length / 2, this.end);
		rightTask.fork();
		return leftTask.join() + rightTask.join();
	}

	private long computeSequentially() {
		long sum = 0;
		for (int i = this.start; i < this.end; i++) {
        	sum += this.numbers[i];
        }
		return sum;
	}
}

