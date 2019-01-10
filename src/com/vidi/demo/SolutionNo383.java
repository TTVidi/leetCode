package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/10 16:41
 * @Descripton :
 * <p>
 * Ransom Note
 * <p>
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function
 * that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 */
public class SolutionNo383 {
	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] array = new int[26];
		char[] chars = ransomNote.toCharArray();
		for (char aChar : chars) {
			array[aChar - 'a']++;
		}
		char[] charArray = magazine.toCharArray();
		for (char c : charArray) {
			if (array[c - 'a'] > 0) {
				array[c - 'a']--;
			}
		}

		for (int i : array) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(canConstruct("aa","aab"));
	}
}
