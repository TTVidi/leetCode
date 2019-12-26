package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/12/26 14:56
 * @Descripton :Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * <p>
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * <p>
 * Return the maximum amount of splitted balanced strings.
 */
public class SolutionNo1221 {
	public int balancedStringSplit(String s) {
		int count = 0;
		int temp = 0;
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			if (aChar == 'L') {
				temp++;
			} else {
				temp--;
			}
			if (temp == 0) {
				count++;
			}
		}
		return count;
	}
}
