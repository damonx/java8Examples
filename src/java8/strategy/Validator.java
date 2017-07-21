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
package java8.strategy;

public class Validator {
	private final ValidationStrategy strategy;

	public Validator(final ValidationStrategy v) {
		this.strategy = v;
	}

	public boolean validate(final String s) {
		return this.strategy.execute(s);
	}
}

