package vidi.demo.daily;

/**
 * @program: leetCode
 * @description: Single Number
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * @author: Vidi
 * @create: 2020-04-01 17:09
 **/
public class Day1 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
