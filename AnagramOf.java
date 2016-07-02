package com.mycom.projects.amatest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * # 2. anagramsOf(word)
#
#    anagramsOf("post") --> ["pots", "spot", "stop", "tops"]
#    anagramsOf("dictionary") --> ["indicatory"]
#    anagramsOf("anagram") --> []
#
# Given a text file of English language words, and preprocessing time, how would you solve this?
private final Set<String> DICTIONARY = ...;
private void preprocess() {
}
public Set<String> anagramsOf(String word) {
}
time complexity O(1), no space limit.
 */

public class AnagramOf {
	Map<String, Set<String>> map;
	Map<String, String> map1;
	
	public static void main(String[] args) {

		AnagramOf af = new AnagramOf();
		af.preprocess();
		System.out.println(af.anagramsOf("post"));
		System.out.println(af.anagramsOf("dictionary"));
		System.out.println(af.anagramsOf("anagram"));
	}
	private void preprocess() {
		map = new HashMap<>();
		map1 = new HashMap<>();
		String input = "post,pots,spot,stop,tops,indicatory,dictionary,anagram";
		String[] sa = input.split(",");
		for (String in : sa) {
			String key = getAnagram(in);
			map1.put(in, key);
			if (map.containsKey(key)) {
				map.get(key).add(in);
			} else {
				Set<String> set = new HashSet<>();
				set.add(in);
				map.put(key, set);
			}
		}
		//System.out.println(map);
	}
	public  Set<String> anagramsOf(String word) {
		Set<String> result = map.get(map1.get(word));
		result.remove(word);
		return result;
	}
	private String getAnagram(String input) {
		char[] ca = input.toCharArray();
		Arrays.sort(ca);
		return new String(ca);
	}
}
