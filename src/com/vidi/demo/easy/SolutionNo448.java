package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2018/12/28 10:08
 * @Descripton :
 * <p>
 * Find All Numbers Disappeared in an Array
 * <p>
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear
 * once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra
 * space.
 */
public class SolutionNo448 {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> results = new ArrayList<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			results.add(i, 0);
		}
		for (int num : nums) {
			results.set(num - 1, 1);
		}
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (results.get(i) == 0) {
				temp.add(i + 1);
			}
		}
		return temp;
	}

	public static List<Integer> findDisappearedNumbers2(int[] nums) {
		List<Integer> results = new ArrayList<>();
		int[] temp = new int[nums.length];
		for (int num : nums) {
			temp[num - 1] = 1;
		}
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 0) {
				results.add(i + 1);
			}
		}
		return results;
	}

	public static void main(String[] args) {
		List<Integer> list = findDisappearedNumbers(new int[]{1, 1});
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
