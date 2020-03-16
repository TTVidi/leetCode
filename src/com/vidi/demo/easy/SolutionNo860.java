package com.vidi.demo;

import java.beans.beancontext.BeanContext;
import java.util.HashMap;

/**
 * @Author : Vidi
 * @Date : 2019/1/9 16:56
 * @Descripton :
 * <p>
 * Lemonade Change
 * <p>
 * At a lemonade stand, each lemonade costs $5.
 * <p>
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 * <p>
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct
 * change to each customer, so that the net transaction is that the customer pays $5.
 * <p>
 * Note that you don't have any change in hand at first.
 * <p>
 * Return true if and only if you can provide every customer with correct change.
 */
public class SolutionNo860 {
	public static boolean lemonadeChange(int[] bills) {
		int five = 0, ten = 0;
		if (bills[0] == 5) {
			five++;
			for (int i = 1; i < bills.length; i++) {
				if (bills[i] == 5) {
					five++;
				} else if (bills[i] == 10) {
					ten++;
					if (five > 0) {
						five--;
					} else {
						return false;
					}
				} else {
					if (ten > 0 && five > 0) {
						ten--;
						five--;
					} else if (five > 2) {
						five -= 3;
					} else {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	public static boolean lemonadeChange2(int[] bills) {
		int five = 0, ten = 0;
		for (int i : bills) {
			if (i == 5) {
				five++;
			} else if (i == 10) {
				five--;
				ten++;
			} else if (ten > 0) {
				ten--;
				five--;
			} else {
				five -= 3;
			}
			if (five < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(lemonadeChange(new int[]{5, 5, 10, 10, 20}));
	}
}
