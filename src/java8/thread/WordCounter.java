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
package java8.thread;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCounter {

	public static void main(final String[] args) {

		// 3 apple, 2 banana, others 1
		final List<String> items = Arrays.asList("apple", "apple", "banana",
				"apple", "orange", "banana", "papaya");

		final Map<String, Long> result = items.stream().collect(
				Collectors.groupingBy(
						Function.identity(), Collectors.counting()));

		System.out.println(result);

	}
}

