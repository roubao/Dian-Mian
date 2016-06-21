package com.mycom.projects.amatest;

public class FindLongest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] d = {1.0, 1.3, 1.5, 2.3, 3.5};
		int t = findLongest(d);
		System.out.println(t);
	}
	private static int findLongest(double[] v){
	    int left = 0, right = 0, ans = 0;	    
	    while(right < v.length) {
	        while(v[left] + 1.0 <= v[right]) 
	        	left++;
	        ans = Math.max(ans, right ++ - left + 1);
	    }
	    return ans;
	}
}
