package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2019/7/19 15:50
 * @Descripton : There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is
 * costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 * <p>
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 */
public class SolutionNo1029 {
    public int twoCitySchedCost(int[][] costs) {
        List<List<int[]>> temp = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            temp.add(null);
        }
        int diff = 0;
        for (int[] cost : costs) {
            if (cost[1] >= cost[0]) {
                diff = cost[1] - cost[0];
            } else {
                diff = cost[0] - cost[1];
            }
            List<int[]> ints = temp.get(diff);
            if (ints == null) {
                ints = new ArrayList<>();
            }
            ints.add(cost);
            temp.set(diff, ints);
        }

        int aCount = costs.length / 2;
        int bCount = aCount;
        int total = 0;
        for (int i = temp.size() - 1; i >= 0; i--) {
            List<int[]> ints = temp.get(i);
            if (ints != null) {
                for (int[] anInt : ints) {
                    int a = anInt[0];
                    int b = anInt[1];
                    if (aCount == 0) {
                        total += b;
                    } else if (bCount == 0) {
                        total += a;
                    } else {
                        if (a >= b) {
                            bCount--;
                            total += b;
                        } else {
                            aCount--;
                            total += a;
                        }
                    }
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionNo1029().twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
    }
}
