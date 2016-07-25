package com.mycompany.projects.java.intellij;
// abciidefhhgoo --> ii,hh,oo
// abcdiiiefghh  -->  iii
// abcd  -->  a,b,c,d

public class Main {

    public static void main(String[] args) {
	// write your code here
        String input = "abciidefhhgoo";
        //input = "abcdiiiefghh";
        //input = "abcd";
        find(input);
    }

    private static void find(String input) {
        int max = 1;
        int times = 1;
        for (int i = 1; i < input.length(); i ++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                max ++;
            } else {
                max = 1;
            }
            if (max > times) times = max;
        }
        max = 1;
        if (times == 1) System.out.print(input.charAt(0) + ",");
        for (int i = 1; i < input.length(); i ++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                max ++;
            } else {
                max = 1;
            }
            if (max == times) {
                //System.out.println(i + " " + max);
                System.out.print(input.substring(i - times + 1, i + 1) + ",");
            }
        }
    }
}
