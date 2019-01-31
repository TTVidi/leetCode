package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/31 10:13
 * @Descripton :
 * <p>
 * Merge Two Sorted Lists
 * <p>
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes
 * of the first two lists.
 */
public class SolutionNo21 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 != null && l2 != null) {
			ListNode result = new ListNode(0);
			ListNode current = result;
			while (l1 != null && l2 != null) {
				ListNode next;
				if (l1.val > l2.val) {
					next = new ListNode(l2.val);
					l2 = l2.next;
				} else {
					next = new ListNode(l1.val);
					l1 = l1.next;
				}
				current.next = next;
				current = next;
			}
			if (l1 == null) {
				current.next = l2;
				return result.next;
			}
			current.next = l1;
			return result.next;
		}
		return l1 == null ? l2 : l1;
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

	public static String listNodeToString(ListNode node) {
		if (node == null) {
			return "[]";
		}

		String result = "";
		while (node != null) {
			result += Integer.toString(node.val) + ", ";
			node = node.next;
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static void main(String[] args) {
		ListNode l1 = stringToListNode("[1,2,4,7]");
		ListNode l2 = stringToListNode("[1,3,4,5,6]");
		ListNode ret = new SolutionNo21().mergeTwoLists(l1, l2);
		String out = listNodeToString(ret);
		System.out.print(out);
	}
}
