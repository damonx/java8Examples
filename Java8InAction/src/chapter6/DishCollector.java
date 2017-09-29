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
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import chapter4.model.Dish;
import chapter5.DishFactory;

public class DishCollector {
	public static void main(final String[] args) {
		final List<Dish> menu = DishFactory.createMenu();
		final Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(comparingInt(Dish::getCalories)));
		mostCalorieDish.ifPresent(dish -> System.out.println(dish.getName() + ":" + dish.getCalories()));
		System.out.println("Total Calories: " + menu.stream().collect(summingInt(Dish::getCalories)));
		System.out.println("Average Calories: " + menu.stream().collect(averagingInt(Dish::getCalories)));
		final IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics);

		// joining
		final String shortMenu = menu.stream().map(Dish::getName).collect(joining(","));
		System.out.println(shortMenu);

		//collect
		final int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
		System.out.println(totalCalories);

		// GroupingBy
		final Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
		System.out.println(dishesByType);
		final Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(dish->{
			if(dish.getCalories()<=400) {
				return CaloricLevel.DIET;
			} else if (dish.getCalories() <= 700) {
				return CaloricLevel.NORMAL;
			} else {
				return CaloricLevel.FAT;
			}
		}));
		System.out.println(dishesByCaloricLevel);

		// Multilevel grouping
		final Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
				.collect(groupingBy(Dish::getType, groupingBy(dish -> {
					if (dish.getCalories() <= 400) {
						return CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return CaloricLevel.NORMAL;
					} else {
						return CaloricLevel.FAT;
					}
				})));
		System.out.println(dishesByTypeCaloricLevel);

		//Other groupings
		final Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
		System.out.println(typesCount);

		final Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
				.collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
		System.out.println(mostCaloricByType);

		final Map<Dish.Type, Dish> mostCaloricByType1 = menu.stream()
				.collect(groupingBy(Dish::getType, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
		System.out.println(mostCaloricByType1);
	}
}

