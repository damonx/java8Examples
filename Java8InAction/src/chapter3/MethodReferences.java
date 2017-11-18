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
package chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import chapter1.Apple;

public class MethodReferences {

	public static void main(final String[] args) {
		final List<String> str = Arrays.asList("a", "b", "A", "B");
		str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		str.sort(String::compareToIgnoreCase);

		// Default constructor
		final Supplier<Apple> c1 = Apple::new;
		System.out.println("APPLE: " + c1.get().getColor());
		final Supplier<Apple> c2 = () -> new Apple();
		System.out.println("" + c2.get().getColor());

		// Constructor having one parameter.
		final Function<Integer, Apple> c3 = Apple::new;
		System.out.println("" + c3.apply(110).getWeight());
		final List<Integer> weights = Arrays.asList(5, 3, 4, 6);
		final List<Apple> apples = map(weights, Apple::new);
		System.out.println("APPLES: " + apples.toString());

		// Constructor having two parameters.
		final BiFunction<Integer, String, Apple> c4 = Apple::new;
		System.out.println("" + c4.apply(110, "red"));

	}

	public static List<Apple> map(final List<Integer> list, final Function<Integer, Apple> f) {
		return list.stream().map(e -> f.apply(e)).collect(Collectors.toList());
	}

}
