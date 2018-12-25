package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/25 8:41
 * @Descripton :
 * <p>
 * <p>
 * Longest Uncommon Subsequence I
 * <p>
 * Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings. The
 * longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence
 * should not be any subsequence of the other strings.
 * <p>
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the
 * order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a
 * subsequence of any string.
 * <p>
 * The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If the
 * longest uncommon subsequence doesn't exist, return -1.
 */
public class SolutionNo521 {
	public int findLUSlength(String a, String b) {
		if (a.equals(b)) {
			return -1;
		}
		return a.length() > b.length() ? a.length() : b.length();
	}
}
