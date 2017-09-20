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

public class HummerH1Model extends HummerModel {
	private boolean alarmFlag = true;

	@Override
	protected void start() {
		System.out.println("H1 Starts");

	}

	@Override
	protected void stop() {

		System.out.println("H1 stops");
	}

	@Override
	protected void alarm() {
		System.out.println("H1 alarms");

	}

	@Override
	protected void engineBoom() {
		System.out.println("H1 EngineBooms");

	}

	@Override
	protected boolean isAlarmHook() {
		return this.alarmFlag;
	}

	public void setAlarm(final boolean isAlarm) {
		this.alarmFlag = isAlarm;
	}
}

