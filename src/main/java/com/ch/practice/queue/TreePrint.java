package com.ch.practice.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点按从左到右的顺序打印，每一层打印到一行。
 */
public class TreePrint {
	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.num = 1;
		root.left = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		root.right = new TreeNode(4);
		List<List<Integer>> res = getLayeredPrint(root);
		res.forEach(l -> {
			l.forEach(System.out::print);
			System.out.println();
		});
	}

	public static List<List<Integer>> getLayeredPrint(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return null;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> nums = new ArrayList<>();
			int curSize = queue.size();
			for (int i = 0; i < curSize; i++) {
				TreeNode treeNode = queue.poll();
				nums.add(treeNode.num);
				if (treeNode.left != null) {
					queue.add(treeNode.left);
				}
				if (treeNode.right != null) {
					queue.add(treeNode.right);
				}
			}
			res.add(nums);
		}
		return res;
	}

	static class TreeNode {
		int num;
		TreeNode left;
		TreeNode right;

		public TreeNode() {
		}

		public TreeNode(int num) {
			this.num = num;
		}

		public TreeNode(int num, TreeNode left, TreeNode right) {
			this.num = num;
			this.left = left;
			this.right = right;
		}
	}
}
