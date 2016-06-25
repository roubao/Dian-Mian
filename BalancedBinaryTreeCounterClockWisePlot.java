package com.mycom.projects.amatest;

/*
 * 
Given a balanced binary tree, counter clock-wise plot the tree node on the boundary.
For example.

                        5
                4             8
            1     3        2   6
         3   1  9  2   7

5, 4, 1, 3, 1, 9, 2, 7, 6, 8

 */

public class BalancedBinaryTreeCounterClockWisePlot {
	BinaryTree root;
	public static void main(String[] args) {
		BalancedBinaryTreeCounterClockWisePlot bbt 
			= new BalancedBinaryTreeCounterClockWisePlot();
		bbt.root = new BinaryTree(5);
		bbt.root.left = new BinaryTree(4);
		bbt.root.right = new BinaryTree(8);
		BinaryTree tmp0 = new BinaryTree(3);
		BinaryTree tmp1 = new BinaryTree(1);
		BinaryTree tmp2 = new BinaryTree(1);
		tmp2.left = tmp0;
		tmp2.right = tmp1;
		bbt.root.left.left = tmp2;
		tmp0 = new BinaryTree(9);
		tmp1 = new BinaryTree(2);
		tmp2 = new BinaryTree(3);
		bbt.root.left.right = tmp2;
		tmp2.left = tmp0;
		tmp2.right = tmp1;
		tmp0 = new BinaryTree(7);
		tmp1 = new BinaryTree(2);
		tmp2 = new BinaryTree(6);
		tmp1.left = tmp0;
		bbt.root.right.left = tmp1;
		bbt.root.right.right = tmp2;
		System.out.println(bbt.leftBound(bbt.root, 1)+","
				+bbt.leaf(bbt.root, bbt.height, 1).substring(2)
				+bbt.rightBound(bbt.root));
	}
	int height = 0;
	public String leftBound(BinaryTree root, int depth) {
		if (root.left == null) {
			height = Math.max(height, depth);
			return Integer.toString(root.val);
		}
		return Integer.toString(root.val) +"," + leftBound(root.left, depth + 1);
	}
	public String rightBound(BinaryTree root) {
		if (root.right == null) return Integer.toString(root.val);
		return rightBound(root.right)+"," + Integer.toString(root.val)  ;
	}
	public String leaf(BinaryTree root, int height, int current) {
		if (root == null) return "";
		if (height == current) {
			return Integer.toString(root.val) + ",";
		}
		return leaf(root.left, height, current + 1) + leaf(root.right, height, current + 1);
	}
}
class BinaryTree {
	int val;
	BinaryTree left;
	BinaryTree right;
	public BinaryTree(int val) {
		this.val = val;
		left = null;
		right = null;
	}
}