package vidi.demo.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetCode
 * @description: Combination Sum III Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * @author: Vidi
 * @create: 2020-03-11 09:40
 **/
public class SolutionNo216 {

    List<List<Integer>> result = new ArrayList<>();

    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> temp = new ArrayList<>(list);
        for (int i = 1; i < 10; i++) {
            int tracing = backTracing(k - 1, i, n - i);
            if (tracing == 0 || tracing == -1) {
                list = new ArrayList<>(temp);
            }
        }
        return result;
    }

    private int backTracing(int k, int number, int rest) {
        list.add(number);
        if (k == 1) {
            //符合条件，返回正确代码
            if (rest > number && rest < 10) {
                list.add(rest);
                result.add(list);
                return 0;
            } else {
                return -1;
            }
        }

        if (number == 9 || rest <= 0) {
            return -1;
        }

        List<Integer> temp = new ArrayList<>(list);
        for (int i = number + 1; i < 10; i++) {
            int tracing = backTracing(k - 1, i, rest - i);
            if (tracing == 0 || tracing == -1) {
                list = new ArrayList<>(temp);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        SolutionNo216 s = new SolutionNo216();
        List<List<Integer>> lists = s.combinationSum3(2, 6);
        System.out.println(lists.size());
    }
}
