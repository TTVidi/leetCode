package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/7/16 14:23
 * @Descripton : There is a table World
 * <p>
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * <p>
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that
 * don't appear in arr2 should be placed at the end of arr1 in ascending order.
 */
public class SolutionNo1122 {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] temp = new int[1001];
		int[] result = new int[arr1.length];
		int j = 0;
		for (int i : arr1) {
			temp[i]++;
		}
		for (int i : arr2) {
			if (temp[i] > 0) {
				while ((temp[i]--) != 0) {
					result[j++] = i;
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] > 0) {
				while ((temp[i]--) != 0) {
					result[j++] = i;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		for (int i : new SolutionNo1122().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})) {
			System.out.print(i + "\t");
		}
	}
}
