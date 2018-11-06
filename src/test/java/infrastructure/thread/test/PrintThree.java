package infrastructure.thread.test;

public class PrintThree implements Runnable{

	@Override
	public void run() {
		for(int i=0; i< 100; i++){
			try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			
			System.out.println("PrintThree" + i);
		}
		
	}

}
