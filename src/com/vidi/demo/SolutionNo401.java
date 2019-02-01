package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2019/1/31 15:43
 * @Descripton :
 * <p>
 * Binary Watch
 * <p>
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the
 * minutes (0-59).
 * <p>
 * Each LED represents a zero or one, with the least significant bit on the right.
 * <p>
 * <p>
 * For example, the above binary watch reads "3:25".
 * <p>
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times
 * the watch could represent.
 */
public class SolutionNo401 {
	public List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<>();
		backtracking(res, new int[10], num, 0);
		return res;
	}

	void backtracking(List<String> res, int[] digits, int remain, int current) {
		if (remain == 0) { // complete permutation
			int hour = 0;
			for (int i = 0; i <= 3; i ++) {
				hour += digits[i] * (int)Math.pow(2, 3 - i);
			}
			int min = 0;
			for (int i = 4; i <= 9; i ++) {
				min += digits[i] * (int)Math.pow(2, 9 - i);
			}
			if (hour <= 11 && min <= 59)
				res.add((new StringBuilder(4))
						.append(hour)
						.append(":")
						.append(min / 10)
						.append(min % 10)
						.toString());
		} else {
			for (int i = current; i < digits.length; i ++) { // loop from current digit to the end
				digits[i] = 1; // set current digit to 1
				backtracking(res, digits, remain - 1, i + 1); // get permutation for digits on the right
				digits[i] = 0; // reset current digit to 0
			}
		}
	}
}
