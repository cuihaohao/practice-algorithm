package com.ch.practice.stack;

import java.util.Stack;

/**
 * 给定一个正整数数组和 k，要求依次取出 k 个数，输出其中数组的一个子序列，需要满足：1. 长度为 k；2.字典序最小。
 *
 * 输入：nums = [3,5,2,6], k = 2 输出：[2,6]
 */
public class SmallSeq {
	public static void main(String[] args) {
		int[] smallSeq = findSmallSeq(new int[] { 4, 5, 6, 2, 1, 0, 3, 2, 5 },
				3);
		for (int i = 0; i < smallSeq.length; i++) {
			System.out.println(smallSeq[i]);
		}
	}

	public static int[] findSmallSeq(int[] array, int k) {
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[k];
		for (int i = 0; i < array.length; i++) {
			int a = array[i];
			final int left = array.length - i;
			while (!stack.isEmpty() && stack.size() + left > k
					&& stack.peek() > a) {
				stack.pop();
			}
			stack.push(a);
		}
		while (stack.size() > k) {
			stack.pop();
		}
		for (int j = k - 1; j >= 0; j--) {
			ans[j] = stack.pop();
		}
		return ans;
	}
}
