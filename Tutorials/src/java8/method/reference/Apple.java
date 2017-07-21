/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2017).
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package java8.method.reference;

public class Apple {

	private Integer weight;
	private String color;

	public Apple() {
	}

	public Apple(final Integer weight) {
		this.weight = weight;
	}

	public Apple(final Integer weight, final String color) {
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

}

