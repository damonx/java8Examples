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
package sort;

import java.util.stream.IntStream;

public class InsertSort {

	public static void insertSort(final int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}

		for (int i = 1; i < arr.length; i++) {
			int j = i;
			final int target = arr[i];

			while (j > 0 && target < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}

			arr[j] = target;
		}


	}

	public static void main(final String[] args) {
		final int[] arrInt = new int[] { 3, 5, 4, 8, 2, 7, 9 };
		insertSort(arrInt);
		IntStream.of(arrInt).forEach(System.out::println);

	}

}

