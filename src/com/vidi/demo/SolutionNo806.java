package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/3 10:25
 * @Descripton :
 * <p>
 * Number of Lines To Write String
 * <p>
 * We are to write the letters of a given string S, from left to right into lines. Each line has maximum width 100
 * units, and if writing a letter would cause the width of the line to exceed 100 units, it is written on the next line.
 * We are given an array widths, an array where widths[0] is the width of 'a', widths[1] is the width of 'b', ..., and
 * widths[25] is the width of 'z'.
 * <p>
 * Now answer two questions: how many lines have at least one character from S, and what is the width used by the last
 * such line? Return your answer as an integer list of length 2.
 */
public class SolutionNo806 {
	public int[] numberOfLines(int[] widths, String S) {
		int[] res = new int[2];
		if(S.isEmpty()) return res;
		for(char c : S.toCharArray()){
			int index = c-'a';
			if(res[1]+widths[index]>100){
				res[0]++;
				res[1]=widths[index];
			}else{
				res[1]+=widths[index];
			}
		}
		res[0]++;
		return res;
	}
}
