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

public class Apple {
	private int weight = 0;
	private String color = "";

	public Apple() {
	}

	public Apple(final int weight) {
		this.weight = weight;
	}

	public Apple(final int weight, final String color) {
		this.weight = weight;
		this.color = color;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(final Integer weight) {
		this.weight = weight;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(final String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Apple{" +
				"color='" + this.color + '\'' +
				", weight=" + this.weight +
				'}';
	}
}
