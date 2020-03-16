package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2019/8/15 14:40
 * @Descripton : Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a
 * binary number (from most-significant-bit to least-significant-bit.)
 * <p>
 * Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
 */
public class SolutionNo1018 {
	public List<Boolean> prefixesDivBy5(int[] A) {
		List<Boolean> list = new ArrayList<>(A.length);
		int current = 0;
		for (int i = 0; i < A.length; i++) {
			current <<= 1;
			current += A[i];
			current %= 5;
			list.add(current == 0);
		}
		return list;
	}
}
