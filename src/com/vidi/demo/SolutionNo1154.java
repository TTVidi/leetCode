package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/8/12 9:54
 * @Descripton :Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day
 * number of the year.
 */
public class SolutionNo1154 {
	public int dayOfYear(String date) {
		String[] strings = date.split("-");
		int year = Integer.parseInt(strings[0]);
		int month = Integer.parseInt(strings[1]);
		int day = Integer.parseInt(strings[2]);
		int total = day;
		for (int i = 1; i < month; i++) {
			switch (i) {
				case 1:
					total += 31;
					break;
				case 2:
					if (year % 400 == 0) {
						total += 29;
					} else if (year % 100 == 0) {
						total += 28;
					} else if (year % 4 == 0) {
						total += 29;
					} else {
						total += 28;
					}
					break;
				case 3:
					total += 31;
					break;
				case 4:
					total += 30;
					break;
				case 5:
					total += 31;
					break;
				case 6:
					total += 30;
					break;
				case 7:
					total += 31;
					break;
				case 8:
					total += 31;
					break;
				case 9:
					total += 30;
					break;
				case 10:
					total += 31;
					break;
				case 11:
					total += 30;
					break;
				default:
					break;
			}
		}
		return total;
	}
}
