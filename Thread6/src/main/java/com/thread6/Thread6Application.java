package com.thread6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Thread6Application {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Thread6Application.class, args);
		//létrehozok egy "medencét" és megadom, hogy hány szál fér bele maximum. Ezt a számot kivehetem akár egy külső fájlból is és tudom
		//módosítani a kód nélkül, hány szálon fusson le az app
		ExecutorService executor = Executors.newFixedThreadPool(2);
		//5 alkalommal akarom elvégeztetni a feadatot
		for (int i = 1; i <= 5; i++) {
			//átadom a medencének a feladatot, amit 5X akarok elvégezni, és ehhez adok két szálat, az executor osztja ki folyamatosan a feladatot
			//ha végzett az első az id=1 el, a második csinálja az id=2-őt közben, ezért megkapja az id = 3-at stb.
			executor.submit(new TaskUnit(i));
		}
		//miután kiosztottuk az összes feladatot le kell zárni
		executor.shutdown();
		System.out.println("Erre a pontra minden munka ki lett osztva.");
		//megvárjuk, hogy a szálak befejezzék a munkát, de megadhatjuk, hogy maximum meddig várjunk. (Lehet 2nap, 10sec bármi)
		//ezután megy tovább a main szál
		executor.awaitTermination(60, TimeUnit.SECONDS);
		System.out.println("Készen van az összes munka.");
		
	}

}
