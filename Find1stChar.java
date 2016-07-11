package com.mycom.projects.amatest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Find1stChar {
// find 1st nonrepeat character.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abcabfrf";
		input = "abcdefgabc";
		int pos = find1st2(input.toCharArray());
		System.out.println(pos);
	}
	private static int find1stNonrepeat(char[] input) {
		if (input == null || input.length < 2) {
			return -1;  // no repeated char.
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			if (map.containsKey(input[i])) {
				int sum  = map.get(input[i]);
				map.put(input[i], sum + 1);
			} else {
				map.put(input[i], 1);
			}
		}
		for (int i = 0; i < input.length; i++) {
			if (map.get(input[i]) == 1) {
				return i;
			}
		}
		return -1;
	}
	// time complexity got improved a little bit. save one loop.
	private static int find1st2(char[] input) {
		if (input == null || input.length < 2) {
			return -1;
		}
		int i = 0, j = input.length - 1;
		Set<Character> set = new HashSet<>();
		while (i < j) {
			if (set.contains(input[i])) {
				i++;
				continue;
			}
			if (set.contains(input[j])) {
				j--;
				continue;
			}
			if (input[i] == input[j]) {
				i++;
			}
			set.add(input[j--]);
		}
		return i;
	}
}
