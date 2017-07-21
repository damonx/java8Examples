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

public class Sphere implements Element {

	private double radius;
	private double weight;

	public Sphere(final double radius, final double weight) {
		this.radius = radius;
		this.weight = weight;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(final double weight) {
		this.weight = weight;
	}

	public double getRadius() {
		return this.radius;
	}

	public void setRadius(final double radius) {
		this.radius = radius;
	}

	@Override
	public void accept(final Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final Sphere sphere = (Sphere) o;

		if (Double.compare(sphere.radius, this.radius) != 0) {
			return false;
		}
		if (Double.compare(sphere.weight, this.weight) != 0) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		temp = Double.doubleToLongBits(this.radius);
		result = (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.weight);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

}

