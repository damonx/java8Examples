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
package java8.highorder.function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class HighOrderFunctionTest {
	public static void main(final String[] args) {
		final Function<Integer, Function<Integer, Integer>> makeAdder = x -> y -> x + y;
		final Function<Integer, Integer> add1 = makeAdder.apply(1);
		final Function<Integer, Integer> add2 = makeAdder.apply(2);
		final Function<Integer, Integer> add3 = makeAdder.apply(3);
		System.out.println("add1: " + add1.apply(10));
		System.out.println("add2: " + add2.apply(10));
		System.out.println("add3: " + add3.apply(10));
		System.out.println("add100: " + makeAdder.apply(10).apply(100));

		final Function<Integer, Function<Integer, Integer>> makeAdder1 = FunctionUtils::adder;
		final Function<Integer, Integer> add10 = makeAdder1.apply(10);
		System.out.println("add10: " + add10.apply(10));

		final List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 6);
		numbers.sort(Comparator.naturalOrder());
	}
}

