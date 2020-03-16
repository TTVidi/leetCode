package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/9 9:53
 * @Descripton :
 * <p>
 * Sum of Two Integers
 * <p>
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 */
public class SolutionNo371 {
	public int getSum(int a, int b) {
		int carry, add;
		do {
			add = a ^ b;
			carry = (a & b) << 1;
			a = add;
			b = carry;
		} while (carry != 0);
		return add;
	}
}
