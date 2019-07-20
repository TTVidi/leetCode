package com.vidi.demo;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2019/7/16 10:48
 * @Descripton : A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid
 * parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all
 * valid parentheses strings.
 * <p>
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B,
 * with A and B nonempty valid parentheses strings.
 * <p>
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are
 * primitive valid parentheses strings.
 * <p>
 * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 */
public class SolutionNo1021 {


	public String removeOuterParentheses(String S) {
		Queue<String> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		StringBuilder sbTemp = new StringBuilder();
		for (int i = 0; i < S.toCharArray().length; i++) {
			if (S.charAt(i) == '(') {
				queue.add("(");
				sbTemp.append("(");
			} else {
				queue.poll();
				sbTemp.append(")");
				if (queue.isEmpty()) {
					sb.append(sbTemp.substring(1, sbTemp.length() - 1));
					sbTemp = new StringBuilder();
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new SolutionNo1021().removeOuterParentheses("()()"));
	}
}
