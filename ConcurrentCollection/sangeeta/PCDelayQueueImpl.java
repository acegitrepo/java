import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class PCDelayQueueImpl 
{
	
  public static void main(String args[])
  {
	  BlockingQueue<Item> queue = new DelayQueue<>();
	  
	  Thread consumerThread = new Thread(new Consumer(queue));
	  Thread producerThread = new Thread(new Producer(queue));
	  
	  producerThread.start();
	  consumerThread.start();
  }
}

class Consumer implements Runnable
{
   BlockingQueue<Item> queue ;
   
   public Consumer(BlockingQueue<Item> queue) {
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
	BlockingQueue<Item> queue ;
	   
	public Producer(BlockingQueue<Item> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() 
	{
		try 
		{
			Random random = new Random();
			for(int i = 0; i < 20; i++)
			{
				long delay = random.nextInt(2000);
				Item item = new Item(i, delay);
			    System.out.println("producing: " + item);
				queue.put(item);
			}
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
}

class Item implements Delayed
{
	Integer num;
	long delay;
	
	Item(Integer num, long delay)
	{
		this.num = num;
		this.delay = delay;
	}
	
	@Override
	public int compareTo(Delayed o) {
		Item item = (Item)o;
		if(this.num > item.num)
			return 1;
		if(this.num < item.num)
			return -1;
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return num;
	}
	
	@Override
	public String toString()
	{
		return num + ", " + delay;
	}
	
}
