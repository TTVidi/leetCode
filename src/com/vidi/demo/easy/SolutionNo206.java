package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2019/1/8 17:03
 * @Descripton :
 * <p>
 * Reverse Linked List
 * <p>
 * Reverse a singly linked list.
 */
public class SolutionNo206 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode reverseList(ListNode head) {
		List<ListNode> temp = new ArrayList<>();
		if (head == null) {
			return null;
		}
		while (head.next != null) {
			temp.add(head);
			head = head.next;
		}
		temp.add(head);

		temp.get(0).next = null;
		for (int i = temp.size() - 1; i >= 1; i--) {
			temp.get(i).next = temp.get(i - 1);
		}

		return temp.get(temp.size() - 1);
	}

	public static void main(String[] args) {

	}
}
