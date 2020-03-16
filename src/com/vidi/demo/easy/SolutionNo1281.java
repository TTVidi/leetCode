package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/12/25 15:35
 * @Descripton :Given an integer number n, return the difference between the product of its digits and the sum of its
 * digits.
 */
public class SolutionNo1281 {
	public static int subtractProductAndSum(int n) {
		int sum = 0;
		int product = 1;
		while (n != 0) {
			int left = n % 10;
			n /= 10;
			sum += left;
			product *= left;
		}
		return product - sum;
	}

	public static void main(String[] args) {
		System.out.println(subtractProductAndSum(4421));
	}
}
