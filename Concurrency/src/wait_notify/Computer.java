package wait_notify;

import java.util.Random;

public class Computer implements Runnable {
    
    private Information information;

    public Computer(Information information) {	
	this.information = information;
    }

    @Override
    public void run() {	
	
	String[] messages = {"allocating", "computing", "cleaning memory", "creating logs", "stand-by", "END"};
	
	Random random = new Random();
	
	for (int i = 0; i < messages.length; i++) {
	    
	    information.send(messages[i]);	    
	    
	    try {
		
		Thread.sleep(random.nextInt(4000));
		
	    } catch (InterruptedException e) {		
		e.printStackTrace();
	    }
	    
	}
	
    }    
    
    

}
