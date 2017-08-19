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

import java.util.Arrays;
import java.util.List;

import chapter4.model.Dish;

public class DishMap {
	public static void main(final String[] args) {
		final List<Dish> menu = DishFactory.createMenu();
		menu.stream().map(Dish::getName).collect(toList()).forEach(System.out::println);

		final List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		final List<Integer> wordLengths = words.stream()
				.map(String::length).collect(toList());
		System.out.println(wordLengths);
	}
}

