package com.thread5;

import java.util.ArrayList;

public class LockerFast {
	
	//a synchronized-re megoldás, hogy ne az egész objektum legyen lockolva és ha egyik szál dolgozik a doorOne-on a másik még dolgozhasson
	//a doorTwo-n
	Object lockOne = new Object();
	Object lockTwo = new Object();
	
	public ArrayList<Integer> numbers1 = new ArrayList<>();
	public ArrayList<Integer> numbers2 = new ArrayList<>();
	
	//egyszerre csak egy szál dolgozhsson rajta
	public void doorOne() throws InterruptedException {
		synchronized (lockOne) {
			numbers1.add(10);
			Thread.sleep(1);
		}		
	}
	
	//egyszerre csak egy szál dolgozhsson rajta
	public void doorTwo() throws InterruptedException {
		synchronized (lockTwo) {
			numbers2.add(10);
			Thread.sleep(1);
		}		
	}
	
	public void doWork() throws InterruptedException {
		for (int i = 0; i < 2000; i++) {
			doorOne();
			doorTwo();
		}
	}
}
