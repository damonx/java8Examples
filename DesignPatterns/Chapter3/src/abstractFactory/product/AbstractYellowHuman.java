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
package abstractFactory.product;

public abstract class AbstractYellowHuman implements Human {

	@Override
	public void getColor() {
		System.out.println("Yellow human yellow skin");
	}

	@Override
	public void talk() {
		System.out.println("Yellow human is speaking");
	}

}
