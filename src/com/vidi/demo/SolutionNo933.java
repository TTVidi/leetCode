package com.vidi.demo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author : Vidi
 * @Date : 2018/11/27 11:04
 * @Descripton :
 * <p>
 * Number of Recent Calls
 * <p>
 * Write a class RecentCounter to count recent requests.
 * <p>
 * It has only one method: ping(int t), where t represents some time in milliseconds.
 * <p>
 * Return the number of pings that have been made from 3000 milliseconds ago until now.
 * <p>
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 * <p>
 * It is guaranteed that every call to ping uses a strictly larger value of t than before.
 */
public class SolutionNo933 {

	class RecentCounter {
		private Deque<Integer> deque;
		public RecentCounter() {
			deque = new ArrayDeque<>();
		}

		public int ping(int t) {
			while (!deque.isEmpty() && t - deque.getFirst() > 3000) {
				deque.removeFirst();
			}
			deque.add(t);
			return deque.size();
		}
	}
}
