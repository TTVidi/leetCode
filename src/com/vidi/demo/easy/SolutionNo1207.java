package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/12/26 15:27
 * @Descripton :Given an array of integers arr, write a function that returns true if and only if the number of
 * occurrences of each value in the array is unique.
 */
public class SolutionNo1207 {
	public static boolean uniqueOccurrences(int[] arr) {
		int[] temp1 = new int[2001];
		for (int i : arr) {
			temp1[i + 1000]++;
		}
		int[] temp = new int[1001];
		for (int i = 0; i < temp1.length; i++) {
			if (temp1[i] > 0) {
				temp[temp1[i]]++;
			}
		}
		for (int i : temp) {
			if (i > 1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));
	}
}
