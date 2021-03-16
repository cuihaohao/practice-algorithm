package com.ch.practice.stack;

import java.util.Stack;

/**
 * 一个整数数组 A，找到每个元素：右边第一个比我小的下标位置，没有则用 -1 表示。
 *
 * 输入：[5, 2]
 *
 * 输出：[1, -1]
 */
public class RightSmall {
	public static void main(String[] args) {
		int[] index = findRightSmall(new int[] { 1, 2, 5, 4, 3, 0, 1 });
		for (int i = 0; i < index.length; i++) {
			System.out.println(index[i]);
		}
	}

	public static int[] findRightSmall(int[] array) {
		// 结果数组
		int[] ans = new int[array.length];
		if (array.length <= 1) {
			return new int[] { 0 };
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < array.length; i++) {
			int a = array[i];
			while (!stack.isEmpty() && array[stack.peek()] > a) {
				ans[stack.peek()] = i;
				stack.pop();
			}
			stack.push(i);
		}
		// 栈中剩下的元素，由于没有人能消除他们，因此，只能将结果设置为-1。
		while (!stack.empty()) {
			ans[stack.peek()] = -1;
			stack.pop();
		}
		return ans;
	}
}
