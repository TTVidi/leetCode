package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/26 14:11
 * @Descripton :
 * <p>
 * Nim Game
 * <p>
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you
 * take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first
 * turn to remove the stones.
 * <p>
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can
 * win the game given the number of stones in the heap.
 */
public class SolutionNo292 {
	public boolean canWinNim(int n) {
		return n % 4 != 0;
	}
}
