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

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

	public static void testValue(final List<Predicate<Double>> predicates, final Double d) {
		predicates.forEach(p -> {
			System.out.println(p.test(d));
		});

	}

	public static void main(final String[] args) {
		final List<Predicate<Double>> predicates = Arrays.asList(x -> x > 5, x -> x < -10);
		testValue(predicates, 10D);

	}

}

