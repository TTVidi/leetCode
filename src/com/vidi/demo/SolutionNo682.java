package com.vidi.demo;

import java.util.Stack;

/**
 * @Author : Vidi
 * @Date : 2018/12/6 10:41
 * @Descripton :
 * <p>
 * Baseball Game
 * <p>
 * You're now a baseball game point recorder.
 * <p>
 * Given a list of strings, each string can be one of the 4 following types:
 * <p>
 * Integer (one round's score): Directly represents the number of points you get in this round. "+" (one round's score):
 * Represents that the points you get in this round are the sum of the last two valid round's points. "D" (one round's
 * score): Represents that the points you get in this round are the doubled data of the last valid round's points. "C"
 * (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should
 * be removed. Each round's operation is permanent and could have an impact on the round before and the round after.
 * <p>
 * You need to return the sum of the points you could get in all the rounds.
 */
public class SolutionNo682 {
	public static int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		Integer score;
		for (String op : ops) {
			switch (op) {
				case "+":
					Integer last = stack.pop();
					Integer lastBefore = stack.pop();
					score = last + lastBefore;
					stack.push(lastBefore);
					stack.push(last);
					stack.push(score);
					sum += score;
					break;
				case "D":
					Integer peek = stack.peek();
					score = peek * 2;
					stack.push(score);
					sum += score;
					break;
				case "C":
					Integer pop = stack.pop();
					sum -= pop;
					break;
				default:
					score = Integer.parseInt(op);
					stack.push(score);
					sum += score;
					break;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(calPoints(new String[]{"5","2","C","D","+"}));
	}
}
