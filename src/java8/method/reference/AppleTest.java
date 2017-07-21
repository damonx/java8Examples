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
package java8.method.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class AppleTest {

	public static List<Apple> mapToApple(final List<Integer> list, final Function<Integer, Apple> f) {
		final List<Apple> result = new ArrayList<>();
		list.stream().forEach(weight -> result.add(f.apply(weight)));
		return result;
	}

	public static void main(final String[] args) {
		final Supplier<Apple> c1 = Apple::new;
		final Apple a1 = c1.get();
		a1.getClass();

		final Function<Integer, Apple> c2 = Apple::new;
		final Apple a2 = c2.apply(10);
		System.out.println(a2.getWeight());

		final BiFunction<Integer, String, Apple> c3 = Apple::new;
		final Apple a3 = c3.apply(12, "red");
		System.out.println(String.format("Apple weight %d, Apple color %s", a3.getWeight(), a3.getColor()));

		final List<Integer> weights = Arrays.asList(7, 3, 4, 10);
		final List<Apple> apples = mapToApple(weights, Apple::new);
		apples.stream().map(a -> a.getWeight()).forEach(System.out::println);


	}
}

