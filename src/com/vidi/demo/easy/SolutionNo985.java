package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/2/11 8:58
 * @Descripton : <p>Sum of Even Numbers After Queries
 * <p>
 * We have an array A of integers, and an array queries of queries.
 * <p>
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th
 * query is the sum of the even values of A.
 * <p>
 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
 * <p>
 * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 */
public class SolutionNo985 {
	public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int[] result = new int[A.length];
		int even = 0;
		for (int i : A) {
			even += (i % 2 == 0 ? i : 0);
		}
		for (int i = 0; i < queries.length; i++) {
			int index = queries[i][1];
			int count = queries[i][0];
			if (A[index] % 2 == 0) {
				if (count % 2 == 0) {
					even += count;
				} else {
					even -= A[index];
				}
			} else {
				if (count % 2 != 0) {
					even += (A[index] + count);
				}
			}
			A[index] += count;
			result[i] = even;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] sumEvenAfterQueries = sumEvenAfterQueries(new int[]{-1, 3, -3, 9, -6, 8, -5}, new int[][]{{-5, 1}, {10, 2}, {-6, 3}, {3, 2}, {9, 5}, {7, 5}, {8, 0}});
		for (int sumEvenAfterQuery : sumEvenAfterQueries) {
			System.out.println(sumEvenAfterQuery);
		}
	}
}
