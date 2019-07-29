package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/7/23 15:54
 * @Descripton : Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101"
 * in binary, 11 as "1011" in binary, and so on.  Note that except for N = 0, there are no leading zeroes in any binary
 * representation.
 * <p>
 * The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.
 * For example, the complement of "101" in binary is "010" in binary.
 * <p>
 * For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.
 */
public class SolutionNo1009 {
	public int bitwiseComplement(int N) {
		if (N == 0) {
			return 1;
		}
		int i = 1;
		while (i < N) {
			i *= 2;
		}
		i = i - N - 1;
		return (i + N) % N;
	}
}
