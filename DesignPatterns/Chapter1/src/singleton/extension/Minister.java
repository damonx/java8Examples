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
package singleton.extension;

import java.util.stream.IntStream;

public class Minister {

	public static void main(final String[] args) {
		final int ministerNum = 5;
		IntStream.range(0, ministerNum).forEach(m -> {
			final Emperor emperor = Emperor.getInstance();
			System.out.print("No. " + (m + 1) + " to: ");
			emperor.say();
		});
	}

}

