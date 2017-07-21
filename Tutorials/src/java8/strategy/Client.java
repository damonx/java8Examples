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
package java8.strategy;

public class Client {

	public static void main(final String[] args) {
		final Validator numericValidator = new Validator((final String s) -> s.matches("[a-z]+"));
		final boolean b1 = numericValidator.validate("aaaa");
		final Validator lowerCaseValidator = new Validator((final String s) -> s.matches("\\d+"));
		final boolean b2 = lowerCaseValidator.validate("bbbb");
		System.out.println("b1 = " + b1);
		System.out.println("b2 = " + b2);
	}

}

