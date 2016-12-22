import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CyclicBarrierImpl 
{
	public static void main(String args[])
	{
		Runnable action = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("CyclicBarrier is reached.");
			}
		};
		
		CyclicBarrier cyclickBarrier = new CyclicBarrier(3, action);
		
		Runnable xmlData = new Runnable() {
		
			@Override
			public void run() {
				System.out.println("xmlData is read.");
				try {
					System.out.println(Thread.currentThread().getName() + " waiting other to complete");
					cyclickBarrier.await();
					System.out.println("xmlData is processed");
				} catch (BrokenBarrierException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Runnable dbData = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("DB is read");
				try {
					System.out.println(Thread.currentThread().getName() + " waiting other to complete");
					cyclickBarrier.await();
					System.out.println("DB is processed");
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Runnable txtData = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("txt is read");
				try {
					System.out.println(Thread.currentThread().getName() + " waiting other to complete");
					cyclickBarrier.await();
					System.out.println("txt is processed");
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(xmlData);
		es.execute(dbData);
		es.execute(txtData);
		es.shutdown();
	}
}
