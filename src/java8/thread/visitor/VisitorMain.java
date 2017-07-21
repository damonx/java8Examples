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
package java8.thread.visitor;

import java.util.Arrays;

public class VisitorMain {

	static Visitor volumeVisitor = (final Element figure) -> {
		if (figure instanceof Cube) {
			final Cube cube = (Cube) figure;
			final double volume = Math.pow(cube.getWidth(), 3);
			System.out.printf("cube [width=%.2f] has volume=%.2f \n", cube.getWidth(), volume);
		} else if (figure instanceof Sphere) {
			final Sphere sphere = (Sphere) figure;
			final double volume = (4d / 3) * Math.PI * Math.pow(sphere.getRadius(), 3);
			System.out.printf("sphere [radius=%.2f] has volume=%.2f \n", sphere.getRadius(), volume);
		} else if (figure instanceof FiguresHolder) {
			for (final Element element : ((FiguresHolder) figure).getFigures()) {
				VisitorMain.volumeVisitor.visit(element);
			}
		} else {
			throw new IllegalArgumentException();
		}
	};

	static Visitor weightVisitor = (final Element figure) -> {
		if (figure instanceof Cube) {
			final Cube cube = (Cube) figure;
			System.out.printf("cube [width=%.2f] has weight=%.2f \n", cube.getWidth(), cube.getWeight());
		} else if (figure instanceof Sphere) {
			final Sphere sphere = (Sphere) figure;
			System.out.printf("sphere [radius=%.2f] has weight=%.2f \n", sphere.getRadius(), sphere.getWeight());
		} else if (figure instanceof FiguresHolder) {
			for (final Element element : ((FiguresHolder) figure).getFigures()) {
				VisitorMain.weightVisitor.visit(element);
			}
		} else {
			throw new IllegalArgumentException();
		}
	};

	public static void main(final String[] args) {
		final FiguresHolder figuresHolder = new FiguresHolder(Arrays.asList(new Cube(2, 12), new Sphere(1, 12), new Sphere(2, 12)));
		Arrays.asList(volumeVisitor, weightVisitor).stream().forEach(figuresHolder::accept);
	}

}

