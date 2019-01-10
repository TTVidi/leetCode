package com.vidi.demo;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author : Vidi
 * @Date : 2019/1/10 8:55
 * @Descripton :
 * <p>
 * Contains Duplicate
 * <p>
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array, and it should return false if
 * every element is distinct.
 */
public class SolutionNo217 {
	public boolean containsDuplicate(int[] nums) {
		if (nums != null && nums.length > 0) {
			if (nums.length == 1) {
				return false;
			} else {
				HashSet<Integer> set = new HashSet<>(nums.length);
				for (int num : nums) {
					if (set.contains(num)) {
						return true;
					}
					set.add(num);
				}
			}
		}
		return false;
	}

}
