package lambdathread;

public class Program {

	public void letsDoThis(int number, Morog morog) {
		morog.morgas(number);
	}
	
	//Lambda - this kivezetve nem statikus környezetben próbálva
	public void nemStatikusLambdaThis() {
		letsDoThis(2, (count) -> {
			System.out.println("A értéke: " + count);
			//A lambda a thist a külsõ környezetére vonatkoztatja.
			System.out.println(this);
		});
	}
	
	public String toString() {
		return "Külsõ referencia";
		
	}
}
