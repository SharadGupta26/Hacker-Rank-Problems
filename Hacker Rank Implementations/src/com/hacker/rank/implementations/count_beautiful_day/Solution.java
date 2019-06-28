package com.hacker.rank.implementations.count_beautiful_day;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the beautifulDays function below.
	static int beautifulDays(int i, int j, int k) {
		int count = 0;
		for (int l = i; l <= j; l++) {
			if (Math.abs(l - reverse(l)) % k == 0) {
				count++;
			}
		}
		return count;
	}

	static int reverse(int a) {
		return Integer.parseInt(new StringBuilder().append(a).reverse().toString());
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] ijk = scanner.nextLine().split(" ");

		int i = Integer.parseInt(ijk[0]);

		int j = Integer.parseInt(ijk[1]);

		int k = Integer.parseInt(ijk[2]);

		int result = beautifulDays(i, j, k);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
