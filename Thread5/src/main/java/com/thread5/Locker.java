package com.thread5;

import java.util.ArrayList;

public class Locker {
	
	public ArrayList<Integer> numbers1 = new ArrayList<>();
	public ArrayList<Integer> numbers2 = new ArrayList<>();
	
	//egyszerre csak egy szál dolgozhsson rajta
	public synchronized void doorOne() throws InterruptedException {
		numbers1.add(10);
		Thread.sleep(1);
	}
	
	//egyszerre csak egy szál dolgozhsson rajta
	public synchronized void doorTwo() throws InterruptedException {
		numbers2.add(10);
		Thread.sleep(1);
	}
	
	public void doWork() throws InterruptedException {
		for (int i = 0; i < 2000; i++) {
			doorOne();
			doorTwo();
		}
	}
}
