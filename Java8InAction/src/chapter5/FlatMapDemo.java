/*
 * Copyright (c) Fisher and Paykel Appliances
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package chapter5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class FlatMapDemo {

	public static void main(final String[] args) {
       final List<String> words = Arrays.asList("Hello", "Words");
		final List<String> uniqueChars = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(toList());
		System.out.println(uniqueChars);

	}

}

