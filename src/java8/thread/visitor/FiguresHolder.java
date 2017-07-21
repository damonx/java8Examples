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

import java.util.List;

public class FiguresHolder implements Element {

	public List<Element> getFigures() {
		return this.figures;
	}

	private final List<Element> figures;

	public FiguresHolder(final List<Element> figures) {
		this.figures = figures;
	}

	@Override
	public void accept(final Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final FiguresHolder that = (FiguresHolder) o;

		if (!this.figures.equals(that.figures)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return this.figures.hashCode();
	}

}

