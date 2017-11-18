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

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import chapter1.Apple;

public class SortApples {

	public static void main(final String[] args) {
		final List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
		inventory.sort(comparing(Apple::getWeight));
		System.out.println(inventory);
		inventory.sort(comparing(Apple::getWeight).reversed());
		System.out.println(inventory);

		inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
		System.out.println(inventory);

		final Predicate<Apple> redApple = apple -> apple.getColor().equals("red");
		inventory.stream().filter(redApple).forEach(System.out::println);
		final Predicate<Apple> notRedApple = redApple.negate();
		inventory.stream().filter(notRedApple).forEach(System.out::println);
		final Predicate<Apple> redAndHeavyApple = redApple.and(a -> a.getWeight() > 100);
		inventory.stream().filter(redAndHeavyApple).forEach(System.out::println);
		final Predicate<Apple> redAndHeavyAppleOrGreen = redApple.and(a -> a.getWeight() > 100).or(a -> "green".equals(a.getColor()));
		inventory.stream().filter(redAndHeavyAppleOrGreen).forEach(System.out::println);
	}

}
