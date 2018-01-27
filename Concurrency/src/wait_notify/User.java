package wait_notify;

import java.time.LocalTime;
import java.util.Random;

public class User implements Runnable {
    
    private Information information;

    public User(Information information) {	
	this.information = information;
    }
    
    @Override
    public void run() {	
	
	Random random = new Random();
	
	for (String message = information.receive(); message != "END"; message = information.receive()) {	   
	    
	    System.out.println(LocalTime.now() + " received message : " + message);
	    
	    try {
		
		Thread.sleep(random.nextInt(4000));
		
	    } catch (InterruptedException e) {		
		e.printStackTrace();
	    }
	    
	}
	
    }
    
    

}
