package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/9 14:51
 * @Descripton :
 * <p>
 * Best Time to Buy and Sell Stock II
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and
 * sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy
 * again).
 */
public class SolutionNo122 {
	public static int maxProfit(int[] prices) {
		int result = 0;
		int i = 0;
		for (; i < prices.length - 1; i++) {
			if (prices[i] < prices[i + 1]) {
				result += (prices[i + 1] - prices[i]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7,6,4,3,1}));
	}
}
