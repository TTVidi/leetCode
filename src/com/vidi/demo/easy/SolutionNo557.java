package com.vidi.demo;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author : Vidi
 * @Date : 2018/11/29 9:11
 * @Descripton :
 * <p>
 * Reverse Words in a String III
 * <p>
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving
 * whitespace and initial word order.
 */
public class SolutionNo557 {
	public static String reverseWords(String s) {
		int firstIndex = 0;
		int nextIndex = 0;
		int preIndex = firstIndex - 1;
		char[] charArray = s.toCharArray();
		while (preIndex != nextIndex && nextIndex >= 0) {
			preIndex = nextIndex;
			nextIndex = s.indexOf(" ", firstIndex);
			firstIndex = nextIndex + 1;
			int begin = preIndex - 1 > 0 ? preIndex + 1 : 0;
			int end = nextIndex - 1 > 0 ? nextIndex - 1 : s.length() - 1;
			for (int i = begin; i < (end - begin) / 2 + begin; i++) {
				char temp = charArray[i];
				System.out.print(temp);
//				charArray[i] = charArray[end - i - 1];
//				charArray[end - i - 1] = temp;
			}
			System.out.println();
		}
		return new String(charArray);
	}

	public static String reverseWords2(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(s.length() - i - 1));
		}
		String[] split = sb.toString().split(" ");
		sb = new StringBuilder();
		for (int i = 0; i < split.length; i++) {
			sb.append(split[split.length - 1 - i]).append(" ");
		}
		sb.deleteCharAt(s.length());
		return sb.toString();
	}

	public static String reverseWords3(String s) {
		return Arrays.stream(s.split(" ")).map(e -> new StringBuilder(e).reverse().toString()).collect(Collectors.joining(" "));
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}
}
