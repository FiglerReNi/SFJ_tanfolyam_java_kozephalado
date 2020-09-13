package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapApplication {

	public static void main(String[] args) {
		
		/*
		 * Map<String, Integer> tesztMap = new HashMap<>();
		 * Ez is jó megoldás lenne, de az a szokás, hogy az interfacet adjuk meg a bal oldalon.
		 * Újrafelhasználható lesz a kód, nyitva hagyjuk a lehetõséget.
		 * Ha ez egy osztályomban van és valaki azt kiterjeszti tud neki másfajta map-hez tartozó adattípust adni
		 */
		Map<String, Integer> tesztMap = new HashMap<>();
		//elem hozzáadás
		tesztMap.put("FReni", 25);
		tesztMap.put("Ancsa", 20);
		tesztMap.put("Teréz", 22);
		//kiiratás
		System.out.println(tesztMap);
		//keresés key alapján
		System.out.println(tesztMap.get("Teréz"));
		//törlés - a remove egy függvény, visszaadja az értékét annak amit kitörölt
		System.out.println(tesztMap.remove("Teréz"));
		System.out.println(tesztMap);
		//végig menni a listán iterátorral tudunk
		Iterator it = tesztMap.entrySet().iterator();
		while(it.hasNext()) {
			//kasztolás másik típusba, ez minden map egységnek az adattípusa
			Map.Entry pair = (Map.Entry) it.next();			
			System.out.println(pair.getKey() + " " + pair.getValue());
			//saját adattípusba is át tudom menteni ülön a key-t és külön a value-t
			String key = (String) pair.getKey();
			Integer value = (Integer) pair.getValue();	
			System.out.println(key + " " + value);
			if(key.equals("FReni")) {
				//törlés
				it.remove();
			}
		}
		System.out.println(tesztMap);
		
		Map<String, Integer> tesztMap1 = new LinkedHashMap<>();
		//elem hozzáadás
		tesztMap1.put("FReni", 25);
		tesztMap1.put("Ancsa", 20);
		tesztMap1.put("Teréz", 22);
		//kiiratás
		System.out.println(tesztMap1);
	}
}
