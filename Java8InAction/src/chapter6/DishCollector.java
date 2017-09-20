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
package chapter6;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

import chapter4.model.Dish;
import chapter5.DishFactory;

public class DishCollector {
	public static void main(final String[] args) {
		final List<Dish> menu = DishFactory.createMenu();
		final Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		final Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));
		mostCalorieDish.ifPresent(dish -> System.out.println(dish.getName() + ":" + dish.getCalories()));
		System.out.println("Total Calories: " + menu.stream().collect(summingInt(Dish::getCalories)));
		System.out.println("Average Calories: " + menu.stream().collect(averagingInt(Dish::getCalories)));
		final IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics);

		// joining
		final String shortMenu = menu.stream().map(Dish::getName).collect(joining(","));
		System.out.println(shortMenu);

	}
}

