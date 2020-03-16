package com.vidi.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2019/12/26 16:16
 * @Descripton :Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference
 * of any two elements.
 * <p>
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 * <p>
 * a, b are from arr a < b b - a equals to the minimum absolute difference of any two elements in arr
 */
public class SolutionNo1200 {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		List<List<Integer>> temp = new ArrayList<>();
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] < min) {
				min = arr[i + 1] - arr[i];
			}
		}
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] == min) {
				List<Integer> t = new ArrayList<>();
				t.add(arr[i]);
				t.add(arr[i + 1]);
				temp.add(t);
			}
		}
		return temp;
	}
}
