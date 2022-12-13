package com.ch.practice.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { -1, 2, -5, 0, -5, 15, -30 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int low, int high) {
		int middle = (low + high) / 2;
		int temp = arr[middle];
		int tempLow = low;
		int tempHigh = high;
		if (tempLow < tempHigh) {
			while (tempLow < tempHigh) {
				while (arr[tempLow] < temp) {
					tempLow++;
				}
				while (arr[tempHigh] > temp) {
					tempHigh--;
				}
				if (tempLow >= tempHigh) {
					break;
				}
				int t = arr[tempHigh];
				arr[tempHigh] = arr[tempLow];
				arr[tempLow] = t;

				if (arr[tempLow] == temp) {
					tempHigh--;
				}
				if (arr[tempHigh] == temp) {
					tempLow++;
				}

			}
			if (tempLow == tempHigh) {
				tempLow++;
				tempHigh--;
			}
			if (low < tempHigh) {
				quickSort(arr, low, tempHigh);
			}
			if (tempLow < high) {
				quickSort(arr, tempLow, high);
			}
		}
	}

	public static void quickSort2(int[] arr, int low, int high) {
		int i, j, temp, t;
		if (low >= high) {
			return;
		}
		i = low;
		j = high;

		// temp就是基准位
		temp = arr[(low + high) / 2];

		while (i < j) {
			// 先看右边，依次往左递减
			while (temp < arr[j] && i < j) {
				j--;
			}
			// 再看左边，依次往右递增
			while (temp > arr[i] && i < j) {
				i++;
			}
			// 如果满足条件则交换
			if (i < j) {
				t = arr[j];
				arr[j] = arr[i];
				arr[i] = t;
			}
		}
		// 递归调用左半数组
		quickSort2(arr, low, j - 1);
		// 递归调用右半数组
		quickSort2(arr, j + 1, high);
	}

}
