package lambda;

public class Lambda {
	
	public static void main(String[] args) {
				
		//2. Anonim oszt�llyal, mivel a kuty�t csak az�rt hoztuk l�tre az el�z� projektben, hogy �t tudjunk adni valamit, de am�gy nincs r� sz�ks�g�nk
		/*Program program = new Program();
		program.doSomething(new Morog() {
			@Override
			public void morgas(int count) {
				System.out.println("Tudok morogni");
			}			
		});*/

		
		//3. Lambda expression: 
		//ugyanaz a neve mint a f�ggv�nynek amit overrideolunk, �s az adatt�pusa az interface
		/*Morog morgas = (int count) -> System.out.println("Tudok morogni " + count);
		Program program = new Program();
		program.doSomething(morgas);*/
		
		//m�g egyszer�bben:
		Program program = new Program();
		program.doSomething((int count) -> System.out.println("Tudok morogni " + count));
	}
}
