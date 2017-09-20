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

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {

	public static void main(final String[] args) {
		final Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);

		final int[] numbers = { 1, 2, 3, 4, 5 };
		final int sum = Arrays.stream(numbers).sum();
		System.out.println(sum);

		long uniqueWords = 0;
		try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
		} catch (final IOException e) {

		}
		System.out.println(uniqueWords);

		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

		final IntSupplier fib = new IntSupplier() {
			private int previous = 0;
			private int current = 1;

			@Override
			public int getAsInt() {
				final int oldPrevious = this.previous;
				final int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return oldPrevious;
			}
		};
		IntStream.generate(fib).limit(10).forEach(System.out::println);

		final IntStream twos = IntStream.generate(() -> 2);
		twos.limit(5).forEach(System.out::println);

	}

}

