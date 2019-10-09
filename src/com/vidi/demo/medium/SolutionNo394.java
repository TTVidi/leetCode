package com.vidi.demo.medium;

import java.util.Stack;

/**
 * @Author : Vidi
 * @Date : 2019/10/8 10:01
 * @Descripton : Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 * repeat numbers, k. For example, there won't be input like 3a or 2[4].
 */
public class SolutionNo394 {
	public static String decodeString(String s) {
		Stack<Character> stack = new Stack<>();
		Stack<Character> tempStack = new Stack<>();
		for (char c : s.toCharArray()) {
			stack.push(c);
		}
		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty()) {
			Character pop = stack.pop();
			if (pop == '[') {
				StringBuilder numStr = new StringBuilder();
				while (!stack.isEmpty()&& stack.peek() >= '0' && stack.peek() <= '9') {
					numStr.insert(0, stack.pop() - 48);
				}
				int num = Integer.parseInt(numStr.toString());
				Character pre;
				StringBuilder temp = new StringBuilder();
				while ((pre = tempStack.pop()) != ']' && !tempStack.isEmpty()) {
					temp.append(pre);
				}

				for (int i = 0; i < num; i++) {
					sb.insert(0, temp);
				}

				for (char c : sb.reverse().toString().toCharArray()) {
					tempStack.push(c);
				}
				sb = new StringBuilder();

			} else {
				tempStack.push(pop);
			}

		}
		while (!tempStack.isEmpty()) {
			sb.append(tempStack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(decodeString("100[leetcode]"));
	}
}
