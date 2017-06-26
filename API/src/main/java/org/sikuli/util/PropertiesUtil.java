package org.sikuli.util;

import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;

public class PropertiesUtil {
	public static Properties properties = new Properties();
	static {
		try {			
			InputStream is = PropertiesUtil.class.getResourceAsStream("/Settings/sendEvent.txt");
			properties.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperties(String key, String _default) {
		String value = properties.getProperty(key);
		if (StringUtils.isBlank(value))
			value = _default;
		return value;
	}

	public static String getProperties(String key) {
		return properties.getProperty(key);
	}
	public static void main(String[] args) {
		System.err.println(PropertiesUtil.getProperties("sendTapEvent"));

	}
}
