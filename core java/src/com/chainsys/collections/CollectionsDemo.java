package com.chainsys.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
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
      
		//	In linkedlist is good for manipulation of date
		// insertion deletion are faster in linkedlist compare to arraylist
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add("Cat");
		linkedList.add("Dog");
		linkedList.add("Elephant");
		linkedList.addFirst("lion");
		linkedList.addLast("tiger");
		System.out.println("LinkedList: " + linkedList);
		System.out.println();

		// Queue
		// first in first out fifo
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(3);
		queue.add(1);
		queue.add(2);
		System.out.println("queue :" + queue);
		System.out.println("peek method return first element:" + queue.peek());
		System.out.println(queue + " poll remove the element:" + queue.poll());
		System.out.println("queue :" + queue);
		System.out.println();
		
		//priority queue is similar to queue , priorities and add small element to first of the queue.
		//elements are in sorted order in priority queue
		Queue<Integer> pqueue = new PriorityQueue<Integer>();
		pqueue.add(3);
		pqueue.add(1);
		pqueue.add(2);
		System.out.println("priority queue :" + pqueue);
		System.out.println("peek method return first element:" + pqueue.peek());
		System.out.println(pqueue + " poll remove the element:" + pqueue.poll());
		System.out.println("queue :" + pqueue);
		System.out.println();
		//deque is a interface ,arraydeque and linkedlist implements it.
		//deque using we can add element to first and last index of array
		Deque<Integer> arrdeque=new ArrayDeque();
		arrdeque.add(3);
		arrdeque.add(1);
		arrdeque.add(2);
		arrdeque.addFirst(10);
		arrdeque.addLast(20);
		System.out.println("array deque :" + arrdeque);
	
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

		// HashMap
		// key value pairs
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(1, "One");
		hashMap.put(3, "Three");
		hashMap.put(2, "Two");
		System.out.println("HashMap: " + hashMap);
		for (Map.Entry<Integer, String> e : hashMap.entrySet()) {
			System.out.println("key :" + e.getKey() + " Value :" + e.getValue());

		}
		System.out.println("contains 1:" + hashMap.containsKey(1));
		System.out.println("value  Two:" + hashMap.containsValue("Two"));
		System.out.println();
		//it is synchronized
		Map<Integer, String> hashtable = new Hashtable<>();
		hashtable.put(1, "One");
		hashtable.put(3, "Three");
		hashtable.put(2, "Two");
		System.out.println("Hashtable: " + hashtable);
		// HashSet
		// remove duplicates (only unique elements)
		// does not maintain the order
		System.out.println();
		System.out.println("set :hashset , linkedhashset , Treeset");
		Set<String> hashSet = new HashSet<>();
		hashSet.add("Red");
		hashSet.add("Green");
		hashSet.add("Blue");
		hashSet.add("Red");
		System.out.println("HashSet: " + hashSet);

		// LinkedHashSet
		// remove duplicates (only unique elements)
		// maintain the order
		LinkedHashSet<String> linkedHashset = new LinkedHashSet<>();
		linkedHashset.add("Kishor");
		linkedHashset.add("Abinesh");
		linkedHashset.add("Kishor");
		linkedHashset.add("Ramani");
		System.out.println("LinkedHashSet: " + linkedHashset);
		// TreeSet
		// remove duplicates (only unique elements)
		// sort the elements 
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("Kishor");
		treeSet.add("Abinesh");
		treeSet.add("Kishor");
	    treeSet.add("Ramani");
		System.out.println("TreeSet: " + treeSet);
		TreeSet<Integer> treeset = new TreeSet<>();
		treeset.add(10);
		treeset.add(2);
		treeset.add(8);
		treeset.add(3);
		treeset.add(6);
		System.out.println("TreeSet elements: " + treeset);
		treeset.remove(2);
		System.out.println("TreeSet elements after removal: " + treeset);
		System.out.println("The last element " + treeset.pollLast());

	}

}
