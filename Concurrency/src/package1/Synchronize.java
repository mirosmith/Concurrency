package package1;

class Counter {
    
    private int a = 0;
    private int b = 0;
    Object lock = new Object();
    
    
    public synchronized void add(int num) {
	a += num;
    }
    
    public void add2(int num) {
	synchronized(lock) {
	    b += num;
	}
    }

    public int getA() {
        return a;
    }  
    
    public int getB() {
        return b;
    } 
    
    
}

public class Synchronize { 
   
    
    private static class Thread0 extends Thread {
	
	private Counter c;	
	
	public Thread0(Counter c) {	    
	    this.c = c;
	}

	@Override
	    public void run() {
		
	    for (int i = 0; i < 100000; i++) {
	    	    c.add(1);
	    	    c.add2(1);
	    	}
		
	    }
	
    }
    
    private static class Thread1 extends Thread {
	
	private Counter c;	
	
	public Thread1(Counter c) {	    
	    this.c = c;
	}

	@Override
	    public void run() {
		
	    	for (int i = 0; i < 100000; i++) {
	    	    c.add(10);
	    	    c.add2(10);
	    	}
	    }
	
    }
    
    
    public static void main(String[] args) throws InterruptedException {	
	
	Counter c1 = new Counter();
	
	Thread t = new Thread0(c1);
	Thread t2 = new Thread1(c1);
	
	Long begin = System.currentTimeMillis();
	
	t.start();
	t2.start();	
	
	t.join();
	t2.join();
	
	System.out.println("a = " + c1.getA());
	System.out.println("b = " + c1.getB());
	
	Long time = System.currentTimeMillis() - begin;
	
	float fTime = (float) time / 1000;
	System.out.format("%.2f sec", fTime);

    }

}
