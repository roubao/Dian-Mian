package com.mycom.projects.amatest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * You can assume the below numbers as a tree/list in which each node contains a value. Design an algorithm to print all paths which sum up to that value. Note that it can be any path in the tree - it does not have to start at the root. The path has to be contiguous
for e.g. we are looking for a sum of 5
Input: +2,+3,–4,+3,+1,+2,+2,-3
Output can be : +2,+3 is one path
+2,+3,-4,+3,+1
+1,+2,+2   <- 
+2,+3,–4,+3,+1,+2,+2,-3
      
 2  5  1  4  5  7  9  6 
+2,+3,–4,+3,+1,+2,+2,-3 
       


 */
public class SequenceSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// o(nlg(n))
	public List<List<Integer>> sequeceSum(List<Integer> input, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> sumList = new ArrayList<>();
		for (int i = 0, sum = 0; i < input.size(); i ++) {
			sum += input.get(i);
			sumList.add(sum);
			map.put(sum, i); // assume sum is unique.
		}
		Collections.sort(sumList);
		
		List<List<Integer>> result = new ArrayList<>();
		
		return result;
	}
	
	// o(n^2)
	public List<List<Integer>> targetSum (List<Integer> input, int target) {
	    List<List<Integer>> result = new ArrayList<>();
	    
	    if (input == null) {
	        return result;
	    }
	    //int sum = 0;
	    for (int j = 0; j < input.size(); j++)
	      for (int i = j, sum = 0; i < input.size(); i++) {
	        sum += input.get(i);
	        if (sum == target) {
	            List<Integer> tmp = new ArrayList<>();
	            for (int k = j; k <= i; k++) {
	                tmp.add(input.get(k));
	                
	            }
	            result.add(tmp);
	        }
	      }
	    return result;

	}
}
