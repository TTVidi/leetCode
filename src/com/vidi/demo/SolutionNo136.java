package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/17 14:25
 * @Descripton :
 * <p>
 * Single Number
 * <p>
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * we use bitwise XOR to solve this problem :
 * <p>
 * first , we have to know the bitwise XOR in java
 * <p>
 * 0 ^ N = N N ^ N = 0 So..... if N is the single number
 * <p>
 * N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
 * <p>
 * = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
 * <p>
 * = 0 ^ 0 ^ ..........^ 0 ^ N
 * <p>
 * = N
 */
public class SolutionNo136 {

	public static int singleNumber(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}


	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
	}
}
