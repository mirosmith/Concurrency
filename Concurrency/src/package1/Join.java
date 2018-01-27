package package1;

public class Join {

    public static void showMessage(String text) {
	System.out.println(Thread.currentThread().getName() + " says: " + text);
    }

    public static class Loop implements Runnable {	

	private String[] words = { "House", "Electricity", "Toilet", "Heating", "Decoration" };	
	
	@Override
	public void run() {
	    try {
		
		for (String s : words) {

		    Thread.sleep(3000);
		    showMessage("working on " + s);

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
		showMessage("I am tired of waiting");
		t.interrupt();
		t.join();
	    }

	}
	showMessage("Go home.");

    }

}
