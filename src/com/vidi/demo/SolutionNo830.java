package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2019/1/28 9:19
 * @Descripton :
 * <p>
 * Positions of Large Groups
 * <p>
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 * <p>
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 * <p>
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large
 * group.
 * <p>
 * The final answer should be in lexicographic order.
 */
public class SolutionNo830 {
	public static List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> result = new ArrayList<>();
		int index = 1;
		char[] chars = S.toCharArray();
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == chars[i - 1]) {
				index++;
			} else {
				if (index >= 3) {
					List<Integer> temp = new ArrayList<>();
					temp.add(i - index);
					temp.add(i - 1);
					result.add(temp);
				}
				index = 1;
			}
		}
		if (index >= 3) {
			List<Integer> temp = new ArrayList<>();
			temp.add(S.length() - index);
			temp.add(S.length() - 1);
			result.add(temp);
		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> listList = largeGroupPositions("aaa");
		System.out.println(1);
	}
}
