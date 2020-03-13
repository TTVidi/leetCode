package vidi.demo.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetCode
 * @description:Longest Word in Dictionary through Deleting
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 * @author: Vidi
 * @create: 2020-03-13 16:13
 **/
public class SolutionNo524 {
	public String findLongestWord(String s, List<String> d) {
		String result = null;
		for (String str : d) {
			if (result != null) {
				if (str.length() >= result.length() && allContains(s, str)) {
					if (str.length() == result.length()) {
						result = result.compareTo(str) > 0 ? result : str;
					} else {
						result = str;
					}
				}
			} else if (allContains(s, str)) {
				result = str;
			}

		}
		return result;
	}

	private boolean allContains(String s, String word) {
		int currentIndex = 0;
		char[] chars = word.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char ch = chars[i];
			int index = s.indexOf(ch, currentIndex);
			if (index == -1) {
				return false;
			}
			currentIndex = index + 1;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "abxcplea";
		List<String> list = new ArrayList<>();
		list.add("ale");
		list.add("apple");
		list.add("monkey");
		list.add("plea");
		SolutionNo524 solutionNo524 = new SolutionNo524();
		System.out.println(solutionNo524.findLongestWord(s, list));
	}
}
