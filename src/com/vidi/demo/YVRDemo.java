package com.vidi.demo;

import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author : Vidi
 * @Date : 2019/6/10 10:02
 * @Descripton :
 */
public class YVRDemo {
	public static void main(String[] args) throws ParseException {
		int[] in = new int[]{4595, 96759, 150000, 130000, 130000, 140000, 120000, 90000, 130000, 100000, 90000, 150000, 100000
				, 100000, 80000, 150000, 200000, 90000, 100000, 90000, 120000, 80000, 100000, 100000, 100000, 110000, 100000,
				120000, 100000, 100000, 80000, 100000};
		int[] out = new int[]{101354, 83516, 83416, 104507, 83852, 112121, 83054, 118398, 89327, 80238, 95966, 82131
				, 106253, 83355, 106299, 82379, 84432, 105487, 84383, 107889, 82981, 104344, 82465, 83916
				, 109161, 87027, 112133, 82646, 103249, 83993, 84916
		};
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(in[0]);
		if (in.length >= out.length) {
			int save = queue.poll();
			for (int i = 1; i < in.length; i++) {
				System.out.println("------------------");
				if (save >= out[i - 1]) {
					queue.add(in[i]);
					System.out.println(out[i - 1]);
					save -= out[i - 1];
				} else {
					queue.add(in[i]);
					if (save > 0) {
						System.out.println(save);
					}
					Integer poll = queue.poll();
					System.out.println(out[i - 1] - save);
					save = poll - (out[i - 1] - save);
				}
			}
		} else {
		}
	}
}
