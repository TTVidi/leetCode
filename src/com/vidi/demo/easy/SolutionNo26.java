package com.vidi.demo;

import java.util.Arrays;

/**
 * @Author : Vidi
 * @Date : 2019/10/8 8:46
 * @Descripton : Given a sorted array nums, remove the duplicates in-place such that each element appear only once and
 * return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra
 * memory.
 */
public class SolutionNo26 {
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int pre = nums[0];
		int min = pre - 1;
		int length = nums.length;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == pre) {
				nums[i] = min;
				length--;
			} else {
				pre = nums[i];
			}
		}
		if (length < nums.length) {
			int index = -1;
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] == min) {
					if (index < 0) {
						index = i;
					}
				} else {
					if (index > 0) {
						nums[index] = nums[i];
						nums[i] = min;
						for (int j = index + 1; j < nums.length; j++) {
							if (nums[j] == min) {
								index = j;
								break;
							}
						}
					}
				}
			}
			nums = Arrays.copyOf(nums, length);
		}
		return length;
	}

	public static int removeDuplicates2(int[] nums) {
		int i = 0;
		int j = 1;
		while( j < nums.length ){
			while (nums[i]==nums[j]){
				if(j == nums.length-1) {
					return i + 1;
				}
				j++;
			}
			nums[i+1]=nums[j];
			i++;
			j++;
		}
		return i+1;
	}

	public static void main(String[] args) {
		int[] ss = new int[]{1, 2, 2};
		System.out.println(removeDuplicates(ss));
		for (int s : ss) {
			System.out.println(s);
		}
	}
}
