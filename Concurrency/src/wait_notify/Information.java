package wait_notify;

public class Information {
    
    private String info;
    
    private boolean empty = true;    
    
    
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public synchronized void send(String message) {	
	
	while (!empty) {
	    
	    try {
		
		wait();
		
	    } catch (InterruptedException e) {		
		e.printStackTrace();
	    }	    
	    
	}
	
	empty = false;
	    
	setInfo(message);	
	
	notifyAll();
	
    }
    
    
    public synchronized String receive() {	
		
	while (empty) {
	    
	    try {
		
		wait();
		
	    } catch (InterruptedException e) {		
		e.printStackTrace();
	    }
	    
	}
	
	empty = true;
	
	notifyAll();	
	
	return info;
    }
    
    

}
