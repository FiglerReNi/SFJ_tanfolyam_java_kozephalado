package com.elso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElsoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ElsoApplication.class, args);
		//Fájlba írás
		Writer w = new Writer();
		w.writeSingleChar();
		w.writeMoreChar();
		w.bufferedWriter();
		
		//Fájlból olvasás
		Reader r = new Reader();
		r.readSingleChar();
		r.readMoreChar();
		r.bufferedReader();
		
		//Adatáramlás
		//KI
		System.out.println("FReni");
		//BE - Bekér konzolról egy adatot, amit el tudunk menteni. Bár karaktert írunk be int-et ad vissza, mert a betű ASCII kódját menti el.
		//egy karaktert tud beolvasni
		int adat = System.in.read();
		System.out.println(adat);
		//kasztolással karakterráé alakítjuk
		System.out.println((char)adat);
	    //ERROR
		System.err.println("Hiba");	
		
		Bat denever = new Bat();
		process(denever);
	}

	
	public static void process(FlyAnimal animal) {
		animal.ascend();
	}
}
