package com.vidi.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author : Vidi
 * @Date : 2019/7/11 9:21
 * @Descripton :
 */
public class SynchronousQueueQuiz {
	public static void main(String[] args) throws Exception {
		BlockingQueue<Integer> queue = new SynchronousQueue<>();
//		queue.offer(1);
		queue.put(1);
		queue.take();
//		System.out.print(queue.offer(1) + " ");
//		System.out.print(queue.offer(2) + " ");
//		System.out.print(queue.offer(3) + " ");
//		System.out.print(queue.take() + " ");
//		System.out.println(queue.size());
		new Thread(() -> queue.offer(1)).start();

		new Thread(() -> {
			try {
				System.out.println(queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

	}
}
