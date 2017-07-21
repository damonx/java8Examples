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

public class QuickSort {

	// 一次划分
	public static int partition(final int[] arr, final int left, final int right) {
		int left2 = left;
		final int pivotKey = arr[left2];
		final int pivotPointer = left2;

		int right2 = right;
		while (left2 < right2) {
			while (left2 < right2 && arr[right2] >= pivotKey) {
				right2--;
			}
			while (left2 < right2 && arr[left2] <= pivotKey) {
				left2++;
			}
			swap(arr, left2, right2); // 把大的交换到右边，把小的交换到左边。
		}
		swap(arr, pivotPointer, left2); // 最后把pivot交换到中间
		return left2;
	}

	public static void quickSort(final int[] arr, final int left, final int right) {
		if (left >= right) {
			return;
		}
		final int pivotPos = partition(arr, left, right);
		quickSort(arr, left, pivotPos - 1);
		quickSort(arr, pivotPos + 1, right);
	}

	public static void sort(final int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	public static void swap(final int[] arr, final int left, final int right) {
		final int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void main(final String[] args) {
		final int[] arr = new int[] { 3, 2, 1, 8, 7, 5 };
		sort(arr);
		IntStream.of(arr).forEach(System.out::println);
	}

}

