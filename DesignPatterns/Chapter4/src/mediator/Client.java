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

public class Client {
	public static void main(final String[] args) {
		final AbstractMediator mediator = new Mediator();
		System.out.println("--------- Purchasing computers --------");
		final Purchase purchase = new Purchase(mediator);
		purchase.buyIBMcomputer(100);
		System.out.println("\n--------- Selling computers --------");
		final Sale sale = new Sale(mediator);
		sale.sellIBMComputer(1);
		System.out.println("\n--------- Clearing stocks -----------");
		final Stock stock = new Stock(mediator);
		stock.clearStock();
	}
}

