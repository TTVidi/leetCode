package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/11/27 9:33
 * @Descripton :
 * <p>
 * DI String Match
 * <p>
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 * <p>
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 * <p>
 * If S[i] == "I", then A[i] < A[i+1] If S[i] == "D", then A[i] > A[i+1]
 */
public class SolutionNo942 {
	public static int[] diStringMatch(String S) {
		int begin = 0;
		int end = S.length();
		int[] results = new int[S.length() + 1];
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'I') {
				results[i] = begin++;
			} else {
				results[i] = end--;
			}
		}
		results[S.length()] = begin++;
		return results;
	}

	public static void main(String[] args) {
		String s = "DDI";
		int[] stringMatch = diStringMatch(s);
		for (int match : stringMatch) {
			System.out.println(match);
		}
	}
}
