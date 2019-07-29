package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/7/22 11:36
 * @Descripton : We distribute some number of candies, to a row of n = num_people people in the following way:
 * <p>
 * We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the
 * last person.
 * <p>
 * Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second
 * person, and so on until we give 2 * n candies to the last person.
 * <p>
 * This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the
 * end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one
 * more than the previous gift).
 * <p>
 * Return an array (of length num_people and sum candies) that represents the final distribution of candies.
 */
public class SolutionNo1103 {
	public int[] distributeCandies(int candies, int num_people) {
		int i = 0;
		int current;
		int next;
		for (; ; i++) {
			current = (i * num_people + i * i * num_people * num_people) >> 1;
			next = ((i + 1) * num_people + (i + 1) * (i + 1) * num_people * num_people) >> 1;
			if (candies >= current && candies < next) {
				break;
			}
		}
		int base = i * num_people;
		int rest = candies - current;
		int[] result = new int[num_people];
		for (int j = 1; j <= num_people; j++) {
			int total = (num_people * i * (i - 1) >> 1) + i * j;
			int should = base + j;
			if (should <= rest) {
				rest -= should;
				total += should;
			} else {
				total += rest;
				rest = 0;
			}
			result[j - 1] = total;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] ints = new SolutionNo1103().distributeCandies(10, 3);
		for (int anInt : ints) {
			System.out.println(anInt);
		}
	}
}
