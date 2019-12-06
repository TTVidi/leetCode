package com.vidi.demo.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2019/11/19 10:44
 * @Descripton : Given an integer n, return 1 - n in lexicographical order.
 * <p>
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * <p>
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 * <p>
 */
public class SolutionNo386 {
	public static List<Integer> lexicalOrder(int n) {
		List<String> s = new ArrayList<>(n);
		for (int i = 1; i <= n; i++) {
			s.add(i + "");
		}
		s.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		List<Integer> i = new ArrayList<>(n);
		for (String s1 : s) {
			i.add(Integer.parseInt(s1));
		}
		return i;
	}

	static List<Integer> result = new ArrayList<>();

	public static List<Integer> lexicalOrder2(int n) {
		for (int i = 1; i <= 9; i++) {
			addList(i, i, 0, n);
		}
		return result;
	}

	private static void addList(int begin, int end, int count, int n) {
		if (end > n) {
			end = n;
		}
		count++;
		for (int j = begin; j <= end; j++) {
			int plus = 1;
			for (int i = 0; i < count; i++) {
				plus *= 10;
			}
			if (j * 10 <= n) {
				addList(j * 10, j * 10 + plus-1, count, n);
			}
			result.add(j);
		}
	}

	public static void main(String[] args) {
		for (Integer integer : lexicalOrder2(1002)) {
			System.out.println(integer);
		}
	}
}
