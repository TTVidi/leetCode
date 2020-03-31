package vidi.demo.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetCode
 * @description: How Many Numbers Are Smaller Than the Current Number
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * <p>
 * Return the answer in an array.
 * @author: Vidi
 * @create: 2020-03-31 11:25
 **/
public class SolutionNo1365 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[] sortArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            sortArray[i] = num;
        }
        Arrays.sort(sortArray);
        Map<Integer, Integer> countMap = new HashMap<>(map.size());
        int count = nums.length;
        for (int i = sortArray.length - 1; i >= 0; ) {
            Integer integer = map.get(sortArray[i]);
            count -= integer;
            countMap.put(sortArray[i], count);
            i -= integer;
        }

        for (int i = 0; i < nums.length; i++) {
            sortArray[i] = countMap.get(nums[i]);
        }
        return sortArray;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 2, 2, 3};
        smallerNumbersThanCurrent(nums);
    }
}
