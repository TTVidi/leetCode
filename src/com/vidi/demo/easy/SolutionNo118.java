package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2019/8/6 15:29
 * @Descripton :Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 */
public class SolutionNo118 {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = null;
		for (int i = 1; i <= numRows; i++) {
			temp = new ArrayList<>(i);
			for (int j = 1; j <= i; j++) {
				if (j == 1 || j == i) {
					temp.add(1);
				} else {
					temp.add(result.get(result.size() - 1).get(j - 2) + result.get(result.size() - 1).get(j - 1));
				}
			}
			result.add(temp);
		}
		return result;
	}
}
