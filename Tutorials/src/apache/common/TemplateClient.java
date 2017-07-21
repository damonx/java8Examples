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

public class TemplateClient {
	public static void main(final String[] args) {
		final AbstractBase base1 = new ConcreteClassA();
		base1.algorithm();

		final AbstractBase base2 = new ConcreteClassB();
		base2.algorithm();
	}
}

