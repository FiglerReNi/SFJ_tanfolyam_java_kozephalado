package com.masodik;

/*Példa feladat, van egy metódus, amit bővíteni akarunk egy bejövő paraméterrel, de úgy, hogy az eredetihez nem nyúlhatunk, mert egy csomó 
 *helyen használja az alkalmazásunk.
 *Ha csak simán beírok egy új paramétert akkor hiba lesz minden olyan helyen ahol csak 3 paraméterrel használjuk a kódot.
 *Rossz Megoldások: 
 *	1. Új függvényt csinálunk, átmásoljuk a kódot és megcsináljuk a szükséges módosítást --> DUPLIKÁCIÓ
 *	2. Mindenhol ahol az eredeti használatban van hozzáadom az új paramétert --> Sok munka és nem nyúlunk más kódjához, ha nem muszáj
 *Jó Megoldás:
 *	Készítünk egy új függvényt ugyanazzal a névvel, de négy paraméterrel
 *  A teljes kaluláció és kód az újban lesz csak benne (négy paraméteres)
 *  A régi függvényt átirányítom az újhoz
 *	
 *		 */
public class Teszt {
	//Find Usage: jobb klikk -> References -> Project
	//overloaded functionok: ugyanaz a nevük, de különböző paramétert fogadnak
	public String eredeti(String input1, String input2, Integer input3) {
		//átirányítom az újra, az itt nem létező paraméter helyére false-t írok ha pl boolean, vagy null-t ha String és a másik oldalon tudom,
		//hogy ha ez az érték jön akkor az eredeti, régi kód szerint kell kezelnem
		System.out.println("REGI");
		return eredeti(input1, input2, input3, false);	
	}
	
	public String eredeti(String input1, String input2, Integer input3, boolean input4) {
		//Ide jön minden kód, kalkuláció
		System.out.println(input4 ? "ÚJ" : "REGI");
		return input1 + input2 + input3;		
	}
	
}
