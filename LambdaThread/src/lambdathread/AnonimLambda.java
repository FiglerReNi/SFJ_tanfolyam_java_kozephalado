package lambdathread;

public class AnonimLambda {
	

	public static void main(String[] args) throws InterruptedException {
		
		//Formai különbség anonim és lambda között
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Futok mint anonim");
			}
		});
						
		Thread t2 = new Thread(() -> {
			System.out.println("Futok mint lambda");
		});
		
		t1.start();
		t2.start();
		
		//Mûködésben	
		//Anonim
		Program program = new Program();
		program.letsDoThis(1, new Morog() {
			@Override
			public void morgas(int count) {
				System.out.println("A értéke: " + count);
				//this saját magára mutat, ez egy új példány ami létrejön, objetum azonosítójét fogja kiírni
				System.out.println(this);
			}
			
			//ezt bármikor felülírhatjuk, és így a this nem az objektum azonosítóját fogja kiírni, hanem amit itt megadunk
			@Override 
			public String toString() {
				return "Belsõ referencia";
			}
		});
		
		//Lambda - this statikus környezetben próbálva
		program.letsDoThis(2, (count) -> {
			System.out.println("A értéke: " + count);
			//mivel a this itt nem saját magára mutat, mivel a lambda nem tekinti magát objetumnak, ezért static környezetben
			//ez itt nem érhetõ el, hibát jelez. Statikus környezetben nem hívhatunk meg nem statikus dolgokat.
			//A lambda a thist a külsõ környezetére vonatkoztatja.
			//System.out.println(this);
		});
		
		//Lambda - this kivezetve nem statikus környezetben próbálva
		program.nemStatikusLambdaThis();
	}
}
