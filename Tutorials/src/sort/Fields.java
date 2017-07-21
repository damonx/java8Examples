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
package sort;

public enum Fields {
	LAST_NAME("Last Name"),
	FIRST_NAME("First Name");

	private final String fieldDescription;

	private Fields(final String value) {
		this.fieldDescription = value;
	}

	public String getFieldDescription() {
		return this.fieldDescription;
	}

	public static void main(final String... args) {
		System.out.println(Fields.FIRST_NAME.name());
	}
}

