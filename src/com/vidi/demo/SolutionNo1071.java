package com.vidi.demo;

/**
 * @author : Vidi
 * @date : 2019/7/21 22:15
 * @descripton :For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
 * <p>
 * Return the largest string X such that X divides str1 and X divides str2.
 */
public class SolutionNo1071 {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                sb.append(str1.charAt(i));
            } else {
                break;
            }
        }
        String s = sb.toString();
        for (int j = s.length(); j >= 0; j--) {
            String source = s.substring(0, j);
            if (isDivided(source, str1) && isDivided(source, str2)) {
                return source;
            }
        }
        return "";
    }

    public boolean isDivided(String source, String target) {
        int sLength = source.length();
        int tLength = target.length();
        if (sLength > 0 && tLength > 0) {
            if (tLength % sLength > 0) {
                return false;
            }
            int times = tLength / sLength;
            StringBuilder sb = new StringBuilder(source);
            for (int i = 1; i < times; i++) {
                sb.append(source);
            }
            return sb.toString().equals(target);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionNo1071().gcdOfStrings("ABCABCABCABC", "ABCABC"));

    }
}
