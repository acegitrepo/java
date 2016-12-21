import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TransferQueue;


public class PCBlockingQueueImpl 
{
	public static ArrayBlockingQueue<Integer> getArrayBlockingQueue()
	{
		return new ArrayBlockingQueue<Integer>(5);
	}
	
	public static LinkedBlockingQueue<Integer> getLinkedBlockingQueue()
	{
		return new LinkedBlockingQueue<Integer>();
	}
	
	public static SynchronousQueue<Integer> getSynchronousQueue()
	{
		return new SynchronousQueue<Integer>();
	}
	
	public static LinkedTransferQueue<Integer> getLinkedTransferQueue()
	{
		return new LinkedTransferQueue<Integer>();
	}
	
  public static void main(String args[])
  {
	  BlockingQueue<Integer> queue = getArrayBlockingQueue();
	  //BlockingQueue<Integer> queue = getLinkedBlockingQueue();
	  //BlockingQueue<Integer> queue = getSynchronousQueue();
	  //BlockingQueue<Integer> queue = getLinkedTransferQueue();
	  
	  Thread consumerThread = new Thread(new Consumer(queue));
	  Thread producerThread = new Thread(new Producer(queue));
	  
	  producerThread.start();
	  consumerThread.start();
  }
}

class Consumer implements Runnable
{
   BlockingQueue<Integer> queue ;
   
   public Consumer(BlockingQueue<Integer> queue) {
	  this.queue = queue;
    }
   
	@Override
	public void run() {
		try {
			for(int i = 0; i < 20; i++)
			{
				System.out.println("Consuming: " + queue.take());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class Producer implements Runnable
{
	BlockingQueue<Integer> queue ;
	   
	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() 
	{
		try 
		{
			for(int i = 0; i < 20; i++)
			{
				if(queue instanceof TransferQueue<?>)
				{
					System.out.println("transfering: " + i);
					((TransferQueue<Integer>)(queue)).transfer(i);
				}
				else
				{
					System.out.println("producing: " + i);
					queue.put(i);
				}
			}
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
}
