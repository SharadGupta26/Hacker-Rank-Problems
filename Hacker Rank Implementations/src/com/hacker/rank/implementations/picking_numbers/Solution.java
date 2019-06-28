package com.hacker.rank.implementations.picking_numbers;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Problem Statement : picking-numbers-English.pdf
 * 
 */
class Result {

	/**
	 * Idea is, analyze through number theory that no three consecutive elements can
	 * have the difference equal to one among the one except they are two subsequent
	 * numbers
	 * 
	 * 
	 * @param a
	 * @return
	 */
	public static int pickingNumbers(List<Integer> a) {
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : a) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		// System.out.println(map);
		for (Integer key : map.keySet()) {
			int temp = 0;
			temp += map.get(key);
			temp += map.getOrDefault(key + 1, 0);
			max = Math.max(temp, max);
		}
		return max;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		// int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		int result = Result.pickingNumbers(a);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
