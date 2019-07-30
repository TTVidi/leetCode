package com.vidi.demo;

import javax.sound.midi.Track;

/**
 * @Author : Vidi
 * @Date : 2019/7/30 9:15
 * @Descripton : Given a sorted (in ascending order) integer array nums of n elements and a target value, write a
 * function to search target in nums. If target exists, then return its index, otherwise return -1.
 */
public class SolutionNo704 {
	public static int search(int[] nums, int target) {
		if (target > nums[nums.length - 1] || target < nums[0]) {
			return -1;
		}
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	public static int binarySearch(int[] nums, int target, int begin, int end) {
		if (begin == end) {
			if (nums[begin] == target) {
				return begin;
			}
			return -1;
		} else {
			int middle = (begin + end) >> 1;
			int value = nums[middle];
			if (value == target) {
				return middle;
			} else if (value > target) {
				return binarySearch(nums, target, begin, middle - 1);
			}
			return binarySearch(nums, target, middle + 1, end);
		}
	}

	public static void main(String[] args) {
		search(new int[]{2,5}, 0);
	}
}
