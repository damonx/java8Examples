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
package java8.stream;

import java.util.stream.LongStream;

public class ParallelLongStream {
	public static long parallelSum(final long n) {
		return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
	}

	public static void main(final String[] args) {
		final long start = System.currentTimeMillis();
		final long sum = parallelSum(10_000_000);
		final long end = System.currentTimeMillis();
		System.out.println("Sum: " + sum);
		System.out.println("It took: " + (end - start) + " milliseconds");

	}
}

