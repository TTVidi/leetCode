package com.vidi.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author : Vidi
 * @Date : 2018/12/17 14:47
 * @Descripton :
 * <p>
 * Next Greater Element I
 * <p>
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all
 * the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not
 * exist, output -1 for this number.
 */
public class SolutionNo496 {
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] results = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			int current = nums1[i];
			results[i] = -1;
			int index = nums2.length;
			for (int j = 0; j < nums2.length; j++) {
				if (nums2[j] == current) {
					index = j;
				}
				if (j > index && nums2[j] > current) {
					results[i] = nums2[j];
					break;
				}
			}
		}
		return results;
	}

	public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
		// map from x to next greater element of x
		Map<Integer, Integer> map = new HashMap<>(nums1.length);
		Stack<Integer> stack = new Stack<>();
		for (int num : nums2) {
			while (!stack.isEmpty() && stack.peek() < num) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}
		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = map.getOrDefault(nums1[i], -1);
		}
		return nums1;
	}


	public static void main(String[] args) {
//		int[] greaterElement = nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
		int[] greaterElement = nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});
		for (int i : greaterElement) {
			System.out.print(i + "\t");
		}
	}
}
