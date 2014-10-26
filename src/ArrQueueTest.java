import java.util.Scanner;


public class ArrQueueTest 
{
	public static void main(String[] args)
	{
		ArrQueue queue;
		
		boolean done = false;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Queue Size?");
		queue = new ArrQueue(sc.nextInt());
		while(!done)
		{
			System.out.println("[E]nqueue, [D]equeue, [P]rint or [Q]uit");
			String response = sc.next();
			
			if(response.equalsIgnoreCase("E"))
			{
				System.out.println("Integer to enqueue?");
				queue.enqueue(sc.nextInt());
			}
			else if(response.equalsIgnoreCase("D"))
			{
				System.out.println( "Integer dequeued: " + queue.dequeue() );
			}
			else if(response.equalsIgnoreCase("P"))
			{
				System.out.println( queue );
				System.out.println( queue.toStringFormatted() );
			}
			else if(response.equalsIgnoreCase("Q"))
				done = true;
		}
	}
}
