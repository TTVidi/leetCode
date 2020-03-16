package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/12/25 15:41
 * @Descripton :Given head which is a reference node to a singly-linked list. The value of each node in the linked list
 * is either 0 or 1. The linked list holds the binary representation of a number.
 * <p>
 * Return the decimal value of the number in the linked list.
 */
public class SolutionNo1290 {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}


	public int getDecimalValue(ListNode head) {
		int sum = 0;
		while (head != null) {
			sum <<= 1;
			sum += head.val;
			head = head.next;
		}
		return sum;
	}


	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static ListNode stringToListNode(String input) {
		// Generate array from the input
		int[] nodeValues = stringToIntegerArray(input);

		// Now convert that list into linked list
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for (int item : nodeValues) {
			ptr.next = new ListNode(item);
			ptr = ptr.next;
		}
		return dummyRoot.next;
	}

	public static void main(String[] args) {
		ListNode head = stringToListNode("[1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]");

		int ret = new SolutionNo1290().getDecimalValue(head);

		String out = String.valueOf(ret);

		System.out.print(out);
	}
}
