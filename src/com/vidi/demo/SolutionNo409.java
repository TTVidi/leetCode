package com.vidi.demo;

import java.util.HashMap;

/**
 * @Author : Vidi
 * @Date : 2019/1/23 17:20
 * @Descripton :
 * <p>
 * Longest Palindrome
 * <p>
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can
 * be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note: Assume the length of given string will not exceed 1,010.
 */
public class SolutionNo409 {
	public static int longestPalindrome(String s) {
		HashMap<Character, Integer> map = new HashMap<>(s.length());
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int count = 0;
		if (map.size() == 1) {
			return s.length();
		}
		int max = 0;
		for (Integer integer : map.values()) {
			if (integer % 2 == 0) {
				count += integer;
			} else if (integer - 1 > 0) {
				count += (integer - 1);
				max = 1;
			} else {
				max = 1;
			}
		}
		return count + max;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("ababababa"));
	}
}
