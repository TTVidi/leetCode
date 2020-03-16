package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/10 15:33
 * @Descripton :
 * <p>
 * Flood Fill
 * <p>
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to
 * 65535).
 * <p>
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value
 * newColor, "flood fill" the image.
 * <p>
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting
 * pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with
 * the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the
 * newColor.
 * <p>
 * At the end, return the modified image.
 */
public class SolutionNo733 {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image != null) {
			if (newColor == image[sr][sc]) {
				return image;
			}
			paint(image, sr, sc, newColor, image[sr][sc]);
			return image;
		}
		return null;
	}

	public void paint(int[][] image, int sr, int sc, int color, int oldColor) {
		if (image[sr][sc] != oldColor) {
			return;
		}
		image[sr][sc] = color;

		if (sr + 1 < image.length) {
			paint(image, sr + 1, sc, color, oldColor);
		}
		if (sr - 1 >= 0) {
			paint(image, sr - 1, sc, color, oldColor);
		}

		if (sc + 1 < image[0].length) {
			paint(image, sr, sc + 1, color, oldColor);
		}
		if (sc - 1 >= 0) {
			paint(image, sr, sc - 1, color, oldColor);
		}
	}

	public static void main(String[] args) {
		SolutionNo733 solution = new SolutionNo733();
		int[][] ints = solution.floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 1);
		for (int[] anInt : ints) {
			for (int i : anInt) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}
}
