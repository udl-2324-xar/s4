import java.util.concurrent.atomic.AtomicInteger;

public class SharedAtomic
{
	private static AtomicInteger x;

	public static void main (String[] args) throws InterruptedException
	{
		x = new AtomicInteger ();
		Thread t1 = new Thread (new Adder());
		Thread t2 = new Thread (new Adder());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println ("x = " + x.get());
	}

	private static class Adder implements Runnable
	{
		public void run()
		{
			for (int i = 0; i < 500000; i++)
			{
				x.incrementAndGet ();
			}
		}
	}

}
