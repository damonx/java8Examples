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

import java.util.stream.Stream;

public class SequentialSum {

	public static long sequentialSum(final long n){
		return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
	}

	public static void main(final String[] args) {
		final long start = System.currentTimeMillis();
		final long sum = sequentialSum(10000000);
		final long end = System.currentTimeMillis();
		System.out.println("Sum: " + sum);
		System.out.println("It took: " + (end - start) + " milliseconds");

	}

}

