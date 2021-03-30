package com.ch.practice.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] arr = { -1, 2, -5, 0, 10, 15, -30 };
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void shellSort(int[] arr) {
		int length = arr.length;
		for (int gap = length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < length; i++) {
				int insertVal = arr[i];
				int insertIndex = i;
				while (insertIndex > 0 && insertVal < arr[insertIndex - gap]) {
					arr[insertIndex] = arr[insertIndex - gap];
					insertIndex -= gap;
				}
				arr[insertIndex] = insertVal;
			}
		}
	}
}
