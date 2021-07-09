package com.masodik;

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
