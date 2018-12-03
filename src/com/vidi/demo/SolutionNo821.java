package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/3 10:44
 * @Descripton :
 * <p>
 * Shortest Distance to a Character
 * <p>
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character
 * C in the string.
 */
public class SolutionNo821 {
	public static int[] shortestToChar(String S, char C) {
		int length = S.length();
		int[] results = new int[S.length()];
		int pre = Integer.MIN_VALUE / 2;
		char[] charArray = S.toCharArray();
		for (int i = 0; i < length; i++) {
			if (charArray[i] == C) {
				pre = i;
			}
			results[i] = i - pre;
		}
		pre = Integer.MAX_VALUE / 2;
		for (int i = length - 1; i >= 0; i--) {
			if (charArray[i] == C) {
				pre = i;
			}
			results[i] = results[i] > pre - i ? pre - i : results[i];
		}
		return results;
	}

	public static void main(String[] args) {
		int[] shortestToChar = shortestToChar("loveleetcode", 'e');
		for (int i : shortestToChar) {
			System.out.print(i + "\t");
		}
	}
}
