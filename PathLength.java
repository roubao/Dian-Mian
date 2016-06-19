package com.mycom.projects.amatest;

import java.util.Stack;

public class PathLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String 
		input  = "dir1\n";
		input += " dir12\n";
		input += " dir13\n";
		input += "  test.jpeg\n";
		input += "  dir134\n";
		input += "   file.txt\n";
		input += "   tst.jpeg\n";
		input += "  dir135\n";
		input += "   tst.jpeg\n";
		input += "dir2\n";
		input += " test2.jpeg";
		int result = pathLength(input);
		System.out.println(result);
	}
	private static int pathLength(String s) {
		int length = 0;
		String[] lines = s.split("\n");
		StringBuilder sb = new StringBuilder();
		int level = 0;
		for (String name : lines) {
			int n = 0;
			if ((n = name.indexOf(".")) > 0) {
				String ext = name.substring(n + 1);
				if (ext.equals("jpeg")) {
					length += sb.length();
				}
				continue;
			}
			int spaceLength = 0;
			while (name.charAt(spaceLength) == ' ') {
				spaceLength++;
			}
			while (level > spaceLength) {
				sb.delete(sb.lastIndexOf("/"), sb.length());
				level --;
			}
			sb.append("/").append(name.trim());
			level ++;
		}
		return length;
	}

}
