/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2016).
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package dp.flyweight;

public class Waitress {
	// coffee array
	private static Coffee[] coffees = new Coffee[20];
	// table array
	private static CoffeeContext[] tables = new CoffeeContext[20];
	private static int ordersCount = 0;
	private static CoffeeFactory coffeeFactory;

	public static void takeOrder(final String flavorIn, final int table) {
		coffees[ordersCount] = coffeeFactory.getCoffeeFlavor(flavorIn);
		tables[ordersCount] = new CoffeeContext(table);
		ordersCount++;
	}

	public static void main(final String[] args) {
		coffeeFactory = new CoffeeFactory();

		takeOrder("Cappuccino", 2);
		takeOrder("Cappuccino", 2);
		takeOrder("Regular Coffee", 1);
		takeOrder("Regular Coffee", 2);
		takeOrder("Regular Coffee", 3);
		takeOrder("Regular Coffee", 4);
		takeOrder("Cappuccino", 4);
		takeOrder("Cappuccino", 5);
		takeOrder("Regular Coffee", 3);
		takeOrder("Cappuccino", 3);

		for (int i = 0; i < ordersCount; ++i) {
			coffees[i].serveCoffee(tables[i]);
		}

		System.out.println("\nTotal Coffee objects made: " + coffeeFactory.getTotalCoffeeFlavorsMade());
	}
}

