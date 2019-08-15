package com.vidi.demo;

import java.util.HashMap;

/**
 * @Author : Vidi
 * @Date : 2019/1/9 10:09
 * @Descripton :
 * <p>
 * Roman to Integer
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value I             1 V             5 X             10 L             50 C             100 D 500 M 1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which
 * is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same
 * principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900. Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class SolutionNo13 {
	public int romanToInt(String s) {
		char[] chars = s.toCharArray();
		int result = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		for (int i = 0; i < chars.length - 1; i++) {
			switch (chars[i]) {
				case 'I':
					if (chars[i + 1] == 'V' || chars[i + 1] == 'X') {
						result += -1;
					} else {
						result += 1;
					}
					break;
				case 'V':
					result += 5;
					break;
				case 'X':
					if (chars[i + 1] == 'L' || chars[i + 1] == 'C') {
						result -= 10;
					} else {
						result += 10;
					}
					break;
				case 'L':
					result += 50;
					break;
				case 'C':
					if (chars[i + 1] == 'D' || chars[i + 1] == 'M') {
						result -= 100;
					} else {
						result += 100;
					}
					break;
				case 'D':
					result += 500;
					break;
				default:
					result += 1000;
					break;
			}
		}
		result += map.get(chars[chars.length - 1]);
		return result;
	}
}
