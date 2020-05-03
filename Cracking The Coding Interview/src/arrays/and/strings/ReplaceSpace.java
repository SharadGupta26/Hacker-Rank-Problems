package arrays.and.strings;

import java.util.Scanner;

public class ReplaceSpace {
	public static void main(String[] args) {
		String s = input();
		System.out.println("input : ");
		System.out.println(s);
		System.out.println(replaceSpace(s));
		System.out.println(replaceSpace_2(s));
		
	}

	private static String input() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		return s;
	}
	
	/**
	 * Difference b/w //s+ and //s
	 *'//s+' refers to all continuous spaces together
	 *'//s' refers to one space at a time;
	 * @param s
	 * @return
	 */
	private static String replaceSpace(String s) {
		return s.replaceAll("\\s", "%20");
	}
	
	private static String replaceSpace_2(String s) {
		int spaces = 0;
		char[] arr = s.toCharArray();
		for(char c : arr) {
			if(c == ' ') {
				spaces++;
			}
		}
		
		char[] mod = new char[arr.length  + 2 * spaces];
		int index = 0;
		for(int i = 0 ; i <arr.length ; i++) {
			if(arr[i] == ' ') {
				mod[index++] = '%';
				mod[index++] = '2';
				mod[index++] = '0';
			} else {
				mod[index++] = arr[i];
			}
		}
		return new String(mod);
	}
}
