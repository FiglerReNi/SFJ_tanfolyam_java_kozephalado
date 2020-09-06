package lambda;

public class Lambda {
	
	public static void main(String[] args) {
				
		//2. Anonim osztállyal, mivel a kutyát csak azért hoztuk létre az elõzõ projektben, hogy át tudjunk adni valamit, de amúgy nincs rá szükségünk
		/*Program program = new Program();
		program.doSomething(new Morog() {
			@Override
			public void morgas(int count) {
				System.out.println("Tudok morogni");
			}			
		});*/

		
		//3. Lambda expression: 
		//ugyanaz a neve mint a függvénynek amit overrideolunk, és az adattípusa az interface
		/*Morog morgas = (int count) -> System.out.println("Tudok morogni " + count);
		Program program = new Program();
		program.doSomething(morgas);*/
		
		//még egyszerûbben:
		Program program = new Program();
		program.doSomething((int count) -> System.out.println("Tudok morogni " + count));
	}
}
