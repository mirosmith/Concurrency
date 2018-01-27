package wait_notify;

public class MainProcess {

    public static void main(String[] args) {
	
	Information info = new Information();
	
	Computer kebyLake = new Computer(info);
	User nicolasCage = new User(info);
	
	Thread t1 = new Thread(kebyLake);
	Thread t2 = new Thread(nicolasCage);
	
	t1.start();
	t2.start();

    }

}
