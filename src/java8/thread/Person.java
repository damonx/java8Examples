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

public class Person {
	private final int no;
	private final String name;

	public Person(final int no, final String name) {
		this.no = no;
		this.name = name;
	}

	public String getName() {
		System.out.println(this.name);
		return this.name;
	}

	public int getNo() {
		return this.no;
	}
}

