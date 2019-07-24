package arrays.and.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IsUnique {

	public static void main(String[] args) {
		String s = readInputString();
		System.out.println(isUnique_m1(s));
		System.out.println(isUnique_m2(s));
	}
	

	private static String readInputString() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		return s;
	}
	
	/**
	 * Using another data structure
	 * Set.
	 * Can also use HashMap.
	 * complexity O(n)
	 * @param s
	 * @return
	 */
	private static boolean isUnique_m1(String s) {
		Set<Character> set = new HashSet<>();
		for(char c : s.toCharArray()) {
			set.add(c);
		}
		return s.length() == set.size();
	}
	
	/**
	 * Using sorting the string.
	 * Compare each element with next adjacent element.
	 * Complexity O(nlogn)
	 * @param s
	 * @return
	 */
	private static boolean isUnique_m2(String s) {
		char[] sorted = s.toCharArray();
		Arrays.sort(sorted);
		for(int i = 0 ; i<s.length() - 1 ; i++) {
			if(sorted[i] == sorted[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	
}
