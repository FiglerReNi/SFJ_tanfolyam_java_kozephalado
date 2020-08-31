package com.thread1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Thread1Application {

	public static void main(String[] args) {
		SpringApplication.run(Thread1Application.class, args);
		//extends Thread
		//új szál indítása
		//Tasker run1 = new Tasker();
		//run1.start();
		//Mégegyet indítunk, párhuzamosan futnak egymás mellett
		//Tasker run2 = new Tasker();
		//run2.start();
		
		//implements Runnable
		Thread t1 = new Thread(new TaskerNew());
		Thread t2 = new Thread(new TaskerNew());
		t1.start();
		t2.start();
		
	}

}
