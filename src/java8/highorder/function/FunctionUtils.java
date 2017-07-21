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

import java.util.function.Function;

public class FunctionUtils {
	public static Integer add1(final Integer x) {
		return x + 1;
	}

	public static String concat1(final String x) {
		return x + 1;
	}

	public static Function<Integer, Integer> adder(final Integer x) {
		return y -> x + y;
	}

	public static void main(final String[] args) {
		final Function<Integer, Integer> add1 = FunctionUtils::add1;
		final Function<String, String> concat1 = FunctionUtils::concat1;
		System.out.println("add1 -> " + add1.apply(5));
		System.out.println(concat1.apply("damonx"));
	}
}

