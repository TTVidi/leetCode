package com.vidi.demo;

import java.util.HashSet;

/**
 * @Author : Vidi
 * @Date : 2018/11/26 15:10
 * @Descripton :
 * <p>
 * Unique Morse Code Words
 * <p>
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as
 * follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * <p>
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For
 * example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a
 * concatenation, the transformation of a word.
 * <p>
 * Return the number of different transformations among all words we have.
 */
public class SolutionNo804 {
	static String[] codes = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

	public static int uniqueMorseRepresentations(String[] words) {
		HashSet<String> distinct = new HashSet<>();
		for (String word : words) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < word.length(); i++) {
				String code = codes[word.charAt(i) - 97];
				builder.append(code);
			}
			distinct.add(builder.toString());
		}
		return distinct.size();
	}

	public static void main(String[] args) {
		String[] words = new String[]{"gin", "zen", "gig", "msg"};
		System.out.println(uniqueMorseRepresentations(words));

	}
}
