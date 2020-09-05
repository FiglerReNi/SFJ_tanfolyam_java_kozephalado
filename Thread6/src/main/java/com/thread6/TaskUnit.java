package com.thread6;

//ilyen osztályt használunk az olyan feladatoknak, amiket több szálon szeretnénk futtatni
public class TaskUnit implements Runnable {

	private int id;
		
	public TaskUnit(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Feladat indult id:" + id);
		try {
			//ide bármilyen konkrét feladatot megadhatunk
			Thread.sleep(300);
		} catch (InterruptedException e) {
			System.out.println("" + e);
		}
		System.out.println("Feladat elkészült id:" + id);

	}

}
