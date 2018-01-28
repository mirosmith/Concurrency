package package1;

public class ShutDownHook {

    public static class MyThread extends Thread {
	public void run() {
	    System.out.println("shut down hook task completed..");
	}
    }

    public static void main(String[] args) throws InterruptedException {
	
	Runtime r = Runtime.getRuntime();
	r.addShutdownHook(new MyThread());
	
	System.out.println("Main thread is sleeping, press ctrl+c");
	Thread.sleep(8000);	
	

    }

}
