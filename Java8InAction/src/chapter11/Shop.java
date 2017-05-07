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
package chapter11;

import java.util.Random;


public class Shop {
	private final String name;
	private final Random random;

	public Shop(final String name) {
		this.name = name;
		this.random = new Random();
	}

	public String getPrice(final String product) {
		final double price = calculatePrice(product, ()->Util.delay());
		final Discount.Code code = Discount.Code.values()[this.random.nextInt(Discount.Code.values().length)];
		return this.name + ":" + price + ":" + code;
	}
	
	public String getPriceRandom(final String product) {
		final double price = calculatePrice(product, ()->Util.randomDelay());
		final Discount.Code code = Discount.Code.values()[this.random.nextInt(Discount.Code.values().length)];
		return this.name + ":" + price + ":" + code;
	}


	public double getUnitPrice(final String product) {
		return calculatePrice(product,  ()->Util.delay());
	}
	
	private double calculatePrice(final String product, Delay d) {
		d.delay();
		return Util.format(this.random.nextDouble() * product.charAt(0) + product.charAt(1));
	}

	public String getName() {
		return this.name;
	}
}

