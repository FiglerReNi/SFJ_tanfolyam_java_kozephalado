package hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class HashSetApplication {
	
	public static void main(String[] args) {
	String[] tömb = {"FReni", "Ancsa", "Kati", "Teréz", "Ancsa"};
	
	//tömbbõl lista
	List<String> list1 = Arrays.asList(tömb);
	System.out.println(list1);
	
	//listát bele lehet tenni a setbe
	Set<String> set = new HashSet<>(list1);
	System.out.println(set);
	//nem teszi bele, ha duplikálódna
	set.add("FReni");
	System.out.println(set);
	
	//ha fontos az eredeti lista sorrendje
	Set<String> set1 = new LinkedHashSet<>(list1);
	System.out.println(set1);
	}
}
