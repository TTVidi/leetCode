package com.vidi.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Vidi
 * @Date : 2018/12/24 9:24
 * @Descripton :
 * <p>
 * N-Repeated Element in Size 2N Array
 * <p>
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 * <p>
 * Return the element repeated N times.
 */
public class SolutionNo961 {
	public int repeatedNTimes(int[] A) {
		Map<Integer, Integer> results = new HashMap<>(A.length / 2 + 1);
		for (int i : A) {
			if (results.containsKey(i)) {
				results.put(i, results.get(i) + 1);
			} else {
				results.put(i, 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : results.entrySet()) {
			if (entry.getValue() == A.length / 2) {
				return entry.getKey();
			}
		}
		return 0;
	}
}
