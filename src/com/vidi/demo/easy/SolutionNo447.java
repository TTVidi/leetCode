package com.vidi.demo;

import java.util.HashMap;

/**
 * @Author : Vidi
 * @Date : 2019/1/14 17:20
 * @Descripton :
 * <p>
 * Number of Boomerangs
 * <p>
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that
 * the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the
 * range [-10000, 10000] (inclusive).
 */
public class SolutionNo447 {
	public static int numberOfBoomerangs(int[][] points) {
		int reuslt = 0;
		HashMap<Integer, Integer> map = new HashMap<>(points.length);
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				int distance = (int) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
				map.put(distance, map.getOrDefault(distance, 0) + 1);
			}

			for (Integer integer : map.values()) {
				reuslt += integer * (integer - 1);
			}
			map.clear();
		}
		return reuslt;
	}

	public static void main(String[] args) {
		System.out.println(numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}}));
//		System.out.println(numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
//		System.out.println((int) Math.pow(3, 2));
	}
}
