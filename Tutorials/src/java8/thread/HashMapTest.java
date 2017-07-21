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

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(final String[] args) {
		final Map<String, Integer> authorBooks = new HashMap<>();
		authorBooks.put("Robert Ludlum", 27);
		authorBooks.put("Clive Cussler", 50);
		authorBooks.put("Tom Clancy", 17);
		printBooks(authorBooks);

		authorBooks.compute("Clive Cussler", (a, b) -> b + 1);
		printBooks(authorBooks);

		authorBooks.computeIfAbsent("Agatha Christie", b -> b.length());
		printBooks(authorBooks);

		authorBooks.computeIfPresent("Tom Clancy", (a, b) -> b + 1);
		printBooks(authorBooks);

		authorBooks.merge("DamonX", 1, (a, b) -> a + b);
		System.out.println(authorBooks.get("DamonX"));// 1
		authorBooks.merge("DamonX", 7, (a, b) -> a + b);
		System.out.println(authorBooks.get("DamonX"));// 2
		System.out.println("------------------");
		System.out.println(authorBooks.putIfAbsent("AuthorC", 2));
		System.out.println(authorBooks.putIfAbsent("AuthorC", 2));
		printBooks(authorBooks);
		authorBooks.remove("AuthorC", 2);
		printBooks(authorBooks);

		authorBooks.replace("DamonX", 8, 18);
		printBooks(authorBooks);

		authorBooks.replaceAll((a, b) -> a.length() + b);
		printBooks(authorBooks);

	}

	private static void printBooks(final Map<String, Integer> authorBooks) {
		authorBooks.forEach((a, b) -> System.out.println(a + " wrote " + b + " books"));
		System.out.println("------------------");
	}

}

