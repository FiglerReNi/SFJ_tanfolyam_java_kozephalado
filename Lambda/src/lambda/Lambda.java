package lambda;

public class Lambda {

	public static void main(String[] args) {
		
		//1. Leghosszabb út
		Program program = new Program();
		Kutya kutya = new Kutya();
		//A kutya átadható a program-nak, mert egy Morog objektumot vár, és a kutya implementálja ezt, tehát tuti tudja a morgást.
		program.doSomething(kutya);
		
	}

}
