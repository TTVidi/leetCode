package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/6 16:35
 * @Descripton :
 * <p>
 * Binary Gap
 * <p>
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary
 * representation of N.
 * <p>
 * If there aren't two consecutive 1's, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 22 Output: 2 Explanation: 22 in binary is 0b10110. In the binary representation of 22, there are three ones,
 * and two consecutive pairs of 1's. The first consecutive pair of 1's have distance 2. The second consecutive pair of
 * 1's have distance 1. The answer is the largest of these two distances, which is 2.
 */
public class SolutionNo868 {
	public static int binaryGap(int N) {
		int distance = 0;
		int preindex = -1;
		int nextIndex = -1;
		int count = 0;
		while (N != 1) {
			count++;
			if (N % 2 == 1) {
				if (preindex == -1) {
					preindex = 0;
					nextIndex = count;
				} else {
					preindex = nextIndex;
					nextIndex = count;
					distance = nextIndex - preindex > distance ? nextIndex - preindex : distance;
				}
			}
			N = N / 2;
		}
		if (nextIndex > 0) {
			count++;
			if (count - nextIndex > distance) {
				distance = count - nextIndex;
			}
		}
		return distance;
	}

	public int binaryGap2(int N) {
		int res = 0;
		for (int d = -32; N > 0; N /= 2, d++) {
			if (N % 2 == 1) {
				res = Math.max(res, d);
				d = 0;
			}
		}
		return res;
	}

	public static String binaryToTen(int number) {
		StringBuilder sb = new StringBuilder();
		while (number != 1) {
			sb.append(number % 2);
			number = number / 2;
		}
		sb.append("1");
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(binaryGap(8));
	}
}
