package com.thread5;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Thread5Application {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Thread5Application.class, args);
		//1. példa egy szálon futtatjuk
		 /* Le lehet mérni, hogy egy alkalmazás meddig fut 
		//ez a kezdőpont
		long start = System.currentTimeMillis();
		//elvégeztetjük a doWork metódust és ennek az ideje érdekel, egy szálon feltöltetjük mindkét listát, minden feltöltésnél pause 1 milisec,
		//így a kettő összesen 1000 milisec pause + futás, tehát 1sec-nél több idő alatt fog lefutni
		Locker locker = new Locker();
		try {
			locker.doWork();
		} catch (InterruptedException e) {
			Logger.getLogger(Thread5Application.class.getName()).log(Level.SEVERE, null, e);
		}
		//ez a végpont
		long end = System.currentTimeMillis();
		//kiírjuk a kettő között eltelt időt
		System.out.print(end-start);*/
		
		//2.példa Több szálon futtatjuk: 3 szál lesz: main, t1 és t2 --Lassú futási idő
		/*long start = System.currentTimeMillis();
		Locker locker = new Locker();
	    Thread t1 = new Thread(new Runnable() {
	    	public void run() {
	    		try {
					locker.doWork();
				} catch (InterruptedException e) {
					Logger.getLogger(Thread5Application.class.getName()).log(Level.SEVERE, null, e);
				}
	    	}
	    });
	    
	    Thread t2 = new Thread(new Runnable() {
	    	public void run() {
	    		try {
					locker.doWork();
				} catch (InterruptedException e) {
					Logger.getLogger(Thread5Application.class.getName()).log(Level.SEVERE, null, e);
				}
	    	}
	    });
	    t1.start();
	    t2.start();
	    //bevárják egymást a szálak amíg végez mindegyik
	    t1.join();
	    t2.join();
	    long end = System.currentTimeMillis();
	    System.out.println(locker.numbers1.size() + " " + locker.numbers2.size());
	    System.out.println(end-start);*/
	    
	    //3.példa Több szálon futtatjuk: 3 szál lesz: main, t1 és t2 --Gyorsabb futási idő
		long start = System.currentTimeMillis();
		LockerFast locker = new LockerFast();
	    Thread t1 = new Thread(new Runnable() {
	    	public void run() {
	    		try {
					locker.doWork();
				} catch (InterruptedException e) {
					Logger.getLogger(Thread5Application.class.getName()).log(Level.SEVERE, null, e);
				}
	    	}
	    });
	    
	    Thread t2 = new Thread(new Runnable() {
	    	public void run() {
	    		try {
					locker.doWork();
				} catch (InterruptedException e) {
					Logger.getLogger(Thread5Application.class.getName()).log(Level.SEVERE, null, e);
				}
	    	}
	    });
	    t1.start();
	    t2.start();
	    //bevárják egymást a szálak amíg végez mindegyik
	    t1.join();
	    t2.join();
	    long end = System.currentTimeMillis();
	    System.out.println(locker.numbers1.size() + " " + locker.numbers2.size());
	    System.out.println(end-start);
	}

}

/*feltöltés után a listák mérete (4000-4000-et várnánk, mert két szálon 2X fut le a doWork, de ez a synchronize nélkül kevesebb lesz, de ha
a két metódust (doorOne és doorTwo) synchronized - al látjuk el már jó ---> így viszont sokkal sokkal lassabban fut le)
Elindul két szál, mind2 külön-külön meghívja a doWork metódust.
A doWork pedig meghívja a doorOne és doorTwo metódusokat
A szálak ugyanabba a listába pakolnak
Amikor synchronized-ot használunk maga az objektum lockolódik
--> Ha az első szál használja a doorOne metódust akkor a doorTwo-t sem használhatja a másik szál nem csak a doorOne-t, ezért jóval hosszabb
a futás idő.
Megoldás: A metóduson belül a kódot tesszük synchronized-é.
*/


