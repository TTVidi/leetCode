package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/10 15:20
 * @Descripton :
 * <p>
 * Fibonacci Number
 * <p>
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is
 * the sum of the two preceding ones, starting from 0 and 1. That is,
 * <p>
 * F(0) = 0,   F(1) = 1 F(N) = F(N - 1) + F(N - 2), for N > 1. Given N, calculate F(N).
 */
public class SolutionNo509 {
	public int fib(int N) {
		if (N == 0 || N == 1) {
			return 1;
		}
		return fib(N - 1) + fib(N - 2);
	}

	public int fib2(int N) {
		if (N == 0 || N == 1) {
			return N;
		}
		int[] array = new int[N + 1];
		array[0] = 0;
		array[1] = 1;
		for (int i = 2; i <= N; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		return array[N];
	}
}
