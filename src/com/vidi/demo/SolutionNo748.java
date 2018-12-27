package com.vidi.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Vidi
 * @Date : 2018/12/27 14:19
 * @Descripton :
 * <p>
 * Shortest Completing Word
 * <p>
 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate.
 * Such a word is said to complete the given string licensePlate
 * <p>
 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
 * <p>
 * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
 * <p>
 * The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the
 * word "pair" does not complete the licensePlate, but the word "supper" does.
 */
public class SolutionNo748 {
	public String shortestCompletingWord(String licensePlate, String[] words) {
		String result = null;
		HashMap<Character, Integer> map = new HashMap<>(licensePlate.length());
		char[] lowerChars = licensePlate.toLowerCase().toCharArray();
		for (char lowerChar : lowerChars) {
			if (lowerChar >= 'a' && lowerChar < 'z') {
				if (map.containsKey(lowerChar)) {
					map.put(lowerChar, map.get(lowerChar) + 1);
				} else {
					map.put(lowerChar, 1);
				}
			}
		}
		for (String word : words) {
			word = word.toLowerCase();
			boolean allContains = true;
			for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
				if (findCharCount(word, characterIntegerEntry.getKey()) < characterIntegerEntry.getValue()) {
					allContains = false;
					break;
				}
			}
			if (allContains) {
				if (result == null) {
					result = word;
				} else {
					result = result.length() > word.length() ? word : result;
				}
			}
		}
		return result;
	}

	public int findCharCount(String word, Character character) {
		int count = 0;
		char[] chars = word.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == character) {
				count++;
			}
		}
		return count;
	}

	private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

	public String shortestCompletingWord2(String licensePlate, String[] words) {
		long charProduct = getCharProduct(licensePlate.toLowerCase());
		String shortest = "aaaaaaaaaaaaaaaaaaaa"; // 16 a's
		for (String word : words) {
			if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0) {
				shortest = word;
			}
		}
		return shortest;
	}

	private long getCharProduct(String plate) {
		long product = 1L;
		for (char c : plate.toCharArray()) {
			int index = c - 'a';
			if (0 <= index && index <= 25) {
				product *= primes[index];
			}
		}
		return product;
	}

	public static void main(String[] args) {
		SolutionNo748 solutinon = new SolutionNo748();
		System.out.println(solutinon.shortestCompletingWord2("GrC8950", new String[]{"measure", "other", "every", "base", "according", "level", "meeting", "none", "marriage", "rest"}));
	}
}

