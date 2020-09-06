package arraylist;

import java.util.Comparator;

public class Student {
	
	private int age;
	private String name;
	
	public Student() {}
	
	public Student(int age, String name) {
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
		return "Student [age=" + age + ", name=" + name + "]";
	}
	
	//ezt tudjuk használni a sort()-ban az összehasonlításhoz
	public static Comparator<Student> nameComparator = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			String studentName1 = o1.getName();
			String studentName2 = o2.getName();
			return studentName1.compareTo(studentName2);
		}		
	};
	
	//int-nél két módszer
	// 1.módszer
	/*public static Comparator<Student> ageComparator = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			Integer studentName1 = o1.getAge();
			Integer studentName2 = o2.getAge();
			return studentName1.compareTo(studentName2);
		}		
	};*/
	//2.módszer
	public static Comparator<Student> ageComparator = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			int studentAge1 = o1.getAge();
			int studentAge2 = o2.getAge();
			return Integer.compare(studentAge1, studentAge2);
		}		
	};

}
