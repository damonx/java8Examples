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

public class Trader {
	private final String name;
	private final String city;

	public Trader(final String name, final String city) {
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return this.name;
	}

	public String getCity() {
		return this.city;
	}

	public boolean from(final String fromCity) {
		return this.city.equals(fromCity);
	}
	@Override
	public String toString() {
		return "Trader:" + this.name + " in " + this.city;
	}
}

