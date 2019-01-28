package com.vidi.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2019/1/28 9:49
 * @Descripton :
 * <p>
 * Minimum Index Sum of Two Lists
 * <p>
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants
 * represented by strings.
 * <p>
 * You need to help them find out their common interest with the least list index sum. If there is a choice tie between
 * answers, output all of them with no order requirement. You could assume there always exists an answer.
 */
public class SolutionNo599 {
	public static String[] findRestaurant(String[] list1, String[] list2) {
		int index = list1.length + list2.length;
		List<String> list = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>(list1.length);
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}
		for (int i = 0; i < list2.length; i++) {
			if (map.containsKey(list2[i])) {
				int temp = map.get(list2[i]) + i;
				if (temp == index) {
					list.add(list2[i]);
				} else if ( temp< index) {
					index = temp;
					list = new ArrayList<>();
					list.add(list2[i]);
				}
			}
		}
		String[] ans = new String[list.size()];
		for(int i = 0; i < list.size(); i++){
			ans[i] = list.get(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		for (String s : findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"})) {
			System.out.println(s);
		}
	}
}
