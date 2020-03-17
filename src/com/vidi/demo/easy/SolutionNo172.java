package vidi.demo.easy;

/**
 * @program: leetCode
 * @description: Factorial Trailing Zeroes  Given an integer n, return the number of trailing zeroes in n!.
 * @author: Vidi
 * @create: 2020-03-16 13:57
 **/
public class SolutionNo172 {
	public int trailingZeroes(int n) {
		int totalZero = 0;
		while (n != 0) {
			totalZero += (n = n / 5);
		}
		return totalZero;
	}

	public static void main(String[] args) {

	}
}
