package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/7/16 14:59
 * @Descripton :Students are asked to stand in non-decreasing order of heights for an annual photo.
 * <p>
 * Return the minimum number of students not standing in the right positions.  (This is the number of students that must
 * move in order for all students to be standing in non-decreasing order of height.)
 */
public class SolutionNo1051 {
	public int heightChecker(int[] heights) {
		int[] temp = new int[101];
		int result = 0;
		for (int height : heights) {
			temp[height]++;
		}
		for (int i = 0; i < heights.length; i++) {
			int begin = count(temp, heights[i]);
			int end = begin + temp[heights[i]];
			if (i < begin || i >= end) {
				result++;
			}
		}
		return result;
	}

	public int count(int[] temp, int i) {
		int result = 0;
		for (int j = 0; j < i; j++) {
			result += temp[j];
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new SolutionNo1051().heightChecker(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
	}
}
