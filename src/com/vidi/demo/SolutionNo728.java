package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2018/11/26 17:21
 * @Descripton :
 * <p>
 * Self Dividing Numbers
 * <p>
 * A self-dividing number is a number that is divisible by every digit it contains.
 * <p>
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * <p>
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * <p>
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if
 * possible.
 */
public class SolutionNo728 {
	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> results = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			if (isSelfDividingNumber(i)) {
				results.add(i);
			}
		}
		return results;
	}

	public static boolean isSelfDividingNumber(int number) {
		String numberStr = String.valueOf(number);
		for (int i = 0; i < numberStr.length(); i++) {
			int current = numberStr.charAt(i) - 48;
			if (current == 0 || number % current != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		List<Integer> integers = selfDividingNumbers(1, 22);
		for (Integer integer : integers) {
			System.out.println(integer);
		}
	}
}
