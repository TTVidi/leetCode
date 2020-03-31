package vidi.demo.easy;

/**
 * @program: leetCode
 * @description: Number of Steps to Reduce a Number to Zero
 * Given a non-negative integer num, return the number of steps to reduce it to zero. If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 * @author: Vidi
 * @create: 2020-03-31 10:28
 **/
public class SolutionNo1342 {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            }else {
                num--;
            }
            count++;
        }
        return ++count;
    }

}
