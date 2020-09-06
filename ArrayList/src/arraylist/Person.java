package arraylist;

//ha tudom, hogy szükség lesz sorbarendezésre 
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
	
	//Ezzel a módszerrel csak egyféle sorbarendezést tudunk megadni
	//Ezt az interface miatt kell, itt adjuk meg a sorbarendezéshez szükséges dolgokat
	//Képessé tesszük az objektumot, hogy összehasonlíthat legyen egy bejövõvel
	/*Három féle számot adhat vissza: 0, kisebb mint 0, nagyobb mint nulla
	 * A nulla azt jelenti, hogy a beérkezõ objektum egyenlõ ezzel, vagyis amivel vizsgáltatjuk*/
	@Override
	public int compareTo(Object o) {
		//kiveszem az átadott objektum korát
		int compareAge = ((Person) o).getAge();
		//visszaadjuk a kettõ különbségét
		//ha fordítva vonom ki megfordul a csökkenõ/növekvõ
		return this.age - compareAge;
	}
	
	
	
}
