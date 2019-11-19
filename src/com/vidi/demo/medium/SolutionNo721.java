package com.vidi.demo.medium;

import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : Vidi
 * @Date : 2019/11/13 16:42
 * @Descripton :Given a list accounts, each element accounts[i] is a list of strings, where the first element
 * accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 * <p>
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email
 * that is common to both accounts. Note that even if two accounts have the same name, they may belong to different
 * people as people could have the same name. A person can have any number of accounts initially, but all of their
 * accounts definitely have the same name.
 * <p>
 * After merging the accounts, return the accounts in the following format: the first element of each account is the
 * name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 */
public class SolutionNo721 {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < accounts.size(); i++) {
			List<String> list = accounts.get(i);
			for (int j = 1; j < list.size(); j++) {
				String s = list.get(j);
				List<Integer> orDefault = map.getOrDefault(s, new ArrayList<>());
				orDefault.add(i);
			}
		}

		map.forEach((s, integers) -> {

		});
		return null;
	}
}
