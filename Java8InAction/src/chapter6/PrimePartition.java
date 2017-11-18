/*
 * Copyright (c) Fisher and Paykel Appliances.
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package chapter6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimePartition {

	public boolean isPrime(final int candidate) {
		return IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
	}

	public boolean isPrimeSqrt(final int candidate) {
		final int candidateRoot = (int) Math.sqrt(candidate);
		return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
	}

	public Map<Boolean, List<Integer>> partitionPrimes(final int n) {
		return IntStream.rangeClosed(2, n).boxed().collect(Collectors.partitioningBy(candidate -> isPrimeSqrt(candidate)));
	}

	public static void main(final String[] args) {
		System.out.println(new PrimePartition().partitionPrimes(1000).get(true));
	}

}
