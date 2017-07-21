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

public class LambdaBuilderUsingConsumerTest {

	public static void main(final String[] args) {
		final Person person = LambdaPersonBuilderUsingConsumer.build(p -> p.setId(13232323L), p -> p.setName("DamonX"));
		System.out.println(person.getName());
		System.out.println(person.getId());

	}

}

