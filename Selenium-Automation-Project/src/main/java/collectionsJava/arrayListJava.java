package collectionsJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class arrayListJava {
	
	//Iterable(I) --> Collection(I) --> List(I), Set(I), Queue(I)
		//List(I) --> ArrayList(C), LinkedList(C), Stack(Legacy Class), Vector(Legacy Class)
		//Set(I) --> HashSet(C) --> LinkedHashSet(C)
		//Set(I) --> SortedSet(I) --> NavigableSet(I) --> TreeSet(C)

	public static void main(String[] args) {
		arrayListJava obj = new arrayListJava();
		obj.arrayListMethod();

	}

	public void arrayListMethod() {
		
		//Maintains Insertion Order
		//Allows Duplicate
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(10);
		numList.add(30);
		numList.add(20);
		numList.add(10);
		
		System.out.println(numList);
		
		numList.size();
		
		List<Integer> numListNew = new ArrayList<Integer>();
		numListNew.addAll(numList);
		
		Collections.sort(numList);
		List<Integer> reversedNum = numList.reversed();
		
		System.out.println(reversedNum);
		
		numListNew.removeLast();
		System.out.println(numListNew);
		
		numListNew.remove(0);
		System.out.println(numListNew);
		
		numList.get(2);
		
		Integer[] numArray = {1, 5, 8, 20, 15};
		Arrays.sort(numArray);
		System.out.println(Arrays.deepToString(numArray));
		
		List<Integer> numListSample = new ArrayList<Integer>();
		numListSample = Arrays.asList(numArray);
		System.out.println(numListSample);
		
		Integer[] newNumArray = numListSample.toArray(new Integer[0]);
		System.out.println(Arrays.deepToString(newNumArray));
		
		List<String> name = new ArrayList<String>();
		name.add("A");
		name.add("B");
		name.add("C");
		name.add("C");
		name.add("C");
		
		System.out.println("Name list: "+name);
		name.remove("C");
		
		System.out.println("New Name list: "+name);
		
		String[] nameArray = {"a","b","c","d","d","d","",""};
		
		//This will create a new ArrayList and store the converted list here
		//This will help to work on list efficiently
		List<String> nameListNew = new ArrayList<String>(Arrays.asList(nameArray));
		//nameListNew.remove(6);
		
		//This will just convert Array as list where the list size will be fixed so we cannot modify the values here.
		List<String> nameList = Arrays.asList(nameArray);
		nameList.get(6);	//We can get the values
		//nameList.remove(0);	//We can't modify the data 
		
		/*
		for(int i=0; i<nameList.size(); i++) {
			if(nameList.get(i).equals("")) {
				nameList.remove(i);
			}
		}
		*/
		
		/*
		for (String nameData : nameList) {
			if(nameData.equals("")) {
				nameList.remove(nameData);
			}
		}
		*/
		System.out.println("Name list from array: "+nameList);
		
		while(nameListNew.contains("")) {
			nameListNew.remove("");
		}
		List<String> reversedNameList = nameListNew.reversed();
		
		System.out.println("New Name list from array after removing \"\" and reversed: "+reversedNameList);
		
		String[] nameArrayNew = reversedNameList.toArray(new String[0]);
		System.out.println("Name Array new reversed: "+Arrays.deepToString(nameArrayNew));
		Arrays.sort(nameArrayNew); 
		System.out.println("Name Array new: "+Arrays.deepToString(nameArrayNew));
		
		nameArrayNew[0] = "x";
		System.out.println("Name Array new replacing 0th index with x: "+Arrays.deepToString(nameArrayNew));
		
		List<String> linkList= new LinkedList<String>();
		linkList.add("D");
		linkList.add("N");
		linkList.add("E");
		linkList.add("P");
		
		ListIterator<String> iterator = linkList.listIterator();
		while(iterator.hasNext()) {
			System.out.println("Linked List: "+iterator.next());
		}
		
		
		linkList.set(2, "S");
		System.out.println("Values of linked list: "+linkList);
		
		List heterogeneousList = new LinkedList();
		heterogeneousList.add(1);
		heterogeneousList.add(5);
		heterogeneousList.add("Name");
		heterogeneousList.add("Apple");
		
		System.out.println("Hetrogeneuous List: "+heterogeneousList);
		
		/*
		 * We cannot sort the heterogeneous list
		List newHetrogeneousList = Collections.sort(heterogeneousList);
		System.out.println("Heterogeneuous List Sort: "+newHetrogeneousList); */
		
		
	}
}
