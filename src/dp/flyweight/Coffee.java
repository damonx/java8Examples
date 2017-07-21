/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2016).
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package dp.flyweight;

public class Coffee implements ICoffee {

	private final String flavor;

	public Coffee(final String newFlavor) {
		this.flavor = newFlavor;
		System.out.println("Coffee is created! - " + this.flavor);
	}

	public String getFlavor() {
		return this.flavor;
	}

	@Override
	public void serveCoffee(final CoffeeContext context) {
		System.out.println("Serving " + this.flavor + " to table " + context.getTable());
	}

}

