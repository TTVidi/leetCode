package com.vidi.demo.hard;

/**
 * @Author : Vidi
 * @Date : 2019/12/24 14:49
 * @Descripton :Given a string S and a string T, find the minimum window in S which will contain all the characters in T
 * in complexity O(n).
 */
public class SolutionNo76 {
	public String minWindow(String s, String t) {
		char[] array = s.toCharArray();
		String shortest = null;
		StringBuilder sb = new StringBuilder();
		int begin = 0, end = 0;
		while (begin != end) {
			if (t.indexOf(begin) > 0) {

			}
		}
		return null;
	}

	public boolean isContains(String s, String string) {

		return false;
	}

	public static void main(String[] args) {

	}
}
