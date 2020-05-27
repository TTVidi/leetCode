package vidi.demo.daily;

/**
 * @program: leetCode
 * @description: Maximum Subarray
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * @author: Vidi
 * @create: 2020-04-09 20:09
 **/
public class Day3 {
    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum > result) {
                result = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
