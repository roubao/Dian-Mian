package com.mycom.projects.amatest;

public class DivideMulply {
/*
 * 715=7*1*5=35=3*5=15=1*5=5
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 715;
		devideMultiply(n);
	}
	private static void devideMultiply(int n) {
		while (n > 10) {
			int k = n;
			n = 1;
			while ( k > 0) {
				n *= k % 10;
				k /= 10;
				System.out.println(k + "  " + n);
			}
		}
	}
}
