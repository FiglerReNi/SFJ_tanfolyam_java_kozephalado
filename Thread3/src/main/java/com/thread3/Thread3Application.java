package com.thread3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Thread3Application {

	//ha nem adom meg az alap értéke: 0. Static-nak kell lennie, hogy a main lássa, mivel az is static
	private static int count;
	
	private static synchronized void addToCount() {
		count++;
	}
	
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Thread3Application.class, args);
		
		//szál létrehozása anonim osztállyal is lehetséges
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 12000; i++) {
					//Nem engedjük, hogy a szál hozzáférjen közvetlenül a változóhoz
					addToCount();
					//count++;
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 12000; i++) {
					//Nem engedjük, hogy a szál hozzáférjen közvetlenül a változóhoz
					addToCount();
					//count++
				}
			}
		});
		
		//elindítjuk a szálakat
		t1.start();
		t2.start();
		//szálak bevárása, hogy lássuk a count értékét
		t1.join();
		t2.join();
		
		System.out.print(count);
	}
}
/*
 * Azt várnánk, hogy mire mind a két szál végez a count értéke 24000 lesz, mivel mindkét szál 12000X fut le és növeli a count értékét.
 * Első esetben azonban nullát látunk 
 * 	---> oka: a szálak létrehozása energiaigényes, mire elindítja őket a JVM addigra a System.out.print(count) sort már rég kiírta a main szál, 
 * 			  és akkor még nulla volt az értéke.
 *  ---> megoldás: be tudjuk várni a szál futását a szálak join parancsával. Addig nem fut tovább a main szál amíg nem végez a t1 és t2.
 *  Második esetben a join-t használva viszont mindig más értéket kapunk és nem érjük el a 24000 -t.
 * 	---> oka: a count++ 3 lépésből álló folyamat, és mivel nem atomic, akkor is megtörténik ha hibás lesz valamelyik lépés:
 * 				count = count + 1
 * 				1. lépés: kivesszük count értékét : x
 * 				2. lépés: hozzáadunk 1-et: x+1
 * 				3. lépés: elmentjük, ez lett az új érték
 * 			  előfordulhat, hogy a két szál ugyanazon az értéken kezd el dolgozni, hiszen egymás mellett futnak, x-et kiveszik és x+1-et mentik el
 * 			  mindketten. Pl 0-t vesznek ki lefut mind2, count-nak 2-nek kellene lennie 2 lefutás után de csak egy lesz, mert ezt menti el min2 szál
 *	---> megoldás:  Az objektumot, vagy az objektumnak egy részét le tudjuk zárni, lockolni
 *					Nem engedjük, hogy a szál hozzáférjen közvetlenül a változóhoz, hanem metóduson keresztül csináljuk.
 *					A metódust már synchronized-á tudjuk tenni, Vagyis a metódus atomic-á válik, egyben fog lefutni. Ha meghívja az egyik szál
 *					teljesen le kell futnia, és csak ha végzett akkor dolgozhat rajta a másik szál. Amíg tart az egyik folyamat lezárjuk a másik
 *					elől a metódust. Így a két szál nem tud egyszerre módosítani count értékén, illetve nem tudja ugyanazt az értéket kivenni.
 *					A chachelésre itt nem kell figyelni, mert a változó automatikusan Volatile lesz.
 */
 