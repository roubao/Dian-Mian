package com.mycompany.projects.java.intellij;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int [] input = new int[]{2,5,4,3,-2,-4,3,-9,5,-3,1,4};
        int target = 7;
        findon2(input, target);
        findon(input, target);
    }
    // o(n) time:
    private static void findon(int[] input, int target) {
        int[] sumArray = new int[input.length];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0, sum = 0; i < input.length; i ++) {
            sum += input[i];
            sumArray[i] = sum;
            if (map.containsKey(sum)) {
                Set tset = map.get(sum);
                tset.add(i);
            } else {
                Set tset = new HashSet<>();
                tset.add(i);
                map.put(sum, tset);
            }
        }
        Set<Integer> kset = map.keySet();
        for (Integer ele : kset) {
            if (!kset.contains(ele + target)) continue;
            Set<Integer> iset = map.get(ele);
            Set<Integer> jset = map.get(ele + target);
            for (Integer iele : iset) {
                for (Integer jele : jset) {
                    if (iele > jele) continue;
                    System.out.print(iele + " " + jele + " [");
                    int b1[] = Arrays.copyOfRange(input, iele + 1, jele + 1);
                    for (int b1ele : b1) System.out.print(b1ele + " ");
                    System.out.println("]");
                }
            }
        }
        // from start to the ith node, the sum could be the target:
        if (kset.contains(target)) {
            Set<Integer> set = map.get(target);
            for (Integer ele : set) {
                System.out.print("0 " + ele + " [");
                int b1[] = Arrays.copyOfRange(input, 0, ele + 1 );
                for (int b1ele : b1) System.out.print(b1ele + " ");
                System.out.println("]");
            }
        }
    }
    // o(n^2) time
    private static void findon2(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i, sum = 0; j < input.length; j ++) {
                sum += input[j];
                if (sum == value) {
                    System.out.print(i + " " + j +" [");
                    int b1[] = Arrays.copyOfRange(input, i, j + 1);
                    for (int ele : b1) System.out.print(ele + " ");
                    System.out.println("]");
                }
            }
        }
    }
}
