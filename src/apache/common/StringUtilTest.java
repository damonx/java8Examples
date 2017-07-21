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
package apache.common;

public class StringUtilTest {

	public static void main(final String[] args) {
		final String testStr = " asdf  ";
		System.out.println(testStr.trim());

		final String errorMessageTemplate = "%s must not be derived when a healthcare service derivation is present or Referral is already associated with a healthcare service. This value can only be updated by updating healthcare service as the %s value will be derived to %s.";
		System.out.println(String.format(errorMessageTemplate, "damon", "zoe"));
	}

}

