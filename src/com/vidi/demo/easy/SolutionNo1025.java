package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/7/17 8:46
 * @Descripton : Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
 * <p>
 * Choosing any x with 0 < x < N and N % x == 0. Replacing the number N on the chalkboard with N - x. Also, if a player
 * cannot make a move, they lose the game.
 * <p>
 * Return True if and only if Alice wins the game, assuming both players play optimally.
 */
public class SolutionNo1025 {
	public boolean divisorGame(int N) {
		return N % 2 == 0;
	}
}
