package arraylist;

import java.util.ArrayList;
import java.util.Collections;


public class ArrayListApplication {
	
	public static void main(String[] args) {
		
		//ÖSSZETETT ADATTÍPUS ÁTADÁSA
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
		
		//ARRAYLIST LÉTREHOZÁS
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
		
		//SORBA RENDEZÉS
		//összetett adattípus sorbarendezés
		//1. módszer
		//ehhez kell hogy a class-ban meghatározzuk a sorbarendezést (Comparable interface kiterjesztése).
		//ezzel a módszerrel csak egyféle sorbarendezést tudunk definiálni/class
		Collections.sort(people);
		//2.módszer
		//a Student-ben létre kell hozni egy comparatort, mert a sort() ezt várja
		//statikus a nameComparator ezért nem kell példányosítás
		students.sort(Student.nameComparator);
		students.sort(Student.ageComparator);
		//lambda egyszerûsítéssel is meg lehet oldani, ekkor nem kell az osztályban a comparatort létrehozni
		workers.sort((w1, w2) -> w1.getAge()-w2.getAge());
		//egyszerû sorbarendezés
		Collections.sort(numbers);
		Collections.sort(words);
		
		//LISTÁZÁS
		//Lista kiiratása
		//1. módszer
		for (int i = 0; i < words.size(); i++) {
			System.out.println(words.get(i));
		}
		
		//mivel objektumok vannak benne, ezért így az azonosítóját fogjuk kiírni, ha nem írjuk felül a toStringet
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
		
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i));
		}
		
		for (int i = 0; i < workers.size(); i++) {
			System.out.println(workers.get(i));
		}
		
		//2. módszer
		for (String word : words) {
			System.out.println(word);
		}
		//3.módszer lambda
		words.forEach(word -> System.out.println(word));
		workers.forEach(worker ->  System.out.println(worker.getName()));
		//4.módszer, ha jó egy sorban a beépített
		System.out.println(words);
		System.out.println(numbers);
				
	}

}
