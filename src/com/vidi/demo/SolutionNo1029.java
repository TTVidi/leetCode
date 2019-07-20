package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/7/19 15:50
 * @Descripton : There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is
 * costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 * <p>
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 */
public class SolutionNo1029 {
	public int twoCitySchedCost(int[][] costs) {
		int[] temp0 = new int[1000];
		int[] temp1 = new int[1000];
		int costTotal = 0;
		for (int[] cost : costs) {
			int sub = cost[0] - cost[1];
			if (sub > 0) {
			} else if (sub < 0) {

			} else {
				costTotal += cost[1];
			}

		}
		return costTotal;
	}
}
