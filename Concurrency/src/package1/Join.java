package package1;

class ThreadB extends Thread {

    @Override
    public void run() {

	for (int i = 0; i < 10; i++) {

	    System.out.println(Thread.currentThread().getName() + " is running, i = " + i);

	    try {
		Thread.sleep(500);
	    } catch (InterruptedException e) {

		e.printStackTrace();
	    }

	}

    }
    
}
    
class MyThreads extends Thread {

    @Override
    public void run() {	

	Thread t0 = new ThreadB();
	t0.setName("Fox");
	t0.start();
	
	Thread t1 = new ThreadB();
	t1.setName("Bear");
	t1.start();
	
	try {
	    t0.join();
	    t1.join();
	} catch (InterruptedException e) {	    
	    e.printStackTrace();
	}
	
	System.out.println("Fox and Bear are done.");
	

    }
}    

public class Join { 

    public static void main(String[] args) throws InterruptedException {
	
	Thread a = new MyThreads();	
	
	a.start();
	
	a.join();	
	
	System.out.println("Main thread is also done");
	
    }

}
