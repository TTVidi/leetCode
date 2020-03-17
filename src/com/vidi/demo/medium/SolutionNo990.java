package vidi.demo.medium;

import java.util.*;

/**
 * @program: leetCode
 * @description: Satisfiability of Equality Equations
 * Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.
 * <p>
 * Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.
 * @author: Vidi
 * @create: 2020-03-17 10:01
 **/
public class SolutionNo990 {
	public boolean equationsPossible(String[] equations) {
		Map<Character, Set<Character>> map = new HashMap<>();
		List<Character> notEquals = new ArrayList<>();
		for (String equation : equations) {
			char left = equation.charAt(0);
			char right = equation.charAt(3);
			if (equation.contains("==")) {
				Set<Character> leftSet = map.getOrDefault(left, new HashSet<>());
				Set<Character> rightSet = map.getOrDefault(right, new HashSet<>());
				leftSet.add(left);
				leftSet.add(right);
				leftSet.addAll(rightSet);
				for (Character character : leftSet) {
					Set<Character> characterSet = map.getOrDefault(character, new HashSet<>());
					characterSet.addAll(leftSet);
					map.put(character, characterSet);
				}
			} else {
				if (left == right) {
					return false;
				}
				notEquals.add(left);
				notEquals.add(right);
			}
		}

		if (!notEquals.isEmpty()) {
			for (int i = 0; i < notEquals.size(); i++) {
				if (i % 2 == 0) {
					Character left = notEquals.get(i);
					Character right = notEquals.get(i + 1);
					Set<Character> leftSet = map.getOrDefault(left, new HashSet<>());
					Set<Character> rightSet = map.getOrDefault(right, new HashSet<>());
					if (leftSet.contains(right) || rightSet.contains(left)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SolutionNo990 s = new SolutionNo990();
		System.out.println(s.equationsPossible(new String[]{"a==b", "e==c", "b==c", "a!=e"}));
	}
}
