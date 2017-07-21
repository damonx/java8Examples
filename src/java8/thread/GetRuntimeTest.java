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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetRuntimeTest {
	public static void main(final String[] args) throws IOException {
		final Process p = Runtime.getRuntime().exec("ping -c 5 www.google.co.nz");
		final BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line = input.readLine()) != null) {
			System.out.println(line);
		}
		input.close();
		System.out.println(p.exitValue());
	}
}

