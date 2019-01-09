package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/9 14:40
 * @Descripton :
 * <p>
 * Excel Sheet Column Number
 * <p>
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ...
 */
public class SolutionNo171 {
	public static int titleToNumber(String s) {
		int result = 0;
		int index = 1;
		char[] chars = s.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
			result += (chars[i] - 'A' + 1) * index;
			index *= 26;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber("ZY"));
	}
}
