package com.vidi.demo;

import java.util.HashMap;

/**
 * @Author : Vidi
 * @Date : 2018/12/10 9:28
 * @Descripton :
 * <p>
 * Verifying an Alien Dictionary
 * <p>
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The
 * order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if
 * the given words are sorted lexicographicaly in this alien language.
 */
public class SolutionNo953 {
	public static boolean isAlienSorted(String[] words, String order) {
		HashMap<Character, Integer> orderMap = new HashMap<>();
		char[] charArray = order.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			orderMap.put(charArray[i], i);
		}
		char[] currentArray = words[0].toCharArray();
		char[] nextArray;
		for (int i = 0; i < words.length - 1; i++) {
			nextArray = words[i + 1].toCharArray();
			int j = 0;
			boolean isMatch = false;
			while (j < currentArray.length && j < nextArray.length && !isMatch) {
				if (orderMap.get(currentArray[j]) < orderMap.get(nextArray[j])) {
					isMatch = true;
				}
				if (orderMap.get(currentArray[j]) > orderMap.get(nextArray[j])) {
					return false;
				}
				j++;
			}
			if (!isMatch && currentArray.length > nextArray.length) {
				return false;
			}
			currentArray = nextArray;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAlienSorted(new String[]{"fxasxpc", "dfbdrifhp", "nwzgs",
						"cmwqriv", "ebulyfyve", "miracx", "sxckdwzv",
						"dtijzluhts", "wwbmnge", "qmjwymmyox"},
				"zkgwaverfimqxbnctdplsjyohu"));
		System.out.println(isAlienSorted(new String[]{"hello", "leetcode"},
				"hlabcdefgijkmnopqrstuvwxyz"));
		System.out.println(isAlienSorted(new String[]{"word", "world", "row"},
				"worldabcefghijkmnpqstuvxyz"));
		System.out.println(isAlienSorted(new String[]{"apple", "app"},
				"abcdefghijklmnopqrstuvwxyz"));
	}
}
