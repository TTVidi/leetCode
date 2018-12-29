package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/29 11:14
 * @Descripton :
 * <p>
 * Rotated Digits
 * <p>
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different
 * from X.  Each digit must be rotated - we cannot choose to leave it alone.
 * <p>
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to
 * each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become
 * invalid.
 * <p>
 * Now given a positive number N, how many numbers X from 1 to N are good?
 */
public class SolutionNo788 {
	public int rotatedDigits(int N) {
		int count = 0;
		String temp;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			temp = String.valueOf(i);
			for (char c : temp.toCharArray()) {
				if (c == '2') {
					sb.append('5');
				} else if (c == '5') {
					sb.append('2');
				} else if (c == '6') {
					sb.append('9');
				} else if (c == '9') {
					sb.append('6');
				} else if (c == '0' || c == '1' || c == '8') {
					sb.append(c);
				} else {
					break;
				}
			}
			if (!sb.toString().equals(temp) && (sb.toString().length() == temp.length())) {
				count++;
			}
			sb = new StringBuilder();
		}
		return count;
	}

	public static void main(String[] args) {
		SolutionNo788 solution = new SolutionNo788();
		System.out.println(solution.rotatedDigits(10));
	}
}
