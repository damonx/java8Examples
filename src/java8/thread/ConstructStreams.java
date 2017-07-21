/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2016).
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructStreams {
	public static void main(final String[] args) {
		// 1. Individual values
		Stream<String> stream = Stream.of("a", "b", "c");
		stream.forEach(System.out::println);
		// 2. Arrays
		final String[] strArray = new String[] { "a", "b", "c" };
		stream = Stream.of(strArray);
		stream = Arrays.stream(strArray);
		// 3. Collections
		final List<String> list = Arrays.asList(strArray);
		stream = list.stream();

		final String[] strArray1 = stream.toArray(String[]::new);
		strArray1.toString();

		// // 2. Collection
		// final List<String> list1 = stream.collect(Collectors.toList());
		// final List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
		// final Set set1 = stream.collect(Collectors.toSet());
		// final Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
		// // 3. String
		// final String str = stream.collect(Collectors.joining()).toString();
		Stream.of("a", "b").map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
		final List<Integer> nums = Arrays.asList(1, 2, 3, 4);
		nums.stream().map(n -> n * n).collect(Collectors.toList()).forEach(System.out::println);
		// flatMap
		final Stream<List<Integer>> inputStream = Stream.of(
				Arrays.asList(1),
				Arrays.asList(2, 3),
				Arrays.asList(4, 5, 6));
		inputStream.flatMap((childList) -> childList.stream()).forEach(System.out::println);

		// peek
		Stream.of("one", "two", "three", "four")
				.filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value: " + e))
				.map(String::toUpperCase)
				.peek(e -> System.out.println("Mapped value: " + e))
				.collect(Collectors.toList());

		// Optional Examples


	}
}

