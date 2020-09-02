package com.thread2;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Thread2Application {

	public static void main(String[] args) {
		//elindul a main szál
		SpringApplication.run(Thread2Application.class, args);
		//elindítjuk a main szálból a t1 szálat, innentől párhuzamosan futnak
		Tasker t1 = new Tasker();
		t1.start();
		//a main szál a felhasználótól kér be adatot, és megáll amíg nem kap egy entert
		System.out.println("Nyomj entert a leállításhoz");
		//Beolvassuk a felhasználó által beírt dolgokat
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		//Enter után tovább megy a main szál
		//Main szálból leállítjuk a t1 szálat
		t1.kill();
	}

}
