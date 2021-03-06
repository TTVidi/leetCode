package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/7/30 8:50
 * @Descripton : In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is
 * secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody. Everybody (except for the town judge) trusts the town judge. There is exactly one
 * person that satisfies properties 1 and 2. You are given trust, an array of pairs trust[i] = [a, b] representing that
 * the person labelled a trusts the person labelled b.
 * <p>
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 */
public class SolutionNo997 {
	public int findJudge(int N, int[][] trust) {
		int[] trustArr = new int[N];
		int[] trustedArr = new int[N];
		for (int[] ints : trust) {
			trustArr[ints[0] - 1]++;
			trustedArr[ints[1] - 1]++;
		}
		for (int i = 0; i < trustedArr.length; i++) {
			if (trustedArr[i] == N - 1 && trustArr[i] == 0) {
				return i + 1;
			}
		}
		return -1;
	}
}
