package com.vidi.pattern;

import java.io.*;

/**
 * @Author : Vidi
 * @Date : 2019/11/26 16:04
 * @Descripton :
 */
public class LogProcess {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Vidi.Vidi-PC\\Desktop\\log\\17\\debug1.log");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String readLine = null;
		StringBuilder sb=new StringBuilder();
		while ((readLine = bufferedReader.readLine()) != null) {
			readLine = readLine.toLowerCase();
			if (readLine.indexOf("update eip_wx_project") > 0) {
				String substring = readLine.substring(0, 2);
				if (substring.equals("12")||substring.equals("13")||substring.equals("14")){
					sb.append(readLine).append("\n");
				}
			}
		}
		bufferedReader.close();
		fileReader.close();

		File file1 = new File("C:\\Users\\Vidi.Vidi-PC\\Desktop\\log\\17\\debug1.log");
		FileWriter writer = new FileWriter(file1);
		writer.write(sb.toString());
		writer.flush();
		writer.close();
	}
}
