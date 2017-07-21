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

import java.util.stream.Stream;

public class MapReduceExample {

	public static void main(final String[] args) {
		// 字符串连接，concat = "ABCD"
		final String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
		System.out.println(concat);
		// 求最小值，minValue = -3.0
		// final double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
		// // 求和，sumValue = 10, 有起始值
		// int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
		// // 求和，sumValue = 10, 无起始值
		// sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
		// // 过滤，字符串连接，concat = "ace"
		// concat = Stream.of("a", "B", "c", "D", "e", "F").filter(x -> x.compareTo("Z") > 0).reduce("", String::concat);
	}

}

