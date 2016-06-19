package com.mycom.projects.amatest;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int[] result = maxSlidingWindow(nums, 3);
		for ( int e : result)
		System.out.print(e + " ");
		System.out.println();
	}
	public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] >= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
                if (deque.getFirst() == i - k + 1) {
                    deque.pollFirst();
                }
            }
        }
        return res;
	}

}
