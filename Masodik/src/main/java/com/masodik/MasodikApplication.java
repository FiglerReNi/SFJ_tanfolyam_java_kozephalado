package com.masodik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MasodikApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasodikApplication.class, args);
	
		//az alkalmazásunk kívülről tud fogadni paramétert, ha azt kapja, hogy new akkor az új 4 paraméteres megoldást használja, ha nem ezt
		//kapja akkor a régit.
		String init = "";
		try {
			init = args[0];
		}catch(Exception e) {
			System.out.println("REGI szerint fut");
		}
		
		Teszt teszt = new Teszt();
		
		if(init.equals("new")) {
			teszt.eredeti("", "", 1, true);
		}else {
			teszt.eredeti("", "", 1);
		}
		
		
	}
	
	public void newer() {
		Teszt tesztNew = new Teszt();
		tesztNew.eredeti("", "", 1, true);
		
	}

}
