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

import java.util.HashMap;
import java.util.Map;

public class CoffeeFactory {
	private final Map<String, Coffee> flavors = new HashMap<>();

	public Coffee getCoffeeFlavor(final String flavorName) {
		Coffee flavor = this.flavors.get(flavorName);
		if (flavor == null) {
			flavor = new Coffee(flavorName);
			this.flavors.put(flavorName, flavor);
		}
		return flavor;
	}

	public int getTotalCoffeeFlavorsMade() {
		return this.flavors.size();
	}
}

