package javaBasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class listExample {
	
	//Iterable(I) --> Collection(I) --> List(I), Set(I), Queue(I)
	//List(I) --> ArrayList(C), LinkedList(C), Stack(Legacy Class), Vector(Legacy Class)
	//Set(I) --> HashSet(C) --> LinkedHashSet(C)
	//Set(I) --> SortedSet(I) --> NavigableSet(I) --> TreeSet(C)
	
	//Map will not be in Collection
	//Map(I) --> HashMap, HashLinkedMap, HashTable, TreeMap
	
	public static void main(String[] args) {
		listExample obj = new listExample();
		obj.arrayListExample();
	}

	// Array list will maintain insertion order and also allows duplicate values
	// Size is not fixed, we can add as many as we want
	public void arrayListExample() {
		List<String> fruits = new ArrayList<String>();
		fruits.add("Apple");
		fruits.add("Grape");
		fruits.add("Kiwi");	
		fruits.add("Orange");
		fruits.add("Grape");
		//This will print the list of values in array list
		System.out.println("Array list of fruits: "+fruits);
		//Array list of fruits: [Apple, Grape, Kiwi]
		
		System.out.println("----------------------------------------------");
		Collections.sort(fruits);
		System.out.println("Sorted Array list of fruits: "+ fruits);
		System.out.println("Get fruit using index from Array list of fruits: "+fruits.get(0));
		System.out.println("Get first fruit from Array list of fruits: "+fruits.getFirst());
		System.out.println("Get last fruit from Array list of fruits: "+fruits.getLast());
		System.out.println("Get class of Array list of fruits: "+fruits.getClass());
		//Get class of Array list of fruits: class java.util.ArrayList
		System.out.println("----------------------------------------------");
		
		//Values are case sensitive
		System.out.println("Get index from Array list of fruits using value: "+fruits.indexOf("Kiwi"));
		System.out.println("Get index from Array list of fruits using incorrect value: "+fruits.indexOf("Banana")); // This will return -1 as there is no such value
		System.out.println("Get index from Array list of fruits using value while is last in the list: "+fruits.lastIndexOf("Grape"));
		System.out.println("----------------------------------------------");
		
		List<String> newFruits = new ArrayList<String>();
		newFruits.addAll(fruits);
		System.out.println("Array list of new fruits: "+newFruits);
		System.out.println("Reverse Array list of new fruits: "+newFruits.reversed());
		List<String> reversedNewFruits = newFruits.reversed();
		System.out.println("Array list of reversed new fruits: "+reversedNewFruits);
		System.out.println("Again Reverse Array list of new fruits: "+reversedNewFruits.reversed());
		System.out.println("Change value using index in Array list of new fruits: "+newFruits.set(0, "Water Melon")); //This will return the element which was present before
		System.out.println("Changed value using index in Array list of new fruits: "+newFruits.get(0));
		System.out.println("Changed value using index in Array list of new fruits: "+newFruits.remove(3));
		System.out.println("Array list of new fruits: "+newFruits);
		
		System.out.println("----------------------------------------------");
		
		//ListIterator is used to Iterate list in both forward and reverse 
		ListIterator<String> listIterationOfArrayList = newFruits.listIterator();
		//Forward Order
		while(listIterationOfArrayList.hasNext()){
			System.out.println(listIterationOfArrayList.next());
		}
		System.out.println("----------------------------------------------");
		//Reverse order
		while(listIterationOfArrayList.hasPrevious()){
			System.out.println(listIterationOfArrayList.previous());
		}
		
		System.out.println("----------------------------------------------");

		//Iterator is used to Iterate list but only in forward
		Iterator<String> iterationOfArrayList = newFruits.iterator();
		//Forward Order
		while(iterationOfArrayList.hasNext()){
					System.out.println(iterationOfArrayList.next());
				}
		
		System.out.println("----------------------------------------------");
		List<Integer> numbers = new LinkedList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		
		
		}
}
