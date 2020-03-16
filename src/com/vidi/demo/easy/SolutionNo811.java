package com.vidi.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Subdomain Visit Count <p>A website domain like "discuss.leetcode.com" consists of various subdomains. At the top
 * level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com".
 * When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com"
 * implicitly.
 * <p>
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by
 * a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".
 * <p>
 * We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same
 * format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
 */
public class SolutionNo811 {
	public static List<String> subdomainVisits(String[] cpdomains) {
		HashMap<String, Integer> map = new HashMap<>();
		List<String> results = new ArrayList<>();
		for (String cpdomain : cpdomains) {
			String[] split = cpdomain.split(" ");
			String countStr = split[0];
			Integer count = new Integer(countStr);
			String domains = split[1];
			while (domains.contains(".")) {
				if (map.containsKey(domains)) {
					map.put(domains, map.get(domains) + count);
				} else {
					map.put(domains, count);
				}
				domains = domains.substring(domains.indexOf(".") + 1);
			}
			if (map.containsKey(domains)) {
				map.put(domains, map.get(domains) + count);
			} else {
				map.put(domains, count);
			}
		}
		for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
			results.add(stringIntegerEntry.getValue() + " " + stringIntegerEntry.getKey());
		}
//        map.forEach((s, integer) -> results.add(integer+" "+s));  太慢了
		return results;
	}

	public static void main(String[] args) {
		List<String> subdomainVisits = subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
		for (String subdomainVisit : subdomainVisits) {
			System.out.println(subdomainVisit);
		}
	}
}
