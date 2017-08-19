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

public class Transaction {
	private final Trader trader;
	private final int year;
	private final int value;

	public Transaction(final Trader trader, final int year, final int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Trader getTrader() {
		return this.trader;
	}

	public int getYear() {
		return this.year;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return "{" + this.trader + ", " +
				"year: " + this.year + ", " + "value:" + this.value + "}";
	}

}

