package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/2/1 16:42
 * @Descripton :
 * <p>
 * Reverse String II
 * <p>
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the
 * start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but
 * greater than or equal to k characters, then reverse the first k characters and left the other as original.
 */
public class SolutionNo541 {
	public static String reverseStr(String s, int k) {
		char[] chars = s.toCharArray();
		int index = 0;
		if (k >= s.length()) {
			return new StringBuilder(s).reverse().toString();
		}
		while (index < s.length()) {
			int right = index + k >= s.length() ? s.length() - 1 : index + k;
			for (int i = index; i < ((right + index) >> 1); i++) {
				char temp = chars[i];
				chars[i] = chars[right + index - i - 1];
				chars[right + index - i - 1] = temp;
			}
			index = right + k;
		}
		return String.valueOf(chars);
	}

	public static void main(String[] args) {
		System.out.println(reverseStr("abcdefg", 2));
	}
}
