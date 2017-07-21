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
package java8.method.reference;

public class Color {
	private final Integer r;
	private final Integer g;
	private final Integer b;

	public Color(final Integer r, final Integer g, final Integer b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public Integer getR() {
		return this.r;
	}

	public Integer getG() {
		return this.g;
	}

	public Integer getB() {
		return this.b;
	}

}

