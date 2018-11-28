package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/11/28 22:25
 * @Descripton :
 * <p>
 * Middle of the Linked List
 * <p>
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 */
public class SolutionNo876 {
	/**
	 * Definition for singly-linked list.
	 */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode middleNode(ListNode head) {
		int count = 0;
		ListNode node = head;
		if (node.next == null) {
			return node;
		}
		while ((node = node.next) != null) {
			count++;
		}
		int index = 1;
		node = head;
		while (((node = node.next) != null) && (++index <= (count + 1) / 2)) {

		}
		return node;
	}

	public static ListNode middleNode2(ListNode head) {
		ListNode temp1 = head;
		ListNode temp2 = head;
		int index = -1;
		while (temp1 != null) {
			temp1 = temp1.next;
			if (index % 2 == 0) {
				temp2 = temp2.next;
			}
			index++;
		}
		return temp2;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = null;
		middleNode2(head);
	}
}
