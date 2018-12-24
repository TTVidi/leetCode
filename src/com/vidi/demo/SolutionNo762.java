package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/24 14:59
 * @Descripton :
 * <p>
 * Prime Number of Set Bits in Binary Representation
 * <p>
 * Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set
 * bits in their binary representation.
 * <p>
 * (Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example,
 * 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)
 */
public class SolutionNo762 {
	public int countPrimeSetBits(int L, int R) {
		int result = 0;
		for (int i = L; i <= R; i++) {
			if (isPrime(setBitsNumber(i))) {
				System.out.println(setBitsNumber(i));
				result++;
			}
		}
		return result;
	}

	boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}
		if (number > 2) {
			for (int i = 2; i <= Math.sqrt(number); i++) {
				if (number % i == 0) {
					return false;
				}
			}
			return true;
		}
		return true;
	}

	int setBitsNumber(int number) {
		int count = 0;
		while (number >= 1) {
			if (number % 2 == 1) {
				count++;
			}
			number = number >> 1;
		}
		return count;
	}

	public static void main(String[] args) {
		SolutionNo762 solutionNo762 =new SolutionNo762();
		int i = solutionNo762.countPrimeSetBits(244, 269);
		System.out.println(i);
	}
}
