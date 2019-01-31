package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/30 9:13
 * @Descripton :
 * <p>
 * Rectangle Overlap
 * <p>
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner,
 * and (x2, y2) are the coordinates of its top-right corner.
 * <p>
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at
 * the corner or edges do not overlap.
 * <p>
 * Given two (axis-aligned) rectangles, return whether they overlap.
 */
public class SolutionNo836 {
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		// both x axis and y axis need to be overlap
		return (isOverlap(rec1[0], rec1[2], rec2[0], rec2[2]) && isOverlap(rec1[1], rec1[3], rec2[1], rec2[3]));
	}

	/**
	 * checking if an axis is overlap
	 */
	private boolean isOverlap(int p1x1, int p1x2, int p2x1, int p2x2 ){
		if((p2x1>=p1x1 && p2x1<p1x2) ||
				(p2x2<=p1x2 && p2x2 > p1x1) ||
				(p2x1<=p1x1 && p2x2>=p1x2)){
			return true;
		}else{
			return false;
		}

	}

	public static void main(String[] args) {
		System.out.println(new SolutionNo836().isRectangleOverlap(new int[]{10, 8, 12, 20}, new int[]{7, 8, 13, 15}));
	}
}
