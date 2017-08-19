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

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import chapter4.model.Dish;

public class DishDemo {

	public static void main(final String[] args) {
		final List<Dish> menu =DishFactory.createMenu();
		final List<Dish> veg = menu.stream().filter(Dish::isVegetarian).collect(toList());
		System.out.println(veg);

		menu.stream().filter(d -> d.getCalories() > 300).limit(3).forEach(System.out::println);

		System.out.println("------");
		menu.stream().filter(d -> d.getCalories() > 300).skip(2).forEach(System.out::println);

		// Covert to a primitive stream
		final int calories = menu.stream().mapToInt(Dish::getCalories).sum();
		System.out.println("Total Calories: " + calories);
		final IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
		intStream.boxed().forEach(c -> System.out.println(c.getClass()));

		final OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
		System.out.println(maxCalories.orElse(1));

	}

}

