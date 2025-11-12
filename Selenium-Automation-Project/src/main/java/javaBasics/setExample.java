package javaBasics;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class setExample {

	//Iterable(I) --> Collection(I) --> List(I), Set(I), Queue(I)
	//List(I) --> ArrayList(C), LinkedList(C), Stack(Legacy Class), Vector(Legacy Class)
	//Set(I) --> HashSet(C) --> LinkedHashSet(C)
	//Set(I) --> SortedSet(I) --> NavigableSet(I) --> TreeSet(C)
		
	//Map will not be in Collection
	//Map(I) --> HashMap, HashLinkedMap, HashTable, TreeMap
		
	public static void main(String[] args) {
		setExample obj = new setExample();
		obj.hashsetExample();
		obj.treeSetExample();

	}
	
	//Duplicate values not allowed
	//Insertion order not maintained
	public void hashsetExample() {
		
		Set<String> setOfCities = new HashSet<String>();
		
		//HashSet<String> setOfCities = new HashSet<String>();
		setOfCities.add("Chennai");
		setOfCities.add("Mumbai");
		setOfCities.add("Banglore");
		setOfCities.add("Hyderabad");
		
		Iterator<String> storedSetOfCities = setOfCities.iterator();
		while(storedSetOfCities.hasNext()) {
		System.out.println(storedSetOfCities.next());
		}
		
		
	}
	
	public void treeSetExample() {
		
		//Set<Integer> numbers = new TreeSet<Integer>();
		TreeSet<Integer> numbers = new TreeSet<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		
		Iterator<Integer> descOrder = numbers.descendingIterator();
		while(descOrder.hasNext()) {
			System.out.println(descOrder.next());
		}
		
	}
	

}
