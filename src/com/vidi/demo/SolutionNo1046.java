package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/7/19 15:37
 * @Descripton : We have a collection of rocks, each rock has a positive integer weight.
 * <p>
 * Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x
 * <= y.  The result of this smash is:
 * <p>
 * If x == y, both stones are totally destroyed; If x != y, the stone of weight x is totally destroyed, and the stone of
 * weight y has new weight y-x. At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if
 * there are no stones left.)
 */
public class SolutionNo1046 {
	public int lastStoneWeight(int[] stones) {
		if (stones.length == 1) {
			return stones[0];
		}
		int result = 0;
		while ((result = process(stones)) < 0) {

		}
		return result;
	}

	public int process(int[] stones) {
		int max = 0;
		int second = 0;
		if (stones[1] > stones[0]) {
			max = 1;
			second = 0;
		} else {
			max = 0;
			second = 1;
		}
		for (int i = 2; i < stones.length; i++) {
			int stone = stones[i];
			if (stone > stones[max]) {
				second = max;
				max = i;
			} else if (stone > stones[second]) {
				second = i;
			}
		}
		if (stones[second] == 0) {
			return stones[max];
		}
		stones[max] = stones[max] - stones[second];
		stones[second] = 0;
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new SolutionNo1046().lastStoneWeight(new int[]{1, 3}));
	}
}
