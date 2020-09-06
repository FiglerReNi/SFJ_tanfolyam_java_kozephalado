package arraylist;

//ha tudom, hogy sz�ks�g lesz sorbarendez�sre 
public class Person implements Comparable {

	private int age;
	private String name;
	
	
	public Person() {}

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	//Ezzel a m�dszerrel csak egyf�le sorbarendez�st tudunk megadni
	//Ezt az interface miatt kell, itt adjuk meg a sorbarendez�shez sz�ks�ges dolgokat
	//K�pess� tessz�k az objektumot, hogy �sszehasonl�that legyen egy bej�v�vel
	/*H�rom f�le sz�mot adhat vissza: 0, kisebb mint 0, nagyobb mint nulla
	 * A nulla azt jelenti, hogy a be�rkez� objektum egyenl� ezzel, vagyis amivel vizsg�ltatjuk*/
	@Override
	public int compareTo(Object o) {
		//kiveszem az �tadott objektum kor�t
		int compareAge = ((Person) o).getAge();
		//visszaadjuk a kett� k�l�nbs�g�t
		//ha ford�tva vonom ki megfordul a cs�kken�/n�vekv�
		return this.age - compareAge;
	}
	
	
	
}
