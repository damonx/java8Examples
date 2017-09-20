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

public class Purchase extends AbstractColleague {

	public Purchase(final AbstractMediator mediator) {
		super(mediator);
	}

	public void buyIBMcomputer(final int number) {
		super.mediator.execute("purchase.buy", number);
	}

	public void refuseBuyIBM() {
		System.out.println("Refused to buy IBM computers.");
	}
}

