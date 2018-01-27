package package1;

class T1 implements Runnable {

	@Override
	public void run() {
	    System.out.println("I am running from Runnable");	    
	}
	
}

class T2 extends Thread {

    @Override
    public void run() {	
	
	try {
	    T2.sleep(3000);
	    
	    System.out.println("I am running from Thread");
	    
	} catch (InterruptedException e) {
	    
	    System.err.println("Why did you interrupt me ?");
	}
	
	
    }  
    
    
}

public class Interrupt {  
    

    public static void main(String[] args) {	
	
	T1 m = new T1();
	
	Thread t1 = new Thread(m);
	
	Thread t2 = new T2(); 
	
	t1.start();
	t2.start();
	
	t2.interrupt();
	
	if (t2.isInterrupted()) {
	    System.out.println("t2 is interrupted");
	};
	
	

    }

}
