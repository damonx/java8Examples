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
package singleton;

public class Emperor {
	private static final Emperor emperor = new Emperor();

	private Emperor() {

	}

	public static Emperor getInstance() {
		return emperor;
	}

	public void say() {
		System.out.println("I am emperor DAMON");
	}
}

