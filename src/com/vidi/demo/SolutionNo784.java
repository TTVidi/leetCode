package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2018/12/26 15:56
 * @Descripton :
 * <p>
 * Letter Case Permutation
 * <p>
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 */
public class SolutionNo784 {
	public static List<String> letterCasePermutation(String S) {
		List<String> results = new ArrayList<>();
		results.add(S);
		backtracking(results, 0, S);
		return results;
	}

	public static void backtracking(List<String> list, int index, String s) {
		if (index == s.length()) {
			return;
		}
		if (s.charAt(index) >= 'a' && s.charAt(index) <= 'z') {
			List<String> tempList = new ArrayList<>();
			for (String s1 : list) {
				char[] chars = s1.toCharArray();
				chars[index] -= 32;
				tempList.add(new String(chars));
			}
			list.addAll(tempList);
		} else if (s.charAt(index) >= 'A' && s.charAt(index) <= 'Z') {
			List<String> tempList = new ArrayList<>();
			for (String s1 : list) {
				char[] chars = s1.toCharArray();
				chars[index] += 32;
				tempList.add(new String(chars));
			}
			list.addAll(tempList);
		}
		backtracking(list, ++index, s);
	}

	public static void main(String[] args) {
		List<String> list = letterCasePermutation("123456");
		for (String s : list) {
			System.out.println(s);
		}
	}
}
