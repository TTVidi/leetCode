package com.vidi.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2019/1/23 16:05
 * @Descripton :
 * <p>
 * Relative Ranks
 * <p>
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be
 * awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 */
public class SolutionNo506 {
	public static String[] findRelativeRanks(int[] nums) {
		String[] results = new String[nums.length];
		List<Integer> list = new ArrayList<>();
		for (int num : nums) {
			list.add(num);
		}
		Collections.sort(list);
		HashMap<Integer, Integer> map = new HashMap<>(nums.length);
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i), list.size() - i - 1);
		}
		for (int i = 0; i < nums.length; i++) {
			int temp = nums[i];
			if (map.get(temp) == 0) {
				results[i] = "Gold Medal";
			} else if (map.get(temp) == 1) {
				results[i] = "Silver Medal";
			} else if (map.get(temp) == 2) {
				results[i] = "Bronze Medal";
			} else {
				results[i] = (map.get(temp) + 1) + "";
			}
		}
		return results;
	}

	public static void main(String[] args) {
		String[] relativeRanks = findRelativeRanks(new int[]{5, 4, 3, 2, 1});
		for (String relativeRank : relativeRanks) {
			System.out.println(relativeRank);
		}
	}
}
