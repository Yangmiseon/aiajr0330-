package Set;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
	
		TreeMap<Integer, String> tMap = new TreeMap<Integer, String>();
		//Map<Integer, String> tMap = new TreeMap<>();
		
		tMap.put(1, "data1");
		tMap.put(3, "data2");
		tMap.put(5, "data3");
		tMap.put(4, "data4");
		tMap.put(2, "data5");
		
		//map - > collection
		//Map m>Set
		NavigableSet<Integer> navi = tMap.navigableKeySet(); //set을 구현하는 클래스
		
		//set이 있으니 Iterator 구할수있음
		Iterator<Integer> itr = navi.iterator();
		while(itr.hasNext()) {//key의 집합
		//	System.out.println(itr.next());
			System.out.println(tMap.get(itr.next()));
		}
		
		itr = navi.descendingIterator();
		
		while(itr.hasNext()) {
			System.out.println(tMap.get(itr.next()));
		}
		

	}

}
