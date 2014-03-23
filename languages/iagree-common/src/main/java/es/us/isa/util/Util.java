package es.us.isa.util;

public class Util {

	public static String withoutQuotes(String s) {
		String str = s;
		if (str.startsWith("\"")) {
			str = str.substring(1, str.length());
		}
		if (str.endsWith("\"")) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	public static String convertEntities(String s) {
		String str = s;
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		return str;
	}

	public static String convertMetricType(String originalType) {
		String newType = originalType;

		if (originalType != null) {
			newType = newType.toLowerCase();

			if (originalType.equals("float") || originalType.equals("double")
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
}
