package com.vidi.demo;

import java.util.HashMap;

/**
 * @Author : Vidi
 * @Date : 2019/1/17 16:35
 * @Descripton :
 * <p>
 * Degree of an Array
 * <p>
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency
 * of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as
 * nums.
 */
public class SolutionNo697 {
	public static int findShortestSubArray(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>(nums.length);
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int min = Integer.MAX_VALUE;
		int degree = Integer.MIN_VALUE;
		for (Integer value : map.values()) {
			if (value > degree) {
				degree = value;
			}
		}
		for (Integer key : map.keySet()) {
			if (map.get(key) == degree) {
				int begin = 0;
				int end = nums.length - 1;
				while (nums[begin] != key) {
					begin++;
				}
				while (nums[end] != key) {
					end--;
				}
				min = Math.min(min, end - begin + 1);
			}
		}
		return min;
	}

	public static int findShortestSubArray2(int[] nums) {
		int maxFreq = 0;
		int minLength = nums.length;
		HashMap<Integer, int[]> map = new HashMap<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int[] temp;
			if (map.containsKey(num)) {
				temp = map.get(num);
				temp[0]++;
				temp[2] = i;

			} else {
				temp = new int[]{1, i, i};
				map.put(num, temp);
			}
			if (temp[0] > maxFreq) {
				maxFreq = temp[0];
				minLength = temp[2] - temp[1] + 1;
			} else if (temp[0] == maxFreq) {
				minLength = Math.min(minLength, temp[2] - temp[1] + 1);
			}
		}
		return minLength;
	}

	public static void main(String[] args) {
		System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 1, 2, 2}));
	}
}
