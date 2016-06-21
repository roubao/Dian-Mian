package com.mycom.projects.amatest;

public class StringConversion {

	public static void main(String[] args) {
		String input = "abbaaabbbaaabbbaaa"; // to "aaaaa...bbbbbb"
		int t = convert(input);
		System.out.println(t);
	}
	
	private static int convert(String input) {
		int len = input.length();
		if (len < 2) return len;
		int [] a = new int [len + 1];
		int [] b = new int [len + 1];
		
		for (int i = 1; i <= len; i ++) {
			if (input.charAt(i - 1) == 'a') {
				a[i] = a[i - 1];
				b[i] = 1 + Math.min(a[i - 1], b[i - 1]);
			} else {
				a[i] = 1 + a[i - 1];
				b[i] = Math.min(a[i - 1], b[i - 1]);
			}
		}		
		return Math.min(a[len], b[len]);
	}
}
