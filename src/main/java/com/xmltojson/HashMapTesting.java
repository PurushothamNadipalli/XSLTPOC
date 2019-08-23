package com.xmltojson;

import java.util.HashMap;
import java.util.Map;

public class HashMapTesting {
private static	Map<Integer,String> map=new HashMap<Integer,String>();

	public static void putmap(int i, String value) {
		map.put(i, value);
	}

	public static void main(String[] args) {
		HashMapTesting.putmap(1, "hello");
		System.out.println(map);
		HashMapTesting.putmap(1, "hi");
		System.out.println(map);
	}

}
