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
package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringApples {
	public static void main(final String... args) {
		final List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
				new Apple(155, "green"),
				new Apple(220, "red"));

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		final List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
		System.out.println(greenApples);

		// [Apple{color='green', weight=155}]
		final List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
		System.out.println(heavyApples);

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		final List<Apple> greenApples2 = filterApples(inventory, a -> "green".equals(a.getColor()));
		System.out.println(greenApples2);

		// [Apple{color='green', weight=155}]
		final List<Apple> heavyApples2 = filterApples(inventory, a -> a.getWeight() > 150);
		System.out.println(heavyApples2);

		// []
		final List<Apple> weirdApples = filterApples(inventory, a -> a.getWeight() < 80 ||
				"brown".equals(a.getColor()));
		System.out.println(weirdApples);
	}

	public static List<Apple> filterGreenApples(final List<Apple> inventory) {
		final List<Apple> result = new ArrayList<>();
		for (final Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterHeavyApples(final List<Apple> inventory) {
		final List<Apple> result = new ArrayList<>();
		for (final Apple apple : inventory) {
			if (apple.getWeight() > 150) {
				result.add(apple);
			}
		}
		return result;
	}

	public static boolean isGreenApple(final Apple apple) {
		return "green".equals(apple.getColor());
	}

	public static boolean isHeavyApple(final Apple apple) {
		return apple.getWeight() > 200;
	}

	public static List<Apple> filterApples(final List<Apple> inventory, final Predicate<Apple> p) {
		return inventory.stream().filter(p::test).collect(Collectors.toList());
	}
}
