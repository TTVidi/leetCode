package com.vidi.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Vidi
 * @Date : 2019/1/9 10:50
 * @Descripton :
 * <p>
 * Majority Element
 * <p>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2
 * ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class SolutionNo169 {
	public int majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>(nums.length >> 1 + 1);
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
			if (integerIntegerEntry.getValue() >= (nums.length + 1) >> 1) {
				return integerIntegerEntry.getKey();
			}
		}
		return 0;
	}

	public int majorityElement2(int[] nums) {
		int count = 1;
		int majority = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == majority) {
				count++;
			} else {
				count--;
				if (count == 0) {
					majority = nums[i];
					count = 1;
				}
			}
		}
		return majority;
	}
}
