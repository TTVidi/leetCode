package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/7/23 16:04
 * @Descripton :Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining
 * elements to the right.
 * <p>
 * Note that elements beyond the length of the original array are not written.
 * <p>
 * Do the above modifications to the input array in place, do not return anything from your function.
 */
public class SolutionNo1089 {
	public void duplicateZeros(int[] arr) {
		int[] temp = new int[arr.length];
		int i = 0, j = 0;
		while (i < arr.length && j < arr.length) {
			temp[j++] = arr[i];
			if (arr[i++] == 0 && j < arr.length) {
				temp[j++] = 0;
			}
		}
		for (int u = 0; u < arr.length; u++) {
			arr[u] = temp[u];
		}
	}

	public static void main(String[] args) {
		new SolutionNo1089().duplicateZeros(new int[]{1,2,3});
	}

}
