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
import java.util.Arrays;
import java.util.List;

public class StreamTest {

	public static void main(final String[] args) {

		final List<String> genre = new ArrayList<>(Arrays.asList("rock", "pop", "jazz", "reggae"));
		System.out.println(genre.stream().reduce((b, c) -> b.concat(",").concat(c)).orElse("failed"));

		System.out.println(genre.stream().reduce(0, (b, c) -> b + c.length(), (b, c) -> b + c));
	}

}