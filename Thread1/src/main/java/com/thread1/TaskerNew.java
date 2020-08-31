package com.thread1;

/*Thread létrehozás 2. módszer*/
public class TaskerNew implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Mellékszál: " + i);
			//Ennyi ideig áll minden egyes alkalommal amikor ide belefut 1000 = 1sec
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}		
	}
}
