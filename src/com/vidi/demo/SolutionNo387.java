package com.vidi.demo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author : Vidi
 * @Date : 2019/1/16 9:27
 * @Descripton :
 * <p>
 * First Unique Character in a String
 * <p>
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 */
public class SolutionNo387 {
	public static int firstUniqChar(String s) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			map.put(aChar, map.getOrDefault(aChar, 0) + 1);
		}
		for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
			if (characterIntegerEntry.getValue() == 1) {
				return s.indexOf(characterIntegerEntry.getKey());
			}
		}
		return -1;
	}

	public static int firstUniqChar2(String s) {
		char[] chars = s.toCharArray();
		int[] array = new int[26];
		for (char aChar : chars) {
			array[aChar - 'a']++;
		}
		for (int i = 0; i < chars.length; i++) {
			if (array[chars[i] - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(firstUniqChar2("loveleetcode"));
	}
}
