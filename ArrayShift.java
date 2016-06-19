package com.mycom.projects.amatest;

public class ArrayShift {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[][] matrix = {{1,2},{3,4}};
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		//int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		shift(matrix);
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void shift(int[][] matrix) {
		int x = 0, y = 0, m = matrix.length, n = matrix.length;
		
		while (m > 1 && n > 1) {
			int tmp = matrix[x][y];
			for (int i = x; i < x + m - 1; i++ ) {
				matrix[i][y] = matrix[i + 1][y];
			}
			for (int i = y; i < y + n - 1; i++) {
				matrix[x + m - 1][i] = matrix[x + m - 1][i + 1];
			}
			for (int i = x + m - 1; i > x; i--) {
				matrix[i][y + n - 1] = matrix[i - 1][y + n - 1];
			}
			for (int i = y + n - 1; i > y; i--) {
				matrix[x][i] = matrix[x][i - 1];
			}
			matrix[x][y + 1] = tmp;
			x++;
			y++;
			m -= 2;
			n -= 2;
		}
	}
}
