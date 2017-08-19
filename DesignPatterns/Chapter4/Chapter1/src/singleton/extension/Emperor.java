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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Emperor {
	private static int maxNumOfEmperor = 2;
	private static List<String> names = new ArrayList<>();
	private static List<Emperor> emperors = new ArrayList<>();
	private static int countNumOfEmperor = 0;

	static {
    	for (int i=0; i<maxNumOfEmperor; i++){
			emperors.add(new Emperor("Emperor " + (i + 1)));
    	}
    }

	private Emperor() {
	}

	private Emperor(final String name) {
		names.add(name);
	}

	public static Emperor getInstance() {
		final Random random = new Random();
		countNumOfEmperor = random.nextInt(maxNumOfEmperor);
		return emperors.get(countNumOfEmperor);
	}

	public void say() {
		System.out.println(names.get(countNumOfEmperor));
	}
}

