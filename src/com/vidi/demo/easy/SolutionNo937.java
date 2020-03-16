package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2018/12/24 8:24
 * @Descripton :
 * <p>
 * Reorder Log Files
 * <p>
 * You have an array of logs.  Each log is a space delimited string of words.
 * <p>
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * <p>
 * Each word after the identifier will consist only of lowercase letters, or; Each word after the identifier will
 * consist only of digits. We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that
 * each log has at least one word after its identifier.
 * <p>
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered
 * lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in
 * their original order.
 * <p>
 * Return the final order of the logs.
 */
public class SolutionNo937 {
	public static String[] reorderLogFiles(String[] logs) {
		List<String> digits = new ArrayList<>(logs.length);
		List<String> letters = new ArrayList<>(logs.length);
		for (String log : logs) {
			String[] split = log.split(" ");
			if (split[1].charAt(0) >= '0' && split[1].charAt(0) <= '9') {
				digits.add(log);
			} else {
				letters.add(log);
			}
		}
		for (int i = 0; i < letters.size() - 1; i++) {
			for (int j = 0; j < letters.size() - i - 1; j++) {
				if (letters.get(j).substring(letters.get(j).indexOf(" ")).compareTo(letters.get(j + 1).substring(letters.get(j + 1).indexOf(" "))) > 0) {
					String temp = letters.get(j);
					letters.set(j, letters.get(j + 1));
					letters.set(j + 1, temp);
				}
			}
		}
		letters.addAll(digits);
		String[] result = new String[letters.size()];
		letters.toArray(result);
		return result;
	}

	public static void main(String[] args) {
		String[] strings = reorderLogFiles(new String[]{"d 02", "2 5 3", "k r y", "6 srs", "x fp"});
		for (String string : strings) {
			System.out.println(string);
		}

	}
}
