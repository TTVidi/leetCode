package com.vidi.demo;

import java.util.Arrays;

/**
 * @Author : Vidi
 * @Date : 2019/1/23 14:09
 * @Descripton :
 * <p>
 * Assign Cookies
 * <p>
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most
 * one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content
 * with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will
 * be content. Your goal is to maximize the number of your content children and output the maximum number.
 * <p>
 * Note: You may assume the greed factor is always positive. You cannot assign more than one cookie to one child.
 */
public class SolutionNo455 {
	public static int findContentChildren(int[] g, int[] s) {
		if (g == null || s == null || g.length == 0 || s.length == 0) {
			return 0;
		}
		Arrays.sort(g);
		Arrays.sort(s);
		int index = s.length - 1;
		int content = 0;
		for (int i = g.length - 1; i >= 0 && index >= 0; i--) {
			if (s[index] >= g[i]) {
				content++;
				index--;
			}
		}
		return content;
	}

	public static void main(String[] args) {
		System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{3}));
	}
}
