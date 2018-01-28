package package1;

class MyThread extends Thread {

    @Override
    public void run() {

	for (int i = 0; i < 5; i++) {

	    System.out.println(Thread.currentThread().getName() + " is running with priority "
		    + Thread.currentThread().getPriority());

	    try {
		Thread.sleep(500);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	}

    }
    
}    


public class Priority { 

    public static void main(String[] args) throws InterruptedException {
	
	Thread p1 = new MyThread(); p1.setName("one");
	Thread p2 = new MyThread(); p2.setName("two");
	Thread p3 = new MyThread(); p3.setName("three");
	Thread p4 = new MyThread(); p4.setName("four");
	Thread p5 = new MyThread(); p5.setName("five");
	
	p1.setPriority(1);
	p2.setPriority(3);
	p3.setPriority(5);
	p4.setPriority(8);
	p5.setPriority(10);
	
	p1.start();
	p2.start();
	p3.start();
	p4.start();
	p5.start();	
	
    }

}
