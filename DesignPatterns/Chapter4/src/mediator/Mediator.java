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

public class Mediator extends AbstractMediator {

	@Override
	public void execute(final String str, final Integer... number) {
		switch (str) {
			case "purchase.buy":
				buyComputer(number[0]);
				break;
			case "sale.sell":
				sellComputer(number[0]);
				break;
			case "sale.offsell":
				offSell();
				break;
			case "stock.clear":
				clearStock();
				break;
			default:
				break;
		}
	}

	private void buyComputer(final int number) {
		final int saleStatus = super.sale.getSaleStatus();
		if (saleStatus > 80) {
			System.out.println("Purchased IBM: " + number);
			super.stock.increase(number);
		} else {
			final int buyNumber = number / 2;
			super.stock.increase(buyNumber);
			System.out.println("Purchase IBM: " + buyNumber);
		}
	}

	private void sellComputer(final int number) {
		if (super.stock.getStockNumber() < number) {
			super.purchase.buyIBMcomputer(number);
		}
		super.stock.decrease(number);
	}

	private void offSell() {
		System.out.println("Off sold IBM: " + this.stock.getStockNumber());
		this.stock.decrease(this.stock.getStockNumber());
	}

	private void clearStock() {
		super.sale.offSale();
		super.purchase.refuseBuyIBM();
	}

}

