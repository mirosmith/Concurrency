package package1;

import java.util.Random;

/**
 * 
 * Main thread (Boss) waits until thread (Employee) finish his job. 
 * If job lasts more than 10 seconds, Boss will interrupt. 
 */
public class JoinExample {

    public static void showMessage(String text) {
	System.out.println(Thread.currentThread().getName() + " says: " + text);
    }

    public static class Loop implements Runnable {	

	private String[] words = { "House", "Electricity", "Toilet", "Heating", "Decoration" };	
	
	@Override
	public void run() {
	    
	    Random randomTime = new Random();
	    int time = 0;
	    
	    try {
		
		for (String s : words) {
		    
		    time = randomTime.nextInt(3200);
		    
		    showMessage("working on " + s);
		    
		    Thread.sleep(time);
		    
		    System.out.println(" .. done " + " (" + (double)time/1000 + " sec)");
		    
		    

		}
		showMessage("I am finished");

	    } catch (InterruptedException e) {
		showMessage("I didnt finish my job");
	    }

	}	
	

    }    
    

    public static void main(String[] args) throws InterruptedException {	
	
	Thread.currentThread().setName("Boss"); 
	
	showMessage("I will wait until you finish");
	Long begin = System.currentTimeMillis();
	

	Thread t = new Thread(new Loop());
	t.setName("Employee");

	t.start();	

	Long time;

	while (t.isAlive()) {

	    time = System.currentTimeMillis() - begin;

	    if ((time > 10000) && t.isAlive()) {
		showMessage("I am tired of waiting!");
		t.interrupt();
		t.join();
	    }

	}
	showMessage("Go home.");

    }

}
