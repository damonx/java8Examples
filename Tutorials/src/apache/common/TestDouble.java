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
package apache.common;

import java.util.Set;
import java.util.TreeSet;

public class TestDouble {
	public static void processDouble(final Long num) {
		processPrimitiveDouble(num);
    }

	public static void processPrimitiveDouble(final long num) {
		System.out.println(num);
	}

	public static void main(final String[] args) {
		// processDouble(null);
		final Set<Integer> set = new TreeSet<>();
		set.add(3);
		set.add((int) 3.0);
		set.add(2);
		set.add(2);
		set.add(new Integer(2));
		set.add(Integer.parseInt("2"));
		System.out.println(set);

	}


}

