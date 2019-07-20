package com.vidi.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2019/7/16 15:21
 * @Descripton :Given words first and second, consider occurrences in some text of the form "first second third", where
 * second comes immediately after first, and third comes immediately after second.
 * <p>
 * For each such occurrence, add "third" to the answer, and return the answer.
 */
public class SolutionNo1078 {
	public String[] findOcurrences(String text, String first, String second) {
		String[] split = text.split(" ");
		List<String> list = new ArrayList<>();
		for (int i = 0; i < split.length - 2; i++) {
			if (split[i].equals(first) && split[i + 1].equals(second)) {
				list.add(split[i + 2]);
			}
		}
		String[] result = new String[list.size()];
		list.toArray(result);
		return result;
	}

	public static void main(String[] args) {
		for (String s : new SolutionNo1078().findOcurrences("alice is a good girl she is a good student", "a", "good")) {
			System.out.println(s);
		}
	}
}
