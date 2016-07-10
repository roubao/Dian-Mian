package com.mycom.projects.java.projects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Sudoku {
	// this is from https://bob-carpenter.github.io/games/sudoku/java_sudoku.html
    public static void main(String[] args) {
	int[][] matrix = new int[9][9];//parseProblem(args);
	createBoard(matrix, args[0]);
	writeMatrix(matrix);
	if (solve(0,0,matrix))    // solves in place
	    writeMatrix(matrix);
	else 
	    System.out.println("NONE");
    }

    static boolean solve(int i, int j, int[][] cells) {
	if (i == 9) {
	    i = 0;
	    if (++j == 9) 
		return true; 
	}
	if (cells[i][j] != 0)  // skip filled cells
	    return solve(i+1,j,cells);
	
	for (int val = 1; val <= 9; ++val) {
	    if (legal(i,j,val,cells)) {  
		cells[i][j] = val;       
		if (solve(i+1,j,cells))  
		    return true;
	    }
	}
	cells[i][j] = 0; // reset on backtrack
	return false;
    }

    static boolean legal(int i, int j, int val, int[][] cells) {
	for (int k = 0; k < 9; ++k)  // row
	    if (val == cells[k][j])
		return false;

	for (int k = 0; k < 9; ++k) // col
	    if (val == cells[i][k])
		return false;

	int boxRowOffset = (i / 3)*3;
	int boxColOffset = (j / 3)*3;
	for (int k = 0; k < 3; ++k) // box
	    for (int m = 0; m < 3; ++m)
		if (val == cells[boxRowOffset+k][boxColOffset+m])
		    return false;

	return true; // no violations, so it's legal
    }

    static int[][] parseProblem(String[] args) {
	int[][] problem = new int[9][9]; // default 0 vals
	for (int n = 0; n < args.length; ++n) {
	    int i = Integer.parseInt(args[n].substring(0,1));   
	    int j = Integer.parseInt(args[n].substring(1,2));   
	    int val = Integer.parseInt(args[n].substring(2,3)); 
	    problem[i][j] = val;
	}
	return problem;
    }

    static void writeMatrix(int[][] solution) {
	for (int i = 0; i < 9; ++i) {
	    for (int j = 0; j < 9; ++j) {
		if (j % 3 == 0) System.out.print("| ");
		System.out.print(solution[i][j] == 0
				 ? " "
				 : Integer.toString(solution[i][j]));
		
		System.out.print(' ');
	    }
	    System.out.println("|");
	}
	System.out.println();
    }
    private static void createBoard(int[][] board,String filename) {
		int i = 0;
		try {
		    BufferedReader reader = new BufferedReader(new FileReader(filename));
		    String line;
		    while ((line = reader.readLine()) != null) {
		      String[] sa = line.split(" ");
		      for (int j = 0; j < 9; j++) 
					board[i][j] = Integer.parseInt(sa[j]);
		      i++;
		    }
		    reader.close();
		  } catch (Exception e) {
		    System.err.format("Exception occurred trying to read '%s'.", filename);
		    e.printStackTrace();
		  }
	}

	
	
	/*  this is from me. only filtering, no search. seems search is a must.
	public static void main(String[] args) {
		int[][] board = new int[9][9];
		createBoard(board, args[0]);
		
		Map<Integer, Set<Integer>> rows = new HashMap<>();
		Map<Integer, Set<Integer>> columns = new HashMap<>();
		Map<Integer, Set<Integer>> blocks = new HashMap<>();
		Map<Integer, Set<Integer>> points = new HashMap<>();
		gen(board, rows, columns, blocks);
		int precount = filter(board, rows, columns, blocks);
	
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != 0) continue;
				Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
				set.removeAll(rows.get(i));
				set.removeAll(columns.get(j));
				set.removeAll(blocks.get((i/3)*3 +j/3));
				if (set.size() != 1) {
					points.put(i*9 +j, set);
				}
			}
		}
		System.out.println(points);
		System.out.println(precount);
		printBoard(board);
	}
	private static void printBoard(int[][] board) {
		System.out.println();
		for (int i = 0; i < 9; i++) {
			for (int k : board[i])
				System.out.print(k + " ");
			System.out.println();
		}	
	}
	private static void createBoard(int[][] board,String filename) {
		int i = 0;
		try {
		    BufferedReader reader = new BufferedReader(new FileReader(filename));
		    String line;
		    while ((line = reader.readLine()) != null) {
		      String[] sa = line.split(" ");
		      for (int j = 0; j < 9; j++) 
					board[i][j] = Integer.parseInt(sa[j]);
		      i++;
		    }
		    reader.close();
		  } catch (Exception e) {
		    System.err.format("Exception occurred trying to read '%s'.", filename);
		    e.printStackTrace();
		  }
	}

	private static void gen(int[][] board, Map<Integer, Set<Integer>> rows,
			Map<Integer, Set<Integer>> columns, Map<Integer, Set<Integer>> blocks) {
		Set<Integer> tmp;
		for (int i = 0; i < 9; i++) {
			tmp = new HashSet<>();
			for (int k : board[i]) {
				if (k > 0) tmp.add(k);
				System.out.print(k + " ");
			}
			rows.put(i, tmp);
			System.out.println();
		}
		for (int j = 0; j < 9; j++) {
			tmp = new HashSet<>();
			for (int i = 0; i < 9; i++) {
				if (board[i][j] > 0) {
					tmp.add(board[i][j]);
				}
			}
			columns.put(j, tmp);
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] > 0) {
					int block = (i/3)*3 + j/3;
					if (blocks.containsKey(block)) {
						tmp = blocks.get(block);
						tmp.add(board[i][j]);
					} else {
						tmp = new HashSet<>();
						tmp.add(board[i][j]);
						blocks.put(block, tmp);
					}
				}
			}
		}
	}
	
	private static int filter(int[][] board, Map<Integer, Set<Integer>> rows,
			Map<Integer, Set<Integer>> columns, Map<Integer, Set<Integer>> blocks) {
		int precount = 0;
		int currentcount = 81;
		while (precount != currentcount) {
			precount = currentcount;
			currentcount = 0;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (board[i][j] != 0) continue;
					currentcount++;
					Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
					set.removeAll(rows.get(i));
					set.removeAll(columns.get(j));
					set.removeAll(blocks.get((i/3)*3 +j/3));
					if (set.size() != 1) continue;
					int left = set.iterator().next();
					rows.get(i).add(left);
					columns.get(j).add(left);
					blocks.get((i/3)*3 + j/3).add(left);
					board[i][j] = left;
					//System.out.println(i + ":"+j+":"+left);
				}
			}
		}
		return precount;
	}
	*/
}
