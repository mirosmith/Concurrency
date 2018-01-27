package package1;

class OneThread implements Runnable {

	@Override
	public void run() {
	    System.out.println("I am running from Runnable");	    
	}
	
}

class TwoThread extends Thread {

    @Override
    public void run() {		
	
	System.out.println("I am running from Thread");	
    }  
    
    
}

public class CreationThread {  
    

    public static void main(String[] args) {
	
	OneThread m = new OneThread();
	
	Thread t1 = new Thread(m);
	
	Thread t2 = new TwoThread(); 
	
	Thread t3 = new Thread(new Runnable() {
	    
	    @Override
	    public void run() {
		
		System.out.println("I am t3 running from annonymous");
		
	    }
	});
	
	Thread t4 = new Thread( () -> System.out.println("I am running using Lambda"));
	
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	

    }

}
