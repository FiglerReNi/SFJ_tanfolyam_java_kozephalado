package lambda;

public class Lambda {

	public static void main(String[] args) {
		
		//1. Leghosszabb �t
		Program program = new Program();
		Kutya kutya = new Kutya();
		//A kutya �tadhat� a program-nak, mert egy Morog objektumot v�r, �s a kutya implement�lja ezt, teh�t tuti tudja a morg�st.
		program.doSomething(kutya);
		
	}

}
