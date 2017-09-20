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

public abstract class HummerModel {
	protected abstract void start();

	protected abstract void stop();

	protected abstract void alarm();

	protected abstract void engineBoom();

	public void run() {
		start();
		engineBoom();
		if (isAlarmHook()) {
			alarm();
		}
		stop();
	}

	protected boolean isAlarmHook() {
		return true;
	}

}

