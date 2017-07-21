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
package java8.thread.lambdabuilder;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class LambdaPersonBuilderUsingConsumer {
	@FunctionalInterface
	public interface PersonSetter extends Consumer<Person> {
	}

	public static Person build(final PersonSetter... personSetters) {
		final Person person = new Person();
		Stream.of(personSetters).forEach(s -> s.accept(person));
		return person;
	}
}

