package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/26 17:04
 * @Descripton :
 * <p>
 * Largest Triangle Area
 * <p>
 * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the
 * points.
 */
public class SolutionNo812 {
	public static double largestTriangleArea(int[][] points) {
		double area = 0;
		for (int[] a : points) {
			for (int[] b : points) {
				for (int[] c : points) {
					double tempArea = (double) (a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - a[0] * c[1] - b[0] * a[1] - c[0] * b[1]) / 2;
					area = area > tempArea ? area : tempArea;
				}
			}
		}
		return area;
	}

	public double largestTriangleArea2(int[][] points) {
		int n = points.length;
		double max = 0;

		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				for (int k = j + 1; k < n; ++k) {
					double area = area(points, i, j, k);
					if (area > max) {
						max = area;
					}
				}
			}
		}

		return max;
	}

	// triangle
	double area(int[][] points, int i, int j, int k) {
		int[] p1 = points[i];
		int[] p2 = points[j];
		int[] p3 = points[k];

		double area = 0;
		area += area(p1, p2);
		area += area(p2, p3);
		area += area(p3, p1);

		return Math.abs(area);
	}

	// parallelogram
	double area(int[] p1, int[] p2) {
		int w = p2[0] - p1[0];
		double h = (p1[1] + p2[1] + 200) / 2.0;
		return w * h;
	}


	public static void main(String[] args) {
		System.out.println(largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}));
	}
}
