package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/9 10:02
 * @Descripton :
 * <p>
 * Delete Node in a Linked List
 * <p>
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p>
 * Given linked list -- head = [4,5,1,9], which looks like following:
 */
public class SolutionNo237 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
