package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/11/26 11:27
 * @Descripton :
 * <p>
 * Jewels and Stones
 * <p>
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have. Each
 * character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so
 * "a" is considered a different type of stone from "A".
 */
public class SolutionNo771 {

	public int numJewelsInStones(String J, String S) {
		int count = 0;
		for (int i = 0; i < S.length(); i++) {
			for (int j = 0; j < J.length(); j++) {
				if (S.charAt(i) == J.charAt(j)) {
					count++;
					break;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		SolutionNo771 solution = new SolutionNo771();
		System.out.println(solution.numJewelsInStones("aA", "aAAbbbb"));
	}
}
