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
package java8.thread.visitor;

public class Cube implements Element {

	private double width;
	private double weight;

	public Cube(final double width, final double weight) {
		this.width = width;
		this.weight = weight;
	}

	public double getWidth() {
		return this.width;
	}

	public void setWidth(final double width) {
		this.width = width;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(final double weight) {
		this.weight = weight;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final Cube cube = (Cube) o;

		if (Double.compare(cube.weight, this.weight) != 0) {
			return false;
		}
		if (Double.compare(cube.width, this.width) != 0) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		temp = Double.doubleToLongBits(this.width);
		result = (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.weight);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public void accept(final Visitor visitor) {
		visitor.visit(this);
	}

}

