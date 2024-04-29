package com.chainsys.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class CollectionsDemo {

	public static void main(String[] args) {

		List<String> arrayList = new ArrayList<>();
		arrayList.add("Apple");
		arrayList.add("Banana");
		arrayList.add("Orange");

		System.out.println("ArrayList: " + arrayList);
		System.out.println("constains Apple: " + arrayList.contains("Apple"));
		arrayList.remove(1);
		System.out.println("Removed Banana" + arrayList);
		System.out.println("Index of Orange :" + arrayList.indexOf("Orange"));
		arrayList.clear();
		System.out.println("clear ArrayList: " + arrayList);

		List<String> linkedList = new LinkedList<>();
		linkedList.add("Cat");
		linkedList.add("Dog");
		linkedList.add("Elephant");
		System.out.println("LinkedList: " + linkedList);
		System.out.println();
		
		// Queue
		// first in first out fifo
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println("queue :" + queue);
		System.out.println("peek method return first element:" + queue.peek());

		System.out.println(queue + " poll remove the element:" + queue.poll());
		System.out.println("queue :" + queue);
		System.out.println();
		// stack
		// last in first out
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println("stack :" + stack);
		System.out.println("peek in stack :" + stack.peek());
		System.out.println(stack + " pop remove the element:" + stack.pop());
		System.out.println("stack :" + stack);
		System.out.println();

		// HashSet
		// remove duplicates
		Set<String> hashSet = new HashSet<>();
		hashSet.add("Red");
		hashSet.add("Green");
		hashSet.add("Blue");
		hashSet.add("Red");
		System.out.println("HashSet: " + hashSet);

		// HashMap
		// key value pairs
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(1, "One");
		hashMap.put(2, "Two");
		hashMap.put(3, "Three");
		System.out.println("contains 1:" + hashMap.containsKey(1));
		System.out.println("value  Two:" + hashMap.containsValue("Two"));
		System.out.println("HashMap: " + hashMap);
		for (Map.Entry<Integer, String> e : hashMap.entrySet()) {
			System.out.println("key :" + e.getKey() + " Value :" + e.getValue());

		}

		TreeSet<Integer> treeset = new TreeSet<>();
		treeset.add(10);
		treeset.add(2);
		treeset.add(8);
		treeset.add(3);
		treeset.add(6);
      
		System.out.println();
		System.out.println("TreeSet elements: " + treeset);
		treeset.remove(2);
		System.out.println("TreeSet elements after removal: " + treeset);
		System.out.println("The last element " + treeset.pollLast());

	}

}
