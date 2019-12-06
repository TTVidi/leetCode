package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2019/12/6 10:39
 * @Descripton : Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring
 * cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 */
public class SolutionNo125 {
	public static boolean isPalindrome(String s) {
		if (s.length() == 0) {
			return true;
		}
		s = s.toLowerCase();
		char[] chars = s.toCharArray();
		List<Character> list = new ArrayList<>();
		for (char aChar : chars) {
			if ((aChar >= 'a' && aChar <= 'z') || (aChar >= '0' && aChar <= '9')) {
				list.add(aChar);
			}
		}
		int size = list.size();
		if (size > 0) {
			int end = size >> 1;
			for (int i = 0; i < end; i++) {
				if (!list.get(i).equals(list.get(size - i - 1))) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("race a car"));
	}
}
