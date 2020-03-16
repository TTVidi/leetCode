package com.vidi.demo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author : Vidi
 * @Date : 2019/6/12 16:37
 * @Descripton :
 */
public class LogAnalysis {
	public static void main(String[] args) throws IOException {
		String[] danger = new String[]{
				"put", "option", ".jsp", ".php", "baidu", ".action", ".do", ".cnf",
				".conf", ".yml", ".txt", ".tar", ".gz", "rpm", ".war", ".java", ".sql", ".cfg", "properties", ".gz",
				".bak", ".jar", ".xhtml", "\\x", "crul", "400"
		};
		HashMap<String, Integer> hashMap = new HashMap<>(1024);
		File file = new File("G:\\log\\18");
		for (File file1 : file.listFiles()) {
			FileReader fileReader = new FileReader(file1);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String readLine = null;
			while ((readLine = bufferedReader.readLine()) != null) {
				readLine = readLine.toLowerCase();
				for (String s : danger) {
					if (readLine.indexOf(s) >= 0) {
						String substring = readLine.substring(0, readLine.indexOf(" "));
						hashMap.put(substring, hashMap.getOrDefault(substring, 0) + 1);
						break;
					}
				}
			}
			bufferedReader.close();
			fileReader.close();
		}

		File file2 = new File("G:\\log\\19");
		for (File file1 : file2.listFiles()) {
			FileReader fileReader = new FileReader(file1);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String readLine = null;
			while ((readLine = bufferedReader.readLine()) != null) {
				readLine = readLine.toLowerCase();
				for (String s : danger) {
					if (readLine.indexOf(s) >= 0) {
						String substring = readLine.substring(0, readLine.indexOf(" "));
						hashMap.put(substring, hashMap.getOrDefault(substring, 0) + 1);
						break;
					}
				}
			}
			bufferedReader.close();
			fileReader.close();
		}

		for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
			if (stringIntegerEntry.getValue() > 10) {
				System.out.println(stringIntegerEntry.getKey() + "\t" + stringIntegerEntry.getValue());
			}
		}
	}
}
