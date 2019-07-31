package arrays.and.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Kadane algorithm is popular to find maximum sum of a continues subarray from
 * unsorted array in O(n) time
 * 
 * In this algo, maintain two sums, one is max sum and other is temp sum. We
 * traverse the array and continuously add elements to temp sum. Also updating
 * max sum at same time. And we reset the temp sum when temp sum goes negative.
 * 
 * This way we can find maximum sum of sub-array in O(n) time See explanation :
 * https://www.youtube.com/watch?v=ohHWQf1HDfU
 * 
 * @author Sharad gupta
 *
 */
public class Kadane {

	public static void main(String[] args) {
		List<Integer> input = readInput();
		System.out.println("Given input : " + input);
		int max = Integer.MIN_VALUE;
		int temp = 0;
		for(int i : input) {
			temp += i;
			max = Integer.max(max, temp);
			if(temp < 0) {
				temp = 0;
			}
		}
		
		System.out.println("Maximum sum is " + max);
	}

	private static List<Integer> readInput() {
		List<Integer> input = new ArrayList<>();
		Random r = new Random();
		int t = r.nextInt(20);
		while (t-- > 0) {
			input.add(r.nextInt(50 + 50) - 50); // to get both positive and negative numbers (max = 100, min = 100)
		}
		return input;
	}

}
