package com.vidi.demo;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @Author : Vidi
 * @Date : 2018/12/24 17:00
 * @Descripton :
 * <p>
 * Binary Number with Alternating Bits
 * <p>
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have
 * different values.
 */
public class SolutionNo693 {
	public static boolean hasAlternatingBits(int n) {
		int index = -1;
		while (n >= 1) {
			if (index >= 0) {
				if (index == n % 2) {
					return false;
				}
			}
			index = n % 2;
			n >>= 1;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(hasAlternatingBits(5));
	}
}
