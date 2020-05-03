package arrays.and.strings;
import java.util.ArrayList;
import java.util.Random;

/**
 * Given numRows, generate the first numRows of Pascal’s triangle.
 * 
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from
 * previous row R - 1.
 * 
 * Example:
 * 
 * Given numRows = 5,
 * 
 * Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 * @author Sharad Gupta
 *
 */
public class PascalTringle {

	public static void main(String[] args) {
		PascalTringle tringle = new PascalTringle();
		tringle.solve(readInput()).forEach(tr -> System.out.println(tr));
	}

	private static int readInput() {
		Random r = new Random();
		return r.nextInt(50);
	}

	private ArrayList<ArrayList<Integer>> solve(int A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (A <= 0) {
			return result;
		}

		ArrayList<Integer> row = new ArrayList<>();
		row.add(1);
		result.add(row);
		ArrayList<Integer> prevRow = row;
		for (int i = 1; i < A; i++) {
			row = generateRow(i, prevRow);
			prevRow = row;
			result.add(row);
		}
		return result;
	}

	private ArrayList<Integer> generateRow(int n, ArrayList<Integer> prevRow) {
		ArrayList<Integer> row = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			row.add(get(i, prevRow) + get(i - 1, prevRow));
		}
		return row;
	}

	private int get(int i, ArrayList<Integer> row) {
		try {
			return row.get(i);
		} catch (Exception e) {
			return 0;
		}
	}

	public int[][] solve_aproach2(int A) {
		int arr[][] = new int[A][];

		for (int i = 0; i < A; i++) {
			arr[i] = new int[i + 1];
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					arr[i][j] = 1;
				} else
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}

		}
		return arr;
	}
}
