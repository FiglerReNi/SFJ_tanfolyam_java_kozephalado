package linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinedListApplication {
	
	public static void main(String[] args) {
		
		//LINKEDLIST 
		LinkedList<String> list1 = new LinkedList<>();
		//HOZZAADAS
		list1.add("Ancsa");
		list1.add("FReni");
		//KIIRATAS
		//1.módszer
		System.out.println(list1);
		//2.módszer
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		//3.módszer
		for (String list : list1) {
			System.out.println(list);
		}
		//4.módszer lambda
		list1.forEach(list -> System.out.println(list));
		//5. módszer iteratot
		//kiszedjük egy külön típusba
		Iterator<String> it = list1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//TORLES
		Iterator<String> it1 = list1.iterator();
		while(it1.hasNext()) {
			String actual = it1.next();
			if(actual.equals("FReni")) {
				it1.remove();
			}			
		}
		System.out.println(list1);
	}
}
