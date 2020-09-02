package com.thread2;

public class Tasker extends Thread{
	/*A JVM cachelheti ezt az osztályváltozót, ezért a main függvényből egyszerüen meghívva a kill()-t nem lesz mindig jó megoldás. 
	 *Hiszen mindig true marad az érték. A cache oka, hogy a JVM megvizsgálja az osztály és azt lája, hogy osztályon belül semmi nem
	 *állítja az értékét a runner-nek. Ugyan a kill-ben igen, de azt nem hívja meg itt semmi. És mivel ez egy szál nem feltételezi,
	 *hogy máshonnan állítva lesz ez az érték. Ezért cacheli. 
	 *A volatile meggátolja a cache-t*/
	private volatile boolean runner = true;
	
	public void run() {
		while(runner) {
			System.out.println("Futok");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
	
	public void kill() {
		this.runner = false;
	}
}
