/*
 * Copyright (c) Fisher and Paykel Appliances
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package chapter5;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MapReduce {

	public static void main(final String[] args) {
		final int sum = IntStream.rangeClosed(1, 100000).reduce(0, (a, b) -> a + b);
		System.out.println(sum);

		final int sum2 = IntStream.rangeClosed(1, 100000).reduce(0, Integer::sum);
		System.out.println(sum2);

		final OptionalInt maxNum = IntStream.of(3, 2, 5, 9, 10).reduce(Integer::max);
		maxNum.ifPresent(System.out::println);

		final OptionalInt minNum = IntStream.of(3, 2, 5, 9, 10).reduce(Integer::min);
		minNum.ifPresent(System.out::println);

	}

}

