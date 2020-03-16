package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2018/12/13 17:06
 * @Descripton :
 * <p>
 * Fizz Buzz
 * <p>
 * Write a program that outputs the string representation of numbers from 1 to n.
 * <p>
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 */
public class SolutionNo412 {

	public static List<String> fizzBuzz(int n) {
		List<String> results = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				results.add("FizzBuzz");
			} else if (i % 5 == 0) {
				results.add("Buzz");
			} else if (i % 3 == 0) {
				results.add("Fizz");
			} else {
				results.add(i + "");
			}
		}
		return results;
	}

	public static void main(String[] args) {
		List<String> stringList = fizzBuzz(15);
		for (String s : stringList) {
			System.out.print(s + "\t");
		}

	}
}
