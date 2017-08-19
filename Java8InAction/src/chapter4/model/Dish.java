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
package chapter4.model;

public class Dish {
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

	public enum Type {
		MEAT,
		FISH,
		OTHER
	}

	public Dish(final String name, final boolean vegetarian, final int calories, final Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public boolean isVegetarian() {
		return this.vegetarian;
	}

	public int getCalories() {
		return this.calories;
	}

	public Type getType() {
		return this.type;
	}

	@Override
	public String toString() {
		return this.name;
	}
}

