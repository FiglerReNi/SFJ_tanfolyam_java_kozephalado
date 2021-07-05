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
		
		//szál létrehozása lambdával is lehetséges
		/*Runnable run = () -> {
			for (int i = 0; i < 12000; i++) {
				//Nem engedjük, hogy a szál hozzáférjen közvetlenül a változóhoz
				addToCount();
				//count++
			}
		};		
		Thread t2 = new Thread(run);*/
		
		//még egyszerübben lambdával
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 12000; i++) {
				//Nem engedjük, hogy a szál hozzáférjen közvetlenül a változóhoz
				addToCount();
				//count++
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
