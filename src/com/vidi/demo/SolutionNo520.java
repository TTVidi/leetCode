package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/28 11:24
 * @Descripton :
 * <p>
 * Detect Capital
 * <p>
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA". All letters in this word are not capitals, like "leetcode". Only
 * the first letter in this word is capital if it has more than one letter, like "Google". Otherwise, we define that
 * this word doesn't use capitals in a right way.
 */
public class SolutionNo520 {
	public static boolean detectCapitalUse(String word) {
		if (word.length() <= 1) {
			return true;
		}
		char[] chars = word.toCharArray();
		boolean firstCaptial = chars[0] >= 'A' && chars[0] <= 'Z';
		boolean secondCaptial = chars[1] >= 'A' && chars[1] <= 'Z';
		for (int i = 1; i < chars.length; i++) {
			if (!firstCaptial && (chars[i] >= 'A' && chars[i] <= 'Z')) {
				return false;
			}
			if (secondCaptial && (chars[i] >= 'a' && chars[i] <= 'z')) {
				return false;
			}
			if (!secondCaptial && (chars[i] >= 'A' && chars[i] <= 'Z')) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(detectCapitalUse("Leetcode"));
	}
}
