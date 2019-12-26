package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/12/25 15:49
 * @Descripton :On a plane there are n points with integer coordinates points[i] = [xi, yi]. Your task is to find the
 * minimum time in seconds to visit all points.
 * <p>
 * You can move according to the next rules:
 * <p>
 * In one second always you can either move vertically, horizontally by one unit or diagonally (it means to move one
 * unit vertically and one unit horizontally in one second). You have to visit the points in the same order as they
 * appear in the array.
 */
public class SolutionNo1266 {
	public int minTimeToVisitAllPoints(int[][] points) {
		int length = points.length;
		int distance = 0;
		for (int i = 0; i < length - 1; i++) {
			int[] current = points[i];
			int[] next = points[i + 1];
			int xDistance = Math.max(current[0], next[0]) - Math.min(current[0], next[0]);
			int yDistance = Math.max(current[1], next[1]) - Math.min(current[1], next[1]);
			distance += Math.max(xDistance, yDistance);
		}
		return distance;
	}
}
