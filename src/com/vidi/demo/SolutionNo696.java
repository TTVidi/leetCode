package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/8 14:35
 * @Descripton :
 * <p>
 * Count Binary Substrings
 * <p>
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and
 * all the 0's and all the 1's in these substrings are grouped consecutively.
 * <p>
 * Substrings that occur multiple times are counted the number of times they occur.
 */
public class SolutionNo696 {
	public static int countBinarySubstrings(String s) {
		int result = 0;
		char[] chars = s.toCharArray();
		int preIndex = 1;
		int index = 1;
		boolean reverse = false;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == chars[i - 1]) {
				if (reverse) {
					index--;
					if (index > 0) {
						result++;
					} else {
						result++;
						index = preIndex;
						reverse = false;
					}
				} else {
					index++;
				}
			} else {
				result++;
				reverse = true;
				preIndex = index;
				index--;

			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(countBinarySubstrings("00100"));
	}
}
