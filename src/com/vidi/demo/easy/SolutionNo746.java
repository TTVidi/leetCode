package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/29 16:46
 * @Descripton :
 * <p>
 * Min Cost Climbing Stairs
 * <p>
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the
 * floor, and you can either start from the step with index 0, or the step with index 1.
 */
public class SolutionNo746 {
	public static int minCostClimbingStairs(int[] cost) {
		for (int i = 2; i < cost.length; i++) {
			cost[i] += Math.min(cost[i - 1], cost[i - 2]);
		}
		return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
	}

	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}

}
