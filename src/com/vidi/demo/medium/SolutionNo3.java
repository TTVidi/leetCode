package com.vidi.demo.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Vidi
 * @Date : 2019/11/19 9:26
 * @Descripton :Given a string, find the length of the longest substring without repeating characters.
 */
public class SolutionNo3 {
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		char[] chars = s.toCharArray();
		int result = 0;
		int subIndex = 0;
		for (int i = 0; i < chars.length; i++) {
			char aChar = chars[i];
			Integer index = map.get(aChar);
			if (index != null) {
				result = Math.max((i - subIndex), result);
				if (index >= subIndex) {
					subIndex = index + 1;
				}
			}
			map.put(aChar, i);
		}
		result = Math.max((chars.length - subIndex), result);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("aab"));
	}
}
