package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/8/15 11:37
 * @Descripton : A boomerang is a set of 3 points that are all distinct and not in a straight line.
 * <p>
 * Given a list of three points in the plane, return whether these points are a boomerang.
 */
public class SolutionNo1037 {
	public boolean isBoomerang(int[][] points) {
		return (points[0][0] - points[1][0]) * (points[0][1] - points[2][1])
				!= (points[0][0] - points[2][0]) * (points[0][1] - points[1][1]);
	}
}
