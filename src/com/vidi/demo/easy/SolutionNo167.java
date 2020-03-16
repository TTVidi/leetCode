package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/16 9:03
 * @Descripton :
 * <p>
 * Two Sum II - Input array is sorted
 * <p>
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based. You may assume that each input would have exactly
 * one solution and you may not use the same element twice.
 */
public class SolutionNo167 {
	public static int[] twoSum(int[] numbers, int target) {
		int i = 0, j = numbers.length - 1;
		while (i < j) {
			int temp = numbers[i] + numbers[j];
			if (temp < target) {
				i++;
			} else if (temp > target) {
				j--;
			} else {
				return new int[]{i + 1, j + 1};
			}

		}
		return numbers;
	}

	public static void main(String[] args) {
		int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
		for (int anInt : ints) {
			System.out.println(anInt);
		}
	}
}
