package com.ch.practice.recursion;

/**
 * 8皇后 问题
 * 
 * 递归回溯法解决
 */
public class Queen8 {
	private static int count;
	private static int checkCount;
	private static int max = 8;
	private static int[] queen = new int[max];

	public static void main(String[] args) {
		put(0);
		System.out.println(count);
		System.out.println(checkCount);
	}

	private static void put(int n) {
		if (n == max) {
			print();
			return;
		}
		for (int i = 0; i < max; i++) {
			queen[n] = i;
			if (check(n)) {
				put(n + 1);
			}
		}
	}

	private static boolean check(int n) {
		checkCount++;
		for (int i = 0; i < n; i++) {
			// queen[i] == queen[n] 检查是否同一列
			// Math.abs(n - i) == Math.abs(queen[i] - queen[n]) 检查是否在同一斜线上
			if (queen[i] == queen[n]
					|| Math.abs(n - i) == Math.abs(queen[i] - queen[n])) {
				return false;
			}
		}
		return true;
	}

	private static void print() {
		count++;
		for (int i = 0; i < max; i++) {
			System.out.print(queen[i] + " ");
		}
		System.out.println();

	}
}
