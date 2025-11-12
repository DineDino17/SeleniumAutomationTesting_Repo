package collectionsJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapExample {
	
	public static void main(String[] args) {
		
		HashMap<Integer, String> mapCar = new HashMap<Integer, String>();
		
		mapCar.put(1, "BMW");
		mapCar.put(2, "Benz");
		mapCar.put(3, "Audi");
		mapCar.put(4, "Jaguar");
		
		System.out.println("Values in map car: "+mapCar);
		
		System.out.println("Values of key 2: "+mapCar.get(2));
		
		System.out.println("Values in map car using entry set: "+mapCar.entrySet());
		
		mapCar.replace(4, "Mini Cooper");
		
		System.out.println("After replacing vales of key 4: "+mapCar.entrySet());
		
		HashMap<String, String> testData = new HashMap<String, String>();
		
		testData.put("Name", "Dinesh");
		testData.put("Location", "Chennai");
		testData.put("Location", "Banglore");	//Chennai will be replaced
		
		System.out.println(testData.get("Location"));
		System.out.println(testData.entrySet());
		
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
		System.out.println(map.get("Fruits").get(0));	//	Apple
		
	}

}
