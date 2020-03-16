package com.vidi.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : Vidi
 * @Date : 2018/12/4 10:24
 * @Descripton :
 * <p>
 * Uncommon Words from Two Sentences
 * <p>
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of
 * lowercase letters.)
 * <p>
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * <p>
 * Return a list of all uncommon words.
 * <p>
 * You may return the list in any order.
 */
public class SolutionNo884 {
	public static String[] uncommonFromSentences(String A, String B) {
		List<String> results = new ArrayList<>();
		Map<String, Integer> tempMap = new HashMap<>();
		for (String s : (A + " " + B).split(" ")) {
			if (tempMap.containsKey(s)) {
				tempMap.put(s, tempMap.get(s) + 1);
			} else {
				tempMap.put(s, 1);
			}
		}
		for (Map.Entry<String, Integer> stringIntegerEntry : tempMap.entrySet()) {
			if (stringIntegerEntry.getValue() == 1) {
				results.add(stringIntegerEntry.getKey());
			}
		}
		return results.toArray(new String[results.size()]);
	}

	public static void main(String[] args) {
		uncommonFromSentences("this apple is sweet", "this apple is sour");
	}


}
