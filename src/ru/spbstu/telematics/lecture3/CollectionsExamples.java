package ru.spbstu.telematics.lecture3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionsExamples {
	
	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<Integer>(23);
		
		for (int i = 0; i < 1000; i++) {
			l.add(i);
		}
		System.out.println(l.size());
		
		LinkedList list = new LinkedList<>();
		list.add("a string");
		list.add("b string");
		
		for (Object el : list) {
			System.out.println(el);
		}
		
		Set set1 = new HashSet();
		
		set1.add("A");
		set1.add("B");
		set1.add("A");
		
		for (Object o : set1) {
			System.out.println(o);
		}
		
		Set set2 = new TreeSet();
		/*
		new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return 0;
			}
		}*/
		
		set2.add("C");
		set2.add("1");
		set2.add("2");
		set2.add("A");
		//set2.add(new Object());
		
		for (Object o : set2) {
			System.out.println(o);
		}
		
		LinkedHashSet set3 = new LinkedHashSet();
		set3.add("c");
		set3.add("d");
		set3.add("x");
		for (Object o : set3) {
			System.out.println(o);
		}
		
		System.out.println("Iterable example");
		
		for (Object x : new SimpleCollection()) {
			System.out.println(x);
		}
		
		System.out.println("Maps...");
		
		Map map = new HashMap<>();
		map.put("str1", new Integer(1));
		map.put("str2", new Integer(2));
		map.put("str3", new Integer(3));
		
		System.out.println(map.get(3));
		
		for (Object o: map.keySet()) {
			System.out.println(o + ":" + map.get(o));
		}
		
		Map map2 = new TreeMap();
		map2.put("str3", new Integer(1));
		map2.put("str1", new Integer(2));
		map2.put("str2", new Integer(3));
	    System.out.println("TreeMap");
		for (Object o: map2.keySet()) {
			System.out.println(o + ":" + map.get(o));
		}
		
		Map<String, Integer> map3 = new LinkedHashMap<>();
		map3.put("str3", new Integer(1));
		map3.put("str1", new Integer(2));
		map3.put("str2", new Integer(3));
	    System.out.println("TreeMap");
		for (Object o: map3.keySet()) {
			System.out.println(o + ":" + map.get(o));
		}
		
		Integer object = map3.get("str1");
		//Collections. 
		
		Pair<String, Integer> p = new Pair<>();
	}

}
