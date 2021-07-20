package com.quanglinh.layout.custom;

import java.util.HashMap;
import java.util.Map;

public class Bundle {
	private Map<String, Object> map = new HashMap<String, Object>();

	public void put(String key, Object object) {
		map.put(key, object);
	}
	public Object getValue(String key) {
		if(map.containsKey(key)) {
			return map.get(key);

		}
		return null;
	}
	public Map<String, Object> getMap() {
		return map;
	}
}
