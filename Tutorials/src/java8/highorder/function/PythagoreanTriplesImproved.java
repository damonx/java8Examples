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
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriplesImproved {

	public static void main(final String[] args) {
		final Stream<double[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100)
						.mapToObj(b -> new double[] { a, b, Math.sqrt(a * a + b * b) })
						.filter(t -> t[2] % 1 == 0));

		pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));

		System.out.println(
				"max length: " + Stream.of("Java 8 ", "Lambdas ", "In ", "Action").mapToInt(String::length).summaryStatistics().getMax());

		System.out.println(
				"statistics: " + Stream.of("Java 8 ", "Lambdas ", "In ", "Action").mapToInt(String::length).summaryStatistics());
		System.out.println("max length: " + Stream.of("Java 8 ", "Lambdas ", "In ", "Action").mapToInt(String::length).max().orElse(0));
		System.out.println(
				"statistics: " + Stream.of("Java 8 ", "Lambdas ", "In ", "Action").collect(Collectors.summarizingInt(String::length)));

		System.out.println(
				"max length: "
						+ Stream.of("Java 8 ", "Lambdas ", "In ", "Action").collect(Collectors.summarizingInt(String::length)).getMax());

		System.out.println(
				"sum of length: " + Stream.of("Java 8 ", "Lambdas ", "In ", "Action")
						.collect(Collectors.reducing(0, String::length, (i, j) -> i + j)));

		System.out.println(
				"sum of length: " + Stream.of("Java 8 ", "Lambdas ", "In ", "Action")
						.collect(Collectors.reducing(0, String::length, Integer::sum)));

		System.out.println(
				"max of length: " + Stream.of("Java 8 ", "Lambdas ", "In ", "Action")
						.collect(Collectors.reducing(0, String::length, Integer::max)));

		System.out.println(
				"max of length: " + Stream.of("Java 8 ", "Lambdas ", "In ", "Action")
						.collect(Collectors.reducing(0, String::length, Integer::max)));

		// stream.map(String::toUpperCase).forEach(System.out::println);
		final int[] numbers = { 1, 2, 3, 4 };
		System.out.println(Arrays.stream(numbers).sum());
		System.out.println(Arrays.stream(numbers).reduce(0, (a, b) -> a * a + b * b));

	}

}

