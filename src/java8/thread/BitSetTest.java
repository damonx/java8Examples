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
package java8.thread;

import java.util.BitSet;

public class BitSetTest {
	public static void main(final String[] args) {

		final BitSet b = new BitSet(5);
		b.set(3);
		b.set(4);

		// Display first five bits.
		for (int i = 0; i < 5; i++) {
			System.out.println(b.get(i));
		}
	}
}


