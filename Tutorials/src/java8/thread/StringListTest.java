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

public class StringListTest {

	public static void main(final String[] args) {
		final List<String> strings = new ArrayList<String>();
		// strings.add("one");
		// strings.add("two");
		// strings.add("three");
		strings.stream().findFirst().orElse(null);

	}

}

