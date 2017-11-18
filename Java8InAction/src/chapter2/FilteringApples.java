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
package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chapter1.Apple;

public class FilteringApples {

	public static void main(final String[] args) {
		final List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		final List<Apple> greenApples = filterApplesByColor(inventory, "green");
		System.out.println(greenApples);

		// [Apple{color='red', weight=120}]
		final List<Apple> redApples = filterApplesByColor(inventory, "red");
		System.out.println(redApples);

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		final List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
		System.out.println(greenApples2);

		// [Apple{color='green', weight=155}]
		final List<Apple> heavyApples = filter(inventory, apple -> apple.getWeight() > 150);
		System.out.println(heavyApples);

		// []
		final List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
		System.out.println(redAndHeavyApples);

		// [Apple{color='red', weight=120}]
		final List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
			@Override
			public boolean test(final Apple a) {
				return a.getColor().equals("red");
			}
		});
		System.out.println(redApples2);
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

	public static List<Apple> filterApplesByColor(final List<Apple> inventory, final String color) {
		final List<Apple> result = new ArrayList<>();
		for (final Apple apple : inventory) {
			if (apple.getColor().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByWeight(final List<Apple> inventory, final int weight) {
		final List<Apple> result = new ArrayList<>();
		for (final Apple apple : inventory) {
			if (apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filter(final List<Apple> inventory, final ApplePredicate p) {
		final List<Apple> result = new ArrayList<>();
		for (final Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	static class AppleWeightPredicate implements ApplePredicate {
		@Override
		public boolean test(final Apple apple) {
			return apple.getWeight() > 150;
		}
	}

	static class AppleColorPredicate implements ApplePredicate {
		@Override
		public boolean test(final Apple apple) {
			return "green".equals(apple.getColor());
		}
	}

	static class AppleRedAndHeavyPredicate implements ApplePredicate {
		@Override
		public boolean test(final Apple apple) {
			return "red".equals(apple.getColor())
					&& apple.getWeight() > 150;
		}
	}

}
