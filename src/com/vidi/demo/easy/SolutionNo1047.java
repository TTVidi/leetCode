package com.vidi.demo;

import java.util.Stack;

/**
 * @Author : Vidi
 * @Date : 2019/7/16 18:51
 * @Descripton : Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal
 * letters, and removing them.
 * <p>
 * We repeatedly make duplicate removals on S until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 */
public class SolutionNo1047 {
	public String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<>();
		for (char c : S.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(c);
			} else {
				Character peek = stack.peek();
				if (peek == c) {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		while (!stack.isEmpty()) {
			stringBuilder.append(stack.pop());
		}
		stringBuilder = stringBuilder.reverse();
		return stringBuilder.toString();
	}
}
