package com.vidi.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author : Vidi
 * @Date : 2018/12/4 9:23
 * @Descripton :
 * <p>
 * Groups of Special-Equivalent Strings
 * <p>
 * You are given an array A of strings.
 * <p>
 * Two strings S and T are special-equivalent if after any number of moves, S == T.
 * <p>
 * A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].
 * <p>
 * Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is not
 * special-equivalent with any string in S.
 * <p>
 * Return the number of groups of special-equivalent strings from A.
 */
public class SolutionNo893 {
	public int numSpecialEquivGroups(String[] A) {
		Set<String> set = new HashSet<>();
		for (String s : A) {
			String root = root(s);
			set.add(root);
		}
		return set.size();
	}

	private String root(String s) {
		int len = s.length();
		char[] odd = new char[len / 2];
		char[] even = new char[(len + 1) / 2];
		int op = 0;
		int ep = 0;
		for (int i = 0; i < len; i++) {
			if (i % 2 == 0) {
				even[ep++] = s.charAt(i);
			} else {
				odd[op++] = s.charAt(i);
			}
		}
		Arrays.sort(odd);
		Arrays.sort(even);
		op = 0;
		ep = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (i % 2 == 0) {
				sb.append(even[ep++]);
			} else {
				sb.append(odd[op++]);
			}
		}
		return sb.toString();
	}
}
