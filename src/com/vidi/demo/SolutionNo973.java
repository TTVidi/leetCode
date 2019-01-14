package com.vidi.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : Vidi
 * @Date : 2019/1/14 9:30
 * @Descripton :
 * <p>
 * K Closest Points to Origin
 * <p>
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 */
public class SolutionNo973 {
	public int[][] kClosest(int[][] points, int K) {
		if (points != null && points.length != 0) {
			int[][] temp = new int[K][2];
			temp[0] = points[0];
			if (points.length > 1) {
				for (int i = 1; i < points.length; i++) {
					temp = insertSort(temp, points[i]);
				}
			}
			return temp;
		}
		return null;
	}

	public int[][] insertSort(int[][] temp, int[] value) {
		int i = 0;
		for (; i < temp.length; i++) {
			int[] ints = temp[i];
			if ((ints[0] * ints[0] + ints[1] * ints[1] > value[0] * value[0] + value[1] * value[1]) || (ints[0] == 0 && ints[1] == 0)) {
				break;
			}
		}

		if ((i == temp.length - 1)) {
			temp[i] = value;
		}

		if (i < temp.length) {
			if (!(temp[i][0] == 0 && temp[i][1] == 0)) {
				for (int j = temp.length - 1; j > i; j--) {
					temp[j] = temp[j - 1];
				}
			}
			temp[i] = value;
		}
		return temp;
	}

	public int[][] kClosest2(int[][] points, int K) {
		List<int[]> collect = Arrays.stream(points).sorted(Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * +o[1]))).limit(K).collect(Collectors.toList());
		int[][] result = new int[K][2];
		collect.toArray(result);
		return result;
	}

	public static void main(String[] args) {
		SolutionNo973 solution = new SolutionNo973();
		int[][] ints = solution.kClosest2(new int[][]{{5, -3}, {3, -4}, {-2, 9}, {-8, -8}, {-6, 5}, {6, 1}, {5, 9}}, 6);
		for (int[] anInt : ints) {
			for (int i : anInt) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}
}
