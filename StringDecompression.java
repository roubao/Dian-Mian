package com.mycom.projects.amatest;
/*
 * 
 */
public class StringDecompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "abbaba4x[a]bb3x[abaa2x[bab]]";
		String output = decompress(input);
		System.out.println(output);
	}

	private static String decompress(String input) {
		StringBuilder sb = new StringBuilder();
		int inputIndex =  0;
		while (inputIndex < input.length() ) {
			if (input.charAt(inputIndex)!=']') {
				sb.append(input.charAt(inputIndex));
				inputIndex ++;
				continue;
			}
			int i = sb.length() - 1;
			while (sb.charAt(i) != '[') i--;
			int sstart = --i; i--;
			int number = 0;
			while (sb.charAt(i) <= '9' && sb.charAt(i) >= '0') i--;
			i++;
			String ns = sb.substring(sstart + 2);
			number = Integer.parseInt(sb.substring(i, sstart));
			sb.delete(i, sb.length());
			while (number-- > 0) {
				sb.append(ns);
			}
			inputIndex ++;
		}
		return sb.toString();
	}
}
