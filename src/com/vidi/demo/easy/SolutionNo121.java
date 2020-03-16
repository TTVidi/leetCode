package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/29 16:12
 * @Descripton :
 * <p>
 * Best Time to Buy and Sell Stock
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 */
public class SolutionNo121 {
	public static int maxProfit(int[] prices) {
		int maxProfile = 0;
		if (prices != null && prices.length > 0) {
			int min = prices[0];
			for (int i = 1; i < prices.length; i++) {
				maxProfile = Math.max(maxProfile, prices[i] - min);
				min = Math.min(min, prices[i]);
			}
		}
		return maxProfile;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7, 5, 1, 2, 8, 10, 99, 2, 180}));
	}

}
