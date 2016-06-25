package com.mycom.projects.amatest;

import java.util.HashMap;
import java.util.Map;

public class Nonrepeated1stChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abcefgabb";
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length(); i ++) {
			if (map.containsKey(input.charAt(i))) {
				int tmp = map.get(input.charAt(i));
				map.put(input.charAt(i), tmp + 1);
			} else {
				map.put(input.charAt(i), 1);
			}
		}
		for (int i = 0; i < input.length(); i ++) {
			if (map.get(input.charAt(i)) == 1) {
				System.out.println(input.charAt(i));
				return;
			}
		}
	}
	

}
