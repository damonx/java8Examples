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
package factoryMethod.singleton;

import java.lang.reflect.Constructor;

public class SingletonFactory {
	private static Singleton singleton;
	static {
		try {
			@SuppressWarnings("unchecked")
			final Class<Singleton> cl = (Class<Singleton>) Class.forName(Singleton.class.getName());
			final Constructor<Singleton> constructor = cl.getDeclaredConstructor();
			constructor.setAccessible(true);
			singleton = constructor.newInstance();
		} catch (final Exception e) {
		}
	}

	public static Singleton getSingleton() {
		return singleton;
	}
}

