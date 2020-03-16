package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/10 17:18
 * @Descripton :
 * <p>
 * Rotate String
 * <p>
 * We are given two strings, A and B.
 * <p>
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if
 * A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some
 * number of shifts on A.
 */
public class SolutionNo796 {
	public static boolean rotateString(String A, String B) {
		if (A.length() == B.length()) {
			if (A.length() == 0) {
				return true;
			}
			for (int i = 0; i < B.length(); i++) {
				A = rotate(A);
				if (A.equals(B)) {
					return true;
				}
			}
		}
		return false;
	}

	public static String rotate(String A) {
		return A.substring(1) + A.charAt(0);
	}

	public static boolean rotateString2(String A, String B) {
		String C = B + A;
		return C.contains(B) && A.length() == B.length();
	}

	public static void main(String[] args) {
		System.out.println(rotateString("", ""));
		System.out.println("".length());
	}

}
