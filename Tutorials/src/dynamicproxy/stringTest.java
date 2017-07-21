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

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class stringTest {

	public static void main(final String[] args) {
		System.out.println(Pattern.compile(" and ")
				.splitAsStream("default and disabled")
				.map(String::toUpperCase).collect(Collectors.toList()));

	}

}

