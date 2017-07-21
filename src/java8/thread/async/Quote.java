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
package java8.thread.async;

public class Quote {

	private final String shopName;
	private final double price;
	private final Discount.Code discountCode;

	public Quote(final String shopName, final double price, final Discount.Code discountCode) {
		this.shopName = shopName;
		this.price = price;
		this.discountCode = discountCode;
	}

	public static Quote parse(final String s) {
		final String[] split = s.split(":");
		final String shopName = split[0];
		final double price = Double.parseDouble(split[1]);
		final Discount.Code discountCode = Discount.Code.valueOf(split[2]);
		return new Quote(shopName, price, discountCode);
	}

	public String getShopName() {
		return this.shopName;
	}

	public double getPrice() {
		return this.price;
	}

	public Discount.Code getDiscountCode() {
		return this.discountCode;
	}
}

