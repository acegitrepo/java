import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CounDownLatchImpl {
	
	public static void main(String args[])
	{
		CountDownLatch countDowmLatch = new CountDownLatch(3);
		
		Runnable action = new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("waiting for count dowm latch");
					countDowmLatch.await();
					System.out.println("wait is completed");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("CountDownLatch is reached to 0.");
			}
		};
		
		Runnable xmlData = new Runnable() {
		
			@Override
			public void run() {
				System.out.println("xmlData is read.");
				countDowmLatch.countDown();
				
			}
		};
		
		Runnable dbData = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("DB is read");
				countDowmLatch.countDown();
			}
		};
		
		Runnable txtData = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("txt is read");
				countDowmLatch.countDown();
			}
		};
		
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(xmlData);
		es.execute(dbData);
		es.execute(txtData);
		es.execute(action);
		es.shutdown();
	}

}
