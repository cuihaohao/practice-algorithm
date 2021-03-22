package com.ch.practice.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { -1, -2, 3, 2, 20, 10 };
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void bubbleSort(int[] arr) {
		int length = arr.length;
		if (length <= 1) {
			return;
		}
		int temp;
		for (int i = 0; i < length - 1; i++) {
			// 一轮未发生交换，则排序完成
			boolean over = false;
			for (int j = 0; j < length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					over = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (!over) {
				break;
			}
		}
	}
}
