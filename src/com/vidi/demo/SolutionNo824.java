package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2018/12/25 8:47
 * @Descripton :
 * <p>
 * Goat Latin
 * <p>
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters
 * only.
 * <p>
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * <p>
 * The rules of Goat Latin are as follows:
 * <p>
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word. For example, the word 'apple'
 * becomes 'applema'.
 * <p>
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add
 * "ma". For example, the word "goat" becomes "oatgma".
 * <p>
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1. For example, the
 * first word gets "a" added to the end, the second word gets "aa" added to the end and so on. Return the final sentence
 * representing the conversion from S to Goat Latin.
 */
public class SolutionNo824 {
	public String toGoatLatin(String S) {
		if (S == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		StringBuilder tempa = new StringBuilder("a");
		StringBuilder temp;
		String[] split = S.split(" ");
		for (String s : split) {
			temp = new StringBuilder(s);
			switch (s.charAt(0)) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
					temp.append("ma");
					break;
				default:
					temp.deleteCharAt(0).append(s.charAt(0)).append("ma");
					break;
			}
			sb.append(temp).append(tempa).append(" ");
			tempa.append("a");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}

	public static void main(String[] args) {
		SolutionNo824 solution = new SolutionNo824();
		System.out.println(solution.toGoatLatin("The quick brown fox jumped over the lazy dog"));
	}
}
