package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/31 15:31
 * @Descripton :
 * <p>
 * Student Attendance Record I
 * <p>
 * You are given a string representing an attendance record for a student. The record only contains the following three
 * characters: 'A' : Absent. 'L' : Late. 'P' : Present. A student could be rewarded if his attendance record doesn't
 * contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * <p>
 * You need to return whether the student could be rewarded according to his attendance record.
 */
public class SolutionNo551 {
	public static boolean checkRecord(String s) {
		int aIndex = 1;
		int lIndex = 2;
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			if (aChar == 'L') {
				lIndex--;
				if (lIndex < 0) {
					return false;
				}
			} else if (aChar == 'A') {
				lIndex = 2;
				aIndex--;
				if (aIndex < 0) {
					return false;
				}
			} else {
				lIndex = 2;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkRecord("PPALLL"));
	}
}
