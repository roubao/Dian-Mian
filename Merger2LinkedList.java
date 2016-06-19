package com.mycom.projects.amatest;

import java.util.LinkedList;

public class Merger2LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static LinkedList<Integer> merge(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		LinkedList<Integer> result = new LinkedList<>();
		int i = 0, j = 0;
		while (i < l1.size() && j < l2.size()) {
			if (l1.get(i) > l2.get(j)) {
				result.add(l1.get(i++));
			} else {
				result.add(l2.get(j++));
			}
		}
		
		while (i < l1.size()) {
			result.add(l1.get(i++));
		}
	
		while (j < l2.size()) {
			result.add(l2.get(j++));
		}
		
		return result;
	}
}
