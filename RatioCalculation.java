package com.mycom.projects.amatest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * 
 * f1 : 10M     str1, str2, ratio

A, B, 0.5    // A / B = 0.5
A, E, 2.3    // A / E = 2.3
C, E, 1.5    // C / E = 1.5
C, D, 1.0    // C / D = 1.0

f2 : 10G    str1, str2

C, B
A, D


f3 : based on f2, follow f1

C, B, 0.33    // C / B = C/E * E/A * A/B = 1.5 * 1/2.3 * 0.5 = 0.33
A, D, 1.53    // A / D = A/E * E/C * C/D = 2.3 * 1/1.5 * 1 = 1.53

 * 
 */

public class RatioCalculation {
	static Map<String, Double> map;
	public static void main(String[] args) {
		String input = "A, B, 0.5\n";
		input += "A, E, 2.3\n";
		input += "C, E, 1.5\n";
		input += "C, D, 1.0\n";
		
		map = new HashMap<>();
		preprocess(input);
		String request = "C, B\n";
		request += "A, D\n";
		cal("C, B");
		cal("A, D");
	}
	private static void cal(String s) {
		String[] in = s.split(",");
		String s0 = in[0].trim();
		String s1 = in[1].trim();
		double d0 = map.get(s0);
		double d1 = map.get(s1);
		System.out.println(s + " = " + (d0 / d1));
	}
	private static void preprocess(String input) {
		LinkedList<String> in = new LinkedList<String>(Arrays.asList(input.split("\n")));
		while (in.size() > 0) {
			if (map.size() == 0) {
				String s = in.get(in.size() - 1);
				String[] tmp = s.split(",");
				map.put(tmp[0].trim(), 1.0);
				double d = Double.parseDouble(tmp[2].trim());
				map.put(tmp[1].trim(), 1.0/d);
				in.remove(s);
				continue;
			}
			for (String s : in) {
				String[] tmp = s.split(",");
				String s0 = tmp[0].trim();
				String s1 = tmp[1].trim();
				if (!map.containsKey(s0) 
						&& !map.containsKey(s1))
					continue;
				if ( map.containsKey(s0) 
						&& map.containsKey(s1)) {
					in.remove(s);
					continue;
				}
				double td = Double.parseDouble(tmp[2].trim());
				if (map.containsKey(s0)
						&& !map.containsKey(s1)) {
					double d = map.get(s0);
					map.put(s1, d / td);
				} else {
					double d = map.get(s1);
					map.put(s0, d * td);
				}
				in.remove(s);
			}
		}
	}
}
