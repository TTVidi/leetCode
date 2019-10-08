package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/8/15 15:34
 * @Descripton : In a list of songs, the i-th song has a duration of time[i] seconds.
 * <p>
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want
 * the number of indices i < j with (time[i] + time[j]) % 60 == 0.
 */
public class SolutionNo1010 {
	public int numPairsDivisibleBy60(int[] time) {
		int[] rest = new int[60];
		int result = 0;
		for (int i : time) {
			int r = i % 60;
			if (r == 0 || r == 30) {
				result += rest[r];
			}
			rest[r]++;
		}

		for (int i = 1; i < 30; i++) {
			result += (rest[i] * rest[60 - i]);
		}
		return result;
	}

}
