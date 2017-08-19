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
package abstractFactory.creator;

import abstractFactory.product.Human;

public class NvWa {

	public static void main(final String[] args) {
		final HumanFactory maleHumanFactory = new MaleFactory();
		final HumanFactory femaleHumanFactory = new FemaleFactory();

		final Human maleYellowHuman = maleHumanFactory.createYellowHuman();
		final Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();
		System.out.println("--Produced a female yellow human--");
		femaleYellowHuman.getColor();
		femaleYellowHuman.talk();
		femaleYellowHuman.getSex();
		System.out.println("--Produced a male yellow human--");
		maleYellowHuman.getColor();
		maleYellowHuman.talk();
		maleYellowHuman.getSex();
	}

}

