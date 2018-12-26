package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/26 10:21
 * @Descripton :
 * <p>
 * Reverse Only Letters
 * <p>
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and
 * all letters reverse their positions.
 */
public class SolutionNo917 {
	public static String reverseOnlyLetters(String S) {
		int j = S.length()-1;
		char[] chars = S.toCharArray();
		for (int i = 0; i < j; i++) {
			if ((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z')) {
				while (!(chars[j] >= 'a' && chars[j] <= 'z') && !(chars[j] >= 'A' && chars[j] <= 'Z')) {
					j--;
				}
				if (i < j) {
					char temp = chars[i];
					chars[i] = chars[j];
					chars[j--] = temp;
				}
			}
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
	}
}
