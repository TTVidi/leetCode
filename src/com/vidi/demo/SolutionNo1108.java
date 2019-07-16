package com.vidi.demo;

/**
 * @Author : Vidi
 * @Date : 2019/7/16 10:15
 * @Descripton :Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * <p>
 * A defanged IP address replaces every period "." with "[.]".
 */
public class SolutionNo1108 {
	public static String defangIPaddr(String address) {
		address=address.replace(".", "[.]");
		return address;
	}

	public static void main(String[] args) {
		System.out.println(defangIPaddr("1.1.1.1"));
	}
}
