package vidi.demo.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetCode
 * @description:Happy Number
 * Write an algorithm to determine if a number n is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Return True if n is a happy number, and False if not.
 * <p>
 * Example:
 * @author: Vidi
 * @create: 2020-04-09 19:49
 **/
public class Day2 {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            String s = n + "";
            int count = 0;
            for (char c : s.toCharArray()) {
                count += Math.pow((c - '0'), 2);
            }
            if (count == 1) {
                return true;
            }
            set.add(n);
            n = count;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
