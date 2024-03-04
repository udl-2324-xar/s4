public class SharedVolatile
{
	private static volatile int x = 0;

	public static void main (String[] args) throws InterruptedException
	{
		Thread t1 = new Thread (new Adder());
		Thread t2 = new Thread (new Adder());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println ("x = " + x); // Resultat incorrecte
	}

	private static class Adder implements Runnable
	{
		public void run()
		{
			for (int i = 0; i < 500000; i++)
			{
				x = x + 1;
			}
			System.out.println("he acbat");
		}
	}

}
