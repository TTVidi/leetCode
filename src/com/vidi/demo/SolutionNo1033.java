package com.vidi.demo;

import java.util.Arrays;

/**
 * @Author : Vidi
 * @Date : 2019/8/15 14:26
 * @Descripton : Three stones are on a number line at positions a, b, and c.
 * <p>
 * Each turn, you pick up a stone at an endpoint (ie., either the lowest or highest position stone), and move it to an
 * unoccupied position between those endpoints.  Formally, let's say the stones are currently at positions x, y, z with
 * x < y < z.  You pick up the stone at either position x or position z, and move that stone to an integer position k,
 * with x < k < z and k != y.
 * <p>
 * The game ends when you cannot make any more moves, ie. the stones are in consecutive positions.
 * <p>
 * When the game ends, what is the minimum and maximum number of moves that you could have made?  Return the answer as
 * an length 2 array: answer = [minimum_moves, maximum_moves]
 */
public class SolutionNo1033 {
	public int[] numMovesStones(int a, int b, int c) {
		int arr[] = {a,b,c};
		Arrays.sort(arr);
		int diff1 = arr[1] - arr[0] - 1;
		int diff2 = arr[2] - arr[1] - 1;
		if(diff1 == 0 && diff2 == 0)
			return new int[]{0,0};
		if(diff1 == 0 || diff2 == 0)
			return new int[]{1, Math.max(diff1,diff2)};
		if(diff1 == 1 || diff2 == 1)
			return new int[]{1, diff1 + diff2};
		return new int[]{2, diff1 + diff2};
	}
}
