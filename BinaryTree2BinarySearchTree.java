package com.mycom.projects.amatest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTree2BinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode tmp0 = new TreeNode(2);
		TreeNode tmp1 = new TreeNode(7);
		root.left = tmp0;
		root.right = tmp1;
		tmp0 = new TreeNode(8);
		tmp1 = new TreeNode(4);
		root.left.left = tmp0;
		root.left.right = tmp1;
		String output  = inorder(root);
		List<Integer> list = Arrays.asList(output.split(","))
				.stream().map(s -> Integer.parseInt(s))
				.collect(Collectors.toList());
		Collections.sort(list);
		System.out.println(list);
		output = inorder(bt2Bst(list));
		System.out.println(output);
	}
	private static TreeNode bt2Bst (List<Integer> list) {
		if (list == null || list.size() == 0) 
			return null;
		int mid = list.size() / 2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = bt2Bst(list.subList(0, mid));
		root.right = bt2Bst(list.subList(mid + 1, list.size()));
		return root;
	}
	private static String inorder(TreeNode root) {
		if (root == null) return "";
		return inorder(root.left) 
				+ Integer.toString(root.val) + ","
				+ inorder(root.right);
	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}