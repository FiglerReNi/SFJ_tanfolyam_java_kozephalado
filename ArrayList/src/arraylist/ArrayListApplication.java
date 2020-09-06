package arraylist;

import java.util.ArrayList;
import java.util.Collections;


public class ArrayListApplication {
	
	public static void main(String[] args) {
		
		//�SSZETETT ADATT�PUS �TAD�SA
		ArrayList<Person> people = new ArrayList<>();
		
		people.add(new Person(21, "FReni"));
		people.add(new Person(17, "Ancsa"));
		people.add(new Person(28, "Tomi"));
		people.add(new Person(13, "Ferenc"));
		
		ArrayList<Student> students = new ArrayList<>();
		
		students.add(new Student(21, "FReni"));
		students.add(new Student(17, "Ancsa"));
		students.add(new Student(28, "Tomi"));
		students.add(new Student(13, "Ferenc"));
			
		ArrayList<Worker> workers = new ArrayList<>();
		
		workers.add(new Worker(21, "FReni"));
		workers.add(new Worker(17, "Ancsa"));
		workers.add(new Worker(28, "Tomi"));
		workers.add(new Worker(13, "Ferenc"));
		
		//ARRAYLIST L�TREHOZ�S
		ArrayList<String> words = new ArrayList<>();
		
		words.add("FReni");
		words.add("Ancsa");
		words.add("Tomi");
		words.add("Ferenc");
		
		ArrayList<Integer> numbers = new ArrayList<>();
		
		numbers.add(1);
		numbers.add(10);
		numbers.add(23);
		numbers.add(2);
		
		//SORBA RENDEZ�S
		//�sszetett adatt�pus sorbarendez�s
		//1. m�dszer
		//ehhez kell hogy a class-ban meghat�rozzuk a sorbarendez�st (Comparable interface kiterjeszt�se).
		//ezzel a m�dszerrel csak egyf�le sorbarendez�st tudunk defini�lni/class
		Collections.sort(people);
		//2.m�dszer
		//a Student-ben l�tre kell hozni egy comparatort, mert a sort() ezt v�rja
		//statikus a nameComparator ez�rt nem kell p�ld�nyos�t�s
		students.sort(Student.nameComparator);
		students.sort(Student.ageComparator);
		//lambda egyszer�s�t�ssel is meg lehet oldani, ekkor nem kell az oszt�lyban a comparatort l�trehozni
		workers.sort((w1, w2) -> w1.getAge()-w2.getAge());
		//egyszer� sorbarendez�s
		Collections.sort(numbers);
		Collections.sort(words);
		
		//LIST�Z�S
		//Lista kiirat�sa
		//1. m�dszer
		for (int i = 0; i < words.size(); i++) {
			System.out.println(words.get(i));
		}
		
		//mivel objektumok vannak benne, ez�rt �gy az azonos�t�j�t fogjuk ki�rni, ha nem �rjuk fel�l a toStringet
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
		
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i));
		}
		
		for (int i = 0; i < workers.size(); i++) {
			System.out.println(workers.get(i));
		}
		
		//2. m�dszer
		for (String word : words) {
			System.out.println(word);
		}
		//3.m�dszer lambda
		words.forEach(word -> System.out.println(word));
		workers.forEach(worker ->  System.out.println(worker.getName()));
		//4.m�dszer, ha j� egy sorban a be�p�tett
		System.out.println(words);
		System.out.println(numbers);
				
	}

}
