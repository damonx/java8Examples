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

import java.util.Random;

public class Sale extends AbstractColleague {

	public Sale(final AbstractMediator mediator) {
		super(mediator);
	}

	public void sellIBMComputer(final int number) {
		super.mediator.execute("sale.sell", number);
	}

	public int getSaleStatus() {
		final Random rand = new Random(System.currentTimeMillis());
		final int saleStatus = rand.nextInt(100);
		System.out.println("IBM sale status: " + saleStatus);
		return saleStatus;
	}

	public void offSale() {
		super.mediator.execute("sale.offsell");
	}

}

