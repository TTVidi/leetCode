package com.vidi.demo;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author : Vidi
 * @Date : 2019/1/29 10:26
 * @Descripton :
 * <p>
 * Intersection of Two Arrays II
 * <p>
 * Given two arrays, write a function to compute their intersection.
 */
public class SolutionNo350 {
	public static int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>(nums1.length);
		for (int i : nums1) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		LinkedList<Integer> list = new LinkedList<>();
		for (int i : nums2) {
			if (map.containsKey(i)) {
				Integer integer = map.get(i);
				if (integer > 0) {
					list.add(i);
					integer--;
					map.put(i, integer);
				}
			}
		}
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] intersect = intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
		for (int i : intersect) {
			System.out.println(i);
		}
	}
}
