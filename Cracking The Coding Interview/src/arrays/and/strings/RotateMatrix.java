package arrays.and.strings;

import java.util.Arrays;
import java.util.Random;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] matrix = input(3);
		System.out.println("input : ");
		print(matrix);

		System.out.println();
		System.out.println("output : ");
		print(rotate(matrix));
	}

	private static int[][] input(int n) {
		// Scanner sc = new Scanner(System.in);
		int[][] matrix = new int[n][n];
		Random r = new Random();
		for (int i = 0; i < n; i++) {
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

	private static int[][] rotate_right(int[][] arr) {
		int[][] result = new int[arr.length][arr.length];
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[n - j - 1][n - 1 - i] = arr[i][j];
			}
		}
		return result;
	}

	public static int[][] rotate(int[][] matrix) {
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];
				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				// top -> right
				matrix[i][last] = top; // right <- saved top }
			}
		}
		return matrix;
	}
}
