package com.vidi.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Vidi
 * @Date : 2019/7/30 10:03
 * @Descripton :You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.
 * <p>
 * paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.
 * <p>
 * Also, there is no garden that has more than 3 paths coming into or leaving it.
 * <p>
 * Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have
 * different types of flowers.
 * <p>
 * Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.
 * The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.
 */
public class SolutionNo1042 {
	public static int[] gardenNoAdj(int N, int[][] paths) {
		Garden[] gardens = new Garden[N];
		for (int i = 0; i < N; i++) {
			Garden garden = new Garden();
			garden.index = i;
			gardens[i] = garden;
		}
		for (int[] path : paths) {
			int i = path[0] - 1;
			int j = path[1] - 1;
			Garden gardeni = gardens[i];
			Garden gardenj = gardens[j];
			setPath(gardeni, gardenj);
			gardens[i] = gardeni;
			gardens[j] = gardenj;
		}
		int[] result = new int[N];
		for (Garden garden : gardens) {
			int[] temp = new int[4];
			for (Integer integer : garden.map.keySet()) {
				temp[gardens[integer].flower] = -1;
			}
			for (int i = 0; i < temp.length; i++) {
				if (temp[i] == 0) {
					result[garden.index] = i + 1;
					garden.flower = i;
					break;
				}
			}
		}
		return result;
	}

	public static void setPath(Garden gardeni, Garden gardenj) {
		gardeni.map.put(gardenj.index, gardenj);
		gardenj.map.put(gardeni.index, gardeni);
	}

	static class Garden {
		int index;
		int flower;
		Map<Integer, Garden> map = new HashMap<>(4);
	}

	public static void main(String[] args) {
		for (int i : gardenNoAdj(4, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}})) {
			System.out.println(i);
		}

		for (int i : gardenNoAdj(4, new int[][]{{1, 2}, {3, 4}})) {
			System.out.println(i);
		}
		System.out.println("------------------");
		for (int i : gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}})) {
			System.out.println(i);
		}
//		gardenNoAdj(4, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}});
	}
}
