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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestLine {

	public static void main(final String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new FileReader("/Users/damonx/uploader.py"));
		// final int longest = br.lines().mapToInt(String::length).max().getAsInt();
		// System.out.println(longest);

		final List<String> words = br.lines().flatMap(line -> Stream.of(line.split(" "))).filter(word -> word.length() > 0)
				.map(String::toLowerCase).distinct().sorted().collect(Collectors.toList());
		br.close();
		System.out.println(words);

	}

}

