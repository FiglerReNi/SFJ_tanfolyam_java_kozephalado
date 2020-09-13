package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapApplication {

	public static void main(String[] args) {
		
		/*
		 * Map<String, Integer> tesztMap = new HashMap<>();
		 * Ez is j� megold�s lenne, de az a szok�s, hogy az interfacet adjuk meg a bal oldalon.
		 * �jrafelhaszn�lhat� lesz a k�d, nyitva hagyjuk a lehet�s�get.
		 * Ha ez egy oszt�lyomban van �s valaki azt kiterjeszti tud neki m�sfajta map-hez tartoz� adatt�pust adni
		 */
		Map<String, Integer> tesztMap = new HashMap<>();
		//elem hozz�ad�s
		tesztMap.put("FReni", 25);
		tesztMap.put("Ancsa", 20);
		tesztMap.put("Ter�z", 22);
		//kiirat�s
		System.out.println(tesztMap);
		//keres�s key alapj�n
		System.out.println(tesztMap.get("Ter�z"));
		//t�rl�s - a remove egy f�ggv�ny, visszaadja az �rt�k�t annak amit kit�r�lt
		System.out.println(tesztMap.remove("Ter�z"));
		System.out.println(tesztMap);
		//v�gig menni a list�n iter�torral tudunk
		Iterator it = tesztMap.entrySet().iterator();
		while(it.hasNext()) {
			//kasztol�s m�sik t�pusba, ez minden map egys�gnek az adatt�pusa
			Map.Entry pair = (Map.Entry) it.next();			
			System.out.println(pair.getKey() + " " + pair.getValue());
			//saj�t adatt�pusba is �t tudom menteni �l�n a key-t �s k�l�n a value-t
			String key = (String) pair.getKey();
			Integer value = (Integer) pair.getValue();	
			System.out.println(key + " " + value);
			if(key.equals("FReni")) {
				//t�rl�s
				it.remove();
			}
		}
		System.out.println(tesztMap);
		
		Map<String, Integer> tesztMap1 = new LinkedHashMap<>();
		//elem hozz�ad�s
		tesztMap1.put("FReni", 25);
		tesztMap1.put("Ancsa", 20);
		tesztMap1.put("Ter�z", 22);
		//kiirat�s
		System.out.println(tesztMap1);
	}
}
