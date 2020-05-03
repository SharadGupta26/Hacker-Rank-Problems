package arrays.and.strings;

import java.util.Scanner;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String s = input();
		System.out.println("Input : ");
		System.out.println(s);
		removeDuplicates(s);
	}

	private static String input() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		return s;
	}

	/**
	 * It starts to pick elements from index = 1 and then check all elements before
	 * it. If it matches any of previous element, we discard it or else put current
	 * element in array in position defined by tail. variable tail is keeping track
	 * of length of new string / array.
	 * 
	 * @param s
	 */
	private static void removeDuplicates(String s) {
		char[] arr = s.toCharArray();
		int tail = 1;
		for (int i = 1; i < arr.length; i++) {
			int j = 0;
			for (; j < tail; j++) {
				if (arr[i] == arr[j]) {
					break;
				}
			}
			if (j == tail) {
				arr[tail] = arr[i];
				tail++;
			}
		}

		for (int i = 0; i < tail; i++) {
			System.out.print(arr[i]);
		}
	}
}
