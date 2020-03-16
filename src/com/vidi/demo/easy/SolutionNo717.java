package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/15 15:57
 * @Descripton :
 * <p>
 * 1-bit and 2-bit Characters
 * <p>
 * We have two special characters. The first character can be represented by one bit 0. The second character can be
 * represented by two bits (10 or 11).
 * <p>
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not.
 * The given string will always end with a zero.
 */
public class SolutionNo717 {
	public static boolean isOneBitCharacter(int[] bits) {
		return bits.length >= 2 ? testOneBit(bits, 0) : bits[0] == 0;
	}

	public static boolean isOneBitCharacter2(int[] bits) {
		int count = 0;
		for (int i = bits.length - 2; i >= 0 && bits[i] == 1; i--) {
			if (bits[i] == 1) {
				count++;
			}
		}
		return count % 2 == 0;
	}

	public static boolean testOneBit(int[] bits, int index) {
		return index < bits.length - 2 ? testOneBit(bits, index + bits[index] + 1) : bits[index] == 0;
	}

	public static void main(String[] args) {
		System.out.println(isOneBitCharacter2(new int[]{1, 0, 1, 0}));
	}
}
