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
package templateMethod;

public class HummerH2Model extends HummerModel {

	@Override
	public void start() {
		System.out.println("H2 Starts");

	}

	@Override
	public void stop() {

		System.out.println("H2 stops");
	}

	@Override
	public void alarm() {
		System.out.println("H2 alarms");

	}

	@Override
	public void engineBoom() {
		System.out.println("H2 EngineBooms");

	}

	@Override
	protected boolean isAlarmHook() {
		return false;
	}
}

