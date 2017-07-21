/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2016).
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package java8.thread;

public class DeadLockDemo {
	public static void main(final String[] args) throws InterruptedException {
		final Object obj1 = new Object();
		final Object obj2 = new Object();
		final Object obj3 = new Object();

		final Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
		final Thread t2 = new Thread(new SyncThread(obj2, obj3), "t2");
		final Thread t3 = new Thread(new SyncThread(obj3, obj1), "t3");

		t1.start();
		Thread.sleep(5000);
		t2.start();
		Thread.sleep(5000);
		t3.start();

	}

}

class SyncThread implements Runnable {
	private final Object objA;
	private final Object objB;

	public SyncThread(final Object o1, final Object o2) {
		this.objA = o1;
		this.objB = o2;
	}

	@Override
	public void run() {
		final String name = Thread.currentThread().getName();
		System.out.println(name + " acquiring lock on " + this.objA);
		synchronized (this.objA) {
			System.out.println(name + " acquired lock on " + this.objA);
			work();
			System.out.println(name + " acquiring lock on " + this.objB);
			synchronized (this.objB) {
				System.out.println(name + " acquired lock on " + this.objB);
				work();
			}
			System.out.println(name + " released lock on " + this.objB);
		}
		System.out.println(name + " released lock on " + this.objA);
		System.out.println(name + " finished execution.");
	}

	private void work() {
		try {
			Thread.sleep(30000);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}
}
