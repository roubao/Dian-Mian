package com.mycom.projects.amatest;

import java.util.HashMap;
import java.util.Map;

public class NonContinueRepeatStringConversion {

	public static void main(String[] args) {
		String input = "aaccccedcc";
		input = "aa";
//		input = "$$aaa&&&bbcc";
		input = "aabbbccddee";
		input = "aabcdaafaaaabrrrtaaaeecccccaaddaaa";
		System.out.println(stringConverter(input));
	}
	private static String stringConverter(String input) {
		char[] ca = input.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char a : ca) {
			if (map.containsKey(a)) {
				int tmp = map.get(a);
				map.put(a, tmp + 1);
			} else {
				map.put(a, 1);
			}
		}
		ca = new char[input.length()];
		char prev = '\0';
		for (int i = 0; i < ca.length; i ++) {
			ca[i] = nextChar(map, prev);
			if (ca[i] == 0) {
				return "invalid";
			}
			prev = ca[i];
		}
		return String.valueOf(ca);
	}
	private static Character nextChar(Map<Character, Integer> map, char prev) {
		int max = 0;
		Character result = null;
		for (Character c : map.keySet()) {
			if (prev != 0 && prev == c) continue;
			if (map.get(c) > max) {
				max = map.get(c);
				result = c;
			}
		} 
		if (result == null) return 0;
		if (max == 1) map.remove(result);
		else map.put(result, max - 1);
		return result;
	}
}
