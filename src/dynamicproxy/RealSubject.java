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
package dynamicproxy;

public class RealSubject implements Subject {

	@Override
	public void rent() {
		System.out.println("I want to rent my house");

	}

	@Override
	public void hello(final String str) {
		System.out.println("hello: " + str);

	}

}

