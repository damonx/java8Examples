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
package mediator;

public class Stock extends AbstractColleague {

	public Stock(final AbstractMediator mediator) {
		super(mediator);
	}

	private static int COMPUTER_NUMBER = 100;

	public void increase(final int number) {
		COMPUTER_NUMBER += number;
		System.out.println("stock number: " + COMPUTER_NUMBER);
	}

	public void decrease(final int number) {
		COMPUTER_NUMBER -= number;
		System.out.println("stock number: " + COMPUTER_NUMBER);
	}

	public int getStockNumber() {
		return COMPUTER_NUMBER;
	}

	public void clearStock() {
		System.out.println("Clear stock: " + COMPUTER_NUMBER);
		super.mediator.execute("stock.clear");
	}
}

