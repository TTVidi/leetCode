package com.vidi.demo;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author : Vidi
 * @Date : 2018/11/26 11:37
 * @Descripton :
 * <p>
 * Unique Email Addresses
 * <p>
 * Every email consists of a local name and a domain name, separated by the @ sign.
 * <p>
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 * <p>
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * <p>
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be
 * forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and
 * "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 * <p>
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain
 * emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not
 * apply for domain names.)
 * <p>
 * It is possible to use both of these rules at the same time.
 * <p>
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive
 * mails?
 */
public class SolutionNo929 {
	public static int numUniqueEmails(String[] emails) {
		HashMap<String, Integer> countMap = new HashMap<>();
		for (String email : emails) {
			String localName = email.split("@")[0];
			String domainName = email.split("@")[1];
			localName = localName.replace(".", "");
			if (localName.contains("+")) {
				localName = localName.substring(0, localName.indexOf("+"));
			}
			countMap.put(localName + domainName, 1);
		}
		return countMap.size();
	}


	public static void main(String[] args) {
		String[] ss = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
		System.out.println(numUniqueEmails(ss));

	}
}
