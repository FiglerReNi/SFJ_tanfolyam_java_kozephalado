package com.thread4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Thread4Application {

	//ha nem adom meg az alap értéke: 0.
	private int count;
	
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Thread4Application.class, args);
		//a threadWork metódsut akarjuk elérni, de mivel a main static a threadWork pedig nem, ezért példányostanunk kell az osztályt az eléréshez
		Thread4Application threadClass = new Thread4Application();
	    threadClass.threadWork();
	}

	private void threadWork() throws InterruptedException {
		//szál létrehozása anonim osztállyal is lehetséges
				Thread t1 = new Thread(new Runnable() {
					public void run() {
						for (int i = 0; i < 12000; i++) {
							//count++;
							addToCount();
						}
					}
				});
				
				Thread t2 = new Thread(new Runnable() {
					public void run() {
						for (int i = 0; i < 12000; i++) {
							//count++;
							addToCount();
						}
					}
				});
				
				t1.start();
				t2.start();
				
				t1.join();
				t2.join();
				
				System.out.print(count);
	}
	
	private synchronized void addToCount() {
		count++;
	}
}
