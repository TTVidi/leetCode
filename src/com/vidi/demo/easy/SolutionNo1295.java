package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/12/25 15:26
 * @Descripton :Given an array nums of integers, return how many of them contain an even number of digits.
 */
public class SolutionNo1295 {
	public static int findNumbers(int[] nums) {
		int count = 0;
		for (int num : nums) {
			count += digitsIsEven(num);
		}
		return count;
	}

	private static int digitsIsEven(int number) {
		int i;
		for (i = 0; i < 7; i++) {
			number /= 10;
			if (number == 0) {
				break;
			}
		}
		return i % 2;
	}

	public static void main(String[] args) {
		System.out.println(findNumbers(new int[]{555,901,482,1771}));
	}
}
