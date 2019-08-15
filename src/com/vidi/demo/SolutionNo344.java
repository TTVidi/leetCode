package com.vidi.demo;

/**
 * <p>
 * Reverse String
 * <p>
 * Write a function that takes a string as input and returns the string reversed.
 */
public class SolutionNo344 {
	public static String reverseString(String s) {
		if (s == null) {
			return s;
		}
		char[] charArray = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			charArray[i] = s.charAt(s.length() - 1 - i);
		}
		return new String(charArray);
	}

	public static String reverseString2(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}

	public static String reverseString3(String s) {
		if (s == null) {
			return s;
		}
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		for (int i = 0; i < length / 2; i++) {
			char temp = charArray[i];
			charArray[i] = charArray[length - 1 - i];
			charArray[length - 1 - i] = temp;
		}
		return new String(charArray);
	}


	public static void main(String[] args) {
		System.out.println(reverseString3("hello"));
	}
}
