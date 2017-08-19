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
package factoryMethod.creator;

import factoryMethod.product.BlackHuman;
import factoryMethod.product.Human;
import factoryMethod.product.WhiteHuman;
import factoryMethod.product.YellowHuman;

public class God {
	public static void main(final String[] args) {
		final AbstractHumanFactory yinYangFurnace = new HumanFactory();
		System.out.println("--Creating White Human--");
		final Human whiteHuman = yinYangFurnace.createHuman(WhiteHuman.class);
		whiteHuman.getColor();
		whiteHuman.talk();

		System.out.println("--Creating Yellow Human--");
		final Human yellowHuman = yinYangFurnace.createHuman(YellowHuman.class);
		yellowHuman.getColor();
		yellowHuman.talk();

		System.out.println("--Creating Black Human--");
		final Human blackHuman = yinYangFurnace.createHuman(BlackHuman.class);
		blackHuman.getColor();
		blackHuman.talk();

	}
}

