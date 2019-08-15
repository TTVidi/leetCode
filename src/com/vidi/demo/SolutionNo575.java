package com.vidi.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : Vidi
 * @Date : 2018/12/13 14:06
 * @Descripton :
 * <p>
 * Distribute Candies
 * <p>
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies.
 * Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to
 * brother and sister. Return the maximum number of kinds of candies the sister could gain.
 */
public class SolutionNo575 {
	public static int distributeCandies(int[] candies) {
		int length = candies.length;
		Set<Integer> set = new HashSet<>();
		for (int candy : candies) {
			set.add(candy);
			if (set.size() >= length / 2) {
				return length / 2;
			}
		}
		return set.size();
	}

	public static void main(String[] args) {
		System.out.println(distributeCandies(new int[]{1, 1, 2, 3}));
	}
}
