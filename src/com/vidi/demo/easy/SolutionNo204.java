package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/12/24 16:21
 * @Descripton :Count the number of prime numbers less than a non-negative number, n.
 */
public class SolutionNo204 {
	public static int countPrimes(int n) {
		if (n <= 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else {
			int count = 1;
			for (int i = 3; i < n; i++) {
				if (isPrime(i)) {
					count++;
				}
			}
			return count;
		}
	}

	static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(10));
	}
}
