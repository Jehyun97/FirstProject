package com.java.attribute;

import java.util.HashMap;
import java.util.Map;

public class Session {
	public Session() {
	}

	private static Session session = new Session();

	public static Session getSession() {
		return session;
	}

	// 정보입출구역 정형화된 규격

	private Map<String, Object> attributMap = new HashMap<String, Object>();

	public void setAttribute(String key, Object value) {
		attributMap.put(key, value);
	}

	public Object getAttribute(String key) {
		return attributMap.get(key);
	}

}
