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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LimitSkipTest {
	public static void main(final String[] args) {
		final List<Person> persons = new ArrayList<>();
		for (int i = 1; i <= 10000; i++) {
			final Person person = new Person(i, "name" + i);
			persons.add(person);
		}
		final List<String> personList2 = persons.stream().map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
		System.out.println(personList2);

		final List<Person> persons1 = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			final Person person = new Person(i, "name" + i);
			persons1.add(person);
		}
		final List<Person> personList3 = persons1.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).limit(2)
				.collect(Collectors.toList());
		System.out.println(personList3);
	}

}

