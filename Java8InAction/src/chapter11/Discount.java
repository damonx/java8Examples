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

public class Discount {
	public enum Code {
		NONE(0),
		SILVER(5),
		GOLD(10),
		PLATINUM(15),
		DIAMOND(20);

		private final int percentage;

		Code(final int percentage) {
			this.percentage = percentage;
		}

		public int getPercentage() {
			return this.percentage;
		}

	}

	public static String applyDiscount(final Quote quote) {
		return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
	}

	private static double apply(final double price, final Code code) {
		Util.delay();
		return Util.format(price * (100 - code.percentage) / 100);
	}
}

