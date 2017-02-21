package search;

import java.io.*;
import java.util.Scanner;

public class updateDictionary {

	public void add(String type, String name) {
		String path = "dictionary/dict.txt";
		Scanner scanner;
		try {
			scanner = new Scanner(new FileInputStream(path), "UTF-8");
			String line = null;
			while (scanner.hasNext()) {
				line = scanner.nextLine().trim();
				if (line.length() > 0) {
					String a[] = line.split(" ");
					if (a[0].equals(name))
						break;
				}
			}
			if (!scanner.hasNext()) // 没有找到，加入
			{
				File file = new File(path);
				Writer outTxt = new OutputStreamWriter(new FileOutputStream(file,true), "UTF-8");
				String str1 = name + " " + "'" + name + "'";
				String str2 = "'" + name + "'" + " " + type;
				outTxt.write("\n"+str1);
				outTxt.write("\n"+str2);
				outTxt.close();
			}
			scanner.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
