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

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class CombinationTwoList {

	public static void main(final String[] args) {
		final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		final List<Integer> numbers2 = Arrays.asList(3, 4);
		final List<int[]> pairs = numbers1.stream()
				.flatMap(i -> numbers2.stream()
						.map(j -> new int[] { i, j }))
				.collect(toList());
		for (final int[] pair : pairs) {
			for (final int num : pair) {
				System.out.print(num);
				System.out.print("|");
			}
		}
	}

}

