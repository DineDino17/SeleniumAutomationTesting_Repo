package collectionsJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CrossFunctionsWithArrayAndList {

	public static void main(String[] args) {
		//Arrays
		String[] name = {"John","Alex","Dino","Thor"};
		List<String> nameList = Arrays.asList(name); //Size is fixed
		
		
		//List
		List<String> fruits = new ArrayList<String>();
		Collections.addAll(fruits, "Apple","Orange","Grape","Papaya");
		fruits.add("Banana");
		
		//To Linked List
		LinkedList<String> fruitsLinkedList = new LinkedList<String>(fruits);
		System.out.println("Print fruits: "+fruitsLinkedList);
		
		LinkedList<String> reversedList = fruitsLinkedList.reversed();
		System.out.println("Print fruits: "+reversedList);
		
		Object[] fruitsReversedArray = reversedList.toArray();	//String[] can't be used as toArray returns Object[]
		System.out.println("Fruits Reversed Array: "+Arrays.toString(fruitsReversedArray));
		//Fruits Reversed Array: [Banana, Papaya, Grape, Orange, Apple]
		
		//Set
		Set<String> locationSet = new HashSet<String>();
		Collections.addAll(locationSet, "Chennai","Mumbai","Banglore","Hyderabad");
		locationSet.add("Pune");
		
		//Collections.sort(fruitsSet); //We cannot sort the Set, we need to convert it to Tree Set
		
		LinkedHashSet<String> locationLinkedSet = new LinkedHashSet<String>(locationSet);
		locationLinkedSet.add("Delhi");
		
		TreeSet<String> sortLocationSet = new TreeSet<String>(locationSet);
		System.out.println("Sorted order of location set: "+sortLocationSet);
		
		//Map
		HashMap<String, String> testData = new HashMap<String, String>();
		
		testData.put("Name", "Dinesh");
		testData.put("Location", "Chennai");
		testData.put("Location", "Banglore");	//Chennai will be replaced
		
		System.out.println(testData.get("Location"));
		System.out.println(testData.entrySet());	//[Name=Dinesh, Location=Banglore]
		
		Map<String, List<String>> map = new HashMap<>();
		map.putIfAbsent("Fruits", new ArrayList<>());
		map.get("Fruits").add("Apple");
		map.get("Fruits").add("Grape");
		
		map.putIfAbsent("Vegetables", new ArrayList<>());
		map.get("Vegetables").add("Carrot");
		map.get("Vegetables").add("Onion");
		
		System.out.println("Details in map: "+map);
		System.out.println("Details in map using entry set: "+map.entrySet());
		System.out.println(map.get("Fruits"));			//	[Apple, Grape]
		System.out.println(map.get("Fruits").get(0));
		
		//Removes duplicate from list
		List<String> cars = new ArrayList<String>();
		Collections.addAll(cars, "BMW","Benz","Toyoto","Tata","BMW","Hyundai");
		Set<String> fromList = new HashSet<String>(cars);
		System.out.println("From list to set"+fromList);
		

	}

}
