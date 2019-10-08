package com.vidi.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Vidi
 * @Date : 2019/8/23 15:29
 * @Descripton :You are given an array of strings words and a string chars.
 * <p>
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * <p>
 * Return the sum of lengths of all good strings in words.
 */
public class SolutionNo1160 {
	public int countCharacters(String[] words, String chars) {
		Map<Character, Integer> map = new HashMap<>(16);
		for (char c : chars.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int sum = 0;
		for (String word : words) {
			Map<Character, Integer> tempMap = new HashMap<>(16);
			for (char c : word.toCharArray()) {
				tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
			}
			sum += word.length();
			for (Map.Entry<Character, Integer> characterIntegerEntry : tempMap.entrySet()) {
				if (!map.containsKey(characterIntegerEntry.getKey()) || map.get(characterIntegerEntry.getKey()) < characterIntegerEntry.getValue()) {
					sum -= word.length();
					break;
				}
			}
		}
		return sum;
	}
}
