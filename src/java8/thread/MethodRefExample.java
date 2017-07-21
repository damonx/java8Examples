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

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

public class MethodRefExample {
	public int add(final int a, final int b) {
		return a + b;
	}

	public static int mul(final int a, final int b) {
		return a * b;
	}

	public String lower(final String a) {
		return a.toLowerCase();
	}

	public void printDate(final Date date) {
		System.out.println(date);
	}

	public void oper(final IntBinaryOperator operator, final int a, final int b) {
		System.out.println(operator.applyAsInt(a, b));
	}

	public void operS(final Function<String, String> stringOperator, final String a) {
		System.out.println(stringOperator.apply(a));
	}

	public GregorianCalendar operC(final Supplier<GregorianCalendar> supplier) {
		return supplier.get();
	}

	public static void main(final String[] args) {
		final MethodRefExample ex = new MethodRefExample();
		ex.oper(MethodRefExample::mul, 3, 4);
		ex.oper(ex::add, 1, 2);
		ex.operS(String::toLowerCase, "DAMON");
		ex.operC(GregorianCalendar::new);

	}
}

