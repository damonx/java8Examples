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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FibonacciCache {
	static Map<Integer, Integer> cache = new ConcurrentHashMap<>();
	static int fibonacci(final int i) {
		if (i == 0) {
			return i;
		}

		if (i == 1) {
           return 1;
		}

		return cache.computeIfAbsent(i, (key) -> fibonacci(i - 2) + fibonacci(i - 1));
	}

	public static void main(final String[] args) {
		for (int i = 0; i < 11; i++) {
			System.out.println(fibonacci(i));
		}
	}
}

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...