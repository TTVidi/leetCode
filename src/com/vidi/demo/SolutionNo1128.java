package com.vidi.demo;

import java.util.HashMap;

/**
 * @Author : Vidi
 * @Date : 2019/8/14 16:48
 * @Descripton : Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if
 * either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.
 * <p>
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to
 * dominoes[j].
 */
public class SolutionNo1128 {
	public int numEquivDominoPairs(int[][] dominoes) {
		HashMap<String, Integer> map = new HashMap<>();
		String temp;
		int result = 0;
		for (int[] dominoe : dominoes) {
			int sum = dominoe[0] + dominoe[1];
			int sub = Math.abs(dominoe[0] - dominoe[1]);
			temp = sum + "," + sub;
			int gt = map.getOrDefault(temp, 0) + 1;
			result += (gt - 1);
			map.put(temp, gt);
		}

		return result;
	}

}
