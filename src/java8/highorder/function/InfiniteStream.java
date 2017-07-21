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
package java8.highorder.function;

import java.util.stream.Stream;

public class InfiniteStream {

	public static void main(final String[] args) {
		Stream.iterate(1, n -> n * 2)
				.limit(11).forEach(System.out::println);

		Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] }).limit(5)
				.forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

		Stream.iterate(new long[] { 0, 1 }, f -> new long[] { f[1], f[0] + f[1] }).limit(5)
				.map(t -> t[0]).forEach(System.out::println);

		Stream.generate(Math::random)
				.limit(5).forEach(System.out::println);

	}

}

