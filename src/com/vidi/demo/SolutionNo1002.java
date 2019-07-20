package com.vidi.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : Vidi
 * @Date : 2019/7/16 16:06
 * @Descripton : Given an array A of strings made only from lowercase letters, return a list of all characters that show
 * up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings
 * but not 4 times, you need to include that character three times in the final answer.
 * <p>
 * You may return the answer in any order.
 */
public class SolutionNo1002 {
	public List<String> commonChars(String[] A) {
		HashMap<Character, Integer> initMap = new HashMap<>(16);
		HashMap<Character, Integer> resultMap = new HashMap<>(16);
		List<String> resultList = new ArrayList<>();
		for (char c : A[0].toCharArray()) {
			initMap.put(c, initMap.getOrDefault(c, 0) + 1);
		}
		for (int i = 1; i < A.length; i++) {
			for (char c : A[i].toCharArray()) {
				if (initMap.containsKey(c)) {
					int count = resultMap.getOrDefault(c, 0) + 1;
					if (initMap.get(c) < count) {
						count = initMap.get(c);
					}
					resultMap.put(c, count);
				}
			}
			initMap = resultMap;
			resultMap = new HashMap<>(16);
		}
		for (Map.Entry<Character, Integer> characterIntegerEntry : initMap.entrySet()) {
			int value = characterIntegerEntry.getValue();
			while (value-- > 0) {
				resultList.add(characterIntegerEntry.getKey() + "");
			}
		}
		return resultList;
	}

	public static void main(String[] args) {
		for (String s : new SolutionNo1002().commonChars(new String[]{"cool","lock","cook"})) {
			System.out.println(s);
		}
	}
}
