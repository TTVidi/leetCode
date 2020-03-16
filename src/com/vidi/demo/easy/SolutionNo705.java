package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/1/23 11:22
 * @Descripton :
 * <p>
 * Design HashSet
 * <p>
 * Design a HashSet without using any built-in hash table libraries.
 * <p>
 * To be specific, your design should include these functions:
 * <p>
 * add(value): Insert a value into the HashSet. contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 */
public class SolutionNo705 {
	boolean[] set = new boolean[1000000];

	/**
	 * Initialize your data structure here.
	 */
	public void add(int key) {
		set[key] = true;
	}

	public void remove(int key) {
		set[key] = false;
	}

	/**
	 * Returns true if this set contains the specified element
	 */
	public boolean contains(int key) {
		return set[key];
	}
}
