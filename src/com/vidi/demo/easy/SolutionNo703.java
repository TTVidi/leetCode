package com.vidi.demo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author : Vidi
 * @Date : 2019/8/6 16:52
 * @Descripton :Design a class to find the kth largest element in a stream. Note that it is the kth largest element in
 * the sorted order, not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains
 * initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth
 * largest element in the stream.
 */
public class SolutionNo703 {
	PriorityQueue<Integer> queue = new PriorityQueue<>();
	int kth = 0;
	int k;

	public SolutionNo703(int k, int[] nums) {
		this.k = k;
		if (nums != null && nums.length > 0) {
			for (int num : nums) {
				queue.add(num);
			}
			if (k < nums.length) {
				k = nums.length - k;
				while (k > 0) {
					queue.poll();
					k--;
				}
			}
			kth = queue.peek();
		}
	}

	public int add(int val) {
		if (queue.size() == 0) {
			queue.add(val);
			kth = val;
			return val;
		}
		if (queue.size() < k) {
			queue.add(val);
			kth = queue.peek();
			return kth;
		}
		if (val > kth) {
			queue.add(val);
			queue.poll();
			kth = queue.peek();
			return kth;
		}
		return kth;
	}

	public static void main(String[] args) {
		SolutionNo703 ss = new SolutionNo703(2, new int[]{0});
		System.out.println(ss.add(-1));
		System.out.println(ss.add(1));
		System.out.println(ss.add(-2));
		System.out.println(ss.add(-4));
		System.out.println(ss.add(3));
	}
}
