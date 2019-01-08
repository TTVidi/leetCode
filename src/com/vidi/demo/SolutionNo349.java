package com.vidi.demo;

import java.util.*;

/**
 * @Author : Vidi
 * @Date : 2019/1/8 10:09
 * @Descripton :
 * <p>
 * Intersection of Two Arrays
 * <p>
 * Given two arrays, write a function to compute their intersection.
 */
public class SolutionNo349 {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> temp = new HashSet<>(nums1.length);
		for (int i : nums1) {
			temp.add(i);
		}

		Set<Integer> tempSet = new HashSet<>(temp.size());
		for (int i : nums2) {
			if (temp.contains(i)) {
				tempSet.add(i);
			}
		}

		int[] result = new int[tempSet.size()];
		Iterator<Integer> iterator = tempSet.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			result[i++] = next;
		}
		return result;
	}

	public static int[] intersection2(int[] nums1, int[] nums2) {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		int[] ans = new int[nums1.length];
		int idx = 0;
		for (int i : nums1) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
		}
		for (int i : nums2) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
		}
		boolean[] map = new boolean[max - min + 1];
		for (int i : nums1) {
			map[i - min] = true;
		}
		for (int i : nums2) {
			if (map[i - min]) {
				ans[idx++] = i;
				map[i - min] = false;
			}
		}
		return Arrays.copyOf(ans, idx);
	}

	public static void main(String[] args) {
		intersection2(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
	}
}
