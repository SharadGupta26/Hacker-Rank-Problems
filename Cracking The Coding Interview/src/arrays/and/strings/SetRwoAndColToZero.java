package arrays.and.strings;

import java.util.Arrays;
import java.util.Random;

public class SetRwoAndColToZero {

	public static void main(String[] args) {
		int[][] matrix = input(4,3);
		System.out.println("input : ");
		print(matrix);
		System.out.println("output : ");
		print(setToZero(matrix));
		
		
	}
	
	private static int[][] input(int m, int n) {
		// Scanner sc = new Scanner(System.in);
		int[][] matrix = new int[m][n];
		Random r = new Random();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = r.nextInt(10);
			}
		}
		return matrix;
	}

	private static void print(int[][] arr) {
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
	
	private static int[][] setToZero(int[][] arr) {
		int[] row = new int[arr.length];
		int[] col = new int[arr[0].length];
		for(int i = 0 ; i< arr.length ; i++) {
			for(int j=0 ; j<arr[i].length ; j++) {
				if(arr[i][j] == 0) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		
		for(int i = 0 ; i< arr.length ; i++) {
			for(int j=0 ; j<arr[i].length ; j++) {
				if(row[i] == 1 || col[j] == 1) {
					arr[i][j] = 0;
				}
			}
		}
		return arr;
	}
}
