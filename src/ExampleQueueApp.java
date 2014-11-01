import java.util.Scanner;

/**
 * A simple example application that implements the Queue class.
 * To use, first enter the desired queue size when prompted, then respond to prompts to enqueue, dequeue, or print the queue.
 * @author nicktripp
 *
 */
public class ExampleQueueApp 
{
	public static void main(String[] args)
	{
		Queue queue;
		
		boolean done = false;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Queue Size? (an integer > 0)");
		queue = new Queue(sc.nextInt());
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
			}
			else if(response.equalsIgnoreCase("Q"))
				done = true;
		}
	}
}
