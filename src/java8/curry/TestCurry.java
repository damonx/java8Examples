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
package java8.curry;

import java.util.function.DoubleUnaryOperator;

public class TestCurry {

	public static DoubleUnaryOperator curriedConverter(final double f, final double b) {
		return (final double x) -> x * f + b;
	}

	public static void main(final String[] args) {
		final DoubleUnaryOperator convertCtoF = curriedConverter(9.0 / 5, 32);
		// final DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
		// final DoubleUnaryOperator convertKmtoMi = curriedConverter(0.6214, 0);

		System.out.println("ctoF of 10 : " + convertCtoF.applyAsDouble(10.0));

	}

}

