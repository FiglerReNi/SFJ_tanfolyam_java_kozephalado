package lambdathread;

public class AnonimLambda {
	

	public static void main(String[] args) throws InterruptedException {
		
		//Formai k�l�nbs�g anonim �s lambda k�z�tt
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
		
		//M�k�d�sben	
		//Anonim
		Program program = new Program();
		program.letsDoThis(1, new Morog() {
			@Override
			public void morgas(int count) {
				System.out.println("A �rt�ke: " + count);
				//this saj�t mag�ra mutat, ez egy �j p�ld�ny ami l�trej�n, objetum azonos�t�j�t fogja ki�rni
				System.out.println(this);
			}
			
			//ezt b�rmikor fel�l�rhatjuk, �s �gy a this nem az objektum azonos�t�j�t fogja ki�rni, hanem amit itt megadunk
			@Override 
			public String toString() {
				return "Bels� referencia";
			}
		});
		
		//Lambda - this statikus k�rnyezetben pr�b�lva
		program.letsDoThis(2, (count) -> {
			System.out.println("A �rt�ke: " + count);
			//mivel a this itt nem saj�t mag�ra mutat, mivel a lambda nem tekinti mag�t objetumnak, ez�rt static k�rnyezetben
			//ez itt nem �rhet� el, hib�t jelez. Statikus k�rnyezetben nem h�vhatunk meg nem statikus dolgokat.
			//A lambda a thist a k�ls� k�rnyezet�re vonatkoztatja.
			//System.out.println(this);
		});
		
		//Lambda - this kivezetve nem statikus k�rnyezetben pr�b�lva
		program.nemStatikusLambdaThis();
	}
}
