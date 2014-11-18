package es.us.isa.ideas.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {

	public static String withoutDoubleQuotes(String s) {
		String str = s;
		if (str.startsWith("\"")) {
			str = str.substring(1, str.length());
		}
		if (str.endsWith("\"")) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}
	
	public static String withoutQuotes(String s) {
		String str = s;
		if (str.startsWith("\'")) {
			str = str.substring(1, str.length());
		}
		if (str.endsWith("\'")) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	public static String encodeEntities(String s) {
		String str = s;
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		return str;
	}
	
	public static String decodeEntities(String s) {
		String str = s;
		str = str.replaceAll("&lt;", "<");
		str = str.replaceAll("&gt;", ">");
		return str;
	}

	public static String convertMetricType(String originalType) {
		String newType = null;

		if (originalType != null) {
			originalType = originalType.toLowerCase();
			
			if (originalType.equals("float") 
					|| originalType.equals("double")
					|| originalType.equals("natural")
					|| originalType.equals("number")
					|| originalType.equals("cost")
					|| originalType.equals("time")
					|| originalType.equals("size")
					|| originalType.equals("errors")
					|| originalType.equals("money")
					|| originalType.equals("percent")
					|| originalType.equals("integer")
					|| originalType.equals("string")) {
				newType = "integer";
			} else {
				newType = "enumerated";
			}
		}

		return newType;
	}

	public static String loadFile(String filePath) {
		// Location of file to read
		File f = new File(filePath);
		FileInputStream is;
		String res = "";
		try {
			is = new FileInputStream(f);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line.replaceAll("	", "\t")+"\n");
			}
			res = sb.toString();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
}
