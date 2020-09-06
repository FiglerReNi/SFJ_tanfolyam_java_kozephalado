package lambdathread;

public class Program {

	public void letsDoThis(int number, Morog morog) {
		morog.morgas(number);
	}
	
	//Lambda - this kivezetve nem statikus k�rnyezetben pr�b�lva
	public void nemStatikusLambdaThis() {
		letsDoThis(2, (count) -> {
			System.out.println("A �rt�ke: " + count);
			//A lambda a thist a k�ls� k�rnyezet�re vonatkoztatja.
			System.out.println(this);
		});
	}
	
	public String toString() {
		return "K�ls� referencia";
		
	}
}
