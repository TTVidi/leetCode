package com.vidi.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2019/1/7 15:39
 * @Descripton :
 * <p>
 * Design HashMap
 * <p>
 * Design a HashMap without using any built-in hash table libraries.
 * <p>
 * To be specific, your design should include these functions:
 * <p>
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the
 * value. get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for
 * the key. remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 */
public class SolutionNo706 {
	int[] temp = new int[1000000];
	int length = temp.length;

	List<Integer> array = new ArrayList<>();

	/**
	 * Initialize your data structure here.
	 */
	public SolutionNo706() {
		for (int i = 0; i < temp.length; i++) {
			temp[i] = -1;
		}

	}

	/**
	 * value will always be non-negative.
	 */
	public void put(int key, int value) {
		temp[key % length] = value;
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
	 */
	public int get(int key) {
		return temp[key % length];
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping for the key
	 */
	public void remove(int key) {
		temp[key % length] = -1;
	}

	public static void main(String[] args) {
	}
}
