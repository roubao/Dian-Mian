package com.mycom.projects.amatest;

/*
 * Write a recursive method called “digitsSorted” that takes an integer as a parameter and returns true if the digits of the integer are sorted and false if not. The digits must be sorted in non-decreasing order (i.e., increasing order with duplicate digits allowed) when read from left to right.  What is the runtime complexity of your solution?

 */
public class SortedInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 321;
		System.out.println(digitsSorted(i/10));
	}
	public static boolean digitsSorted(int input) {
		if (input < 10) 
			return true;
		if (input % 10 < (input/10)%10) 
			return false;
		return digitsSorted(input/10);
	}
}
