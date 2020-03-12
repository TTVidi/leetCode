package vidi.demo.medium;

/**
 * @program: leetCode
 * @description: Minimum Size Subarray Sum
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * @author: Vidi
 * @create: 2020-03-12 09:45
 **/
public class SolutionNo209 {
	public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
		int left, right = 1;
		int sum = nums[0];
		int min = 0;
		if (sum >= s) {
			return 1;
		}
		for (left = 0; left < nums.length; left++) {
			for (; right < nums.length && sum < s; ++right) {
				sum += nums[right];
			}
			if (sum >= s) {
				sum -= nums[left];
				if (min == 0) {
					min = right - left;
				} else {
					min = Math.min((right - left), min);
				}
			} else {
				break;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		SolutionNo209 s = new SolutionNo209();
		System.out.println(s.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
	}
}
