package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/9 15:38
 * @Descripton :
 * <p>
 * Valid Anagram
 * <p>
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 */
public class SolutionNo242 {
	public static boolean isAnagram(String s, String t) {
		if (s != null && t != null && s.length() == t.length()) {
			int[] arry = new int[26];
			for (char c : s.toCharArray()) {
				arry[c - 'a']++;
			}

			for (char c : t.toCharArray()) {
				if (--arry[c - 'a'] < 0) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "ngaram"));
	}
}
