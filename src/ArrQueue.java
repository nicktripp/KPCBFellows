import java.util.NoSuchElementException;


public class ArrQueue 
{
	private int[] queue;
	private int size;
	
	public ArrQueue(int initialSize)
	{
		queue = new int[initialSize];
		size = 0;
	}
	
	public void enqueue(int value)
	{
		size++;
		if (size > queue.length)
		{
			int[] newQueue = new int[size * 2];
			
			for(int i = 0; i < queue.length; i++)
				newQueue[i] = queue[i];
			
			queue = newQueue;
		}
		queue[size-1] = value;
	}
	
	public int dequeue()
	{
		if(size == 0)
			throw new NoSuchElementException();
		
		int value = queue[0];
		for(int i = 1; i < queue.length; i++)
			queue[i-1] = queue[i];
		queue[queue.length-1] = 0;
		size--;
		
		return value;
	}
	
	/**
	 * A toString method to print the array contents, and where the queue starts and ends in that circular array.
	 * TODO: Remove this before submission
	 */
	public String toString()
	{		
		String total = "Array: [";
		for(int i = 0; i < size; i++)
			total += queue[i] + ",";
		total = total.substring(0, total.length() - 1) + "], Back(oldest) at index=" 
			+ (0) + ", incoming to be at index=" + (size) + "\nElement count of " + size;
		
		return total;
	}
	
	/**
	 * A toString method to print a more visual representation of the queue.
	 * TODO: Remove this before submission
	 */
	public String toStringFormatted()
	{
		String total = "Front - { ";
		
		if (size > 0)
		{			
			for(int i = 0; i < size; i++)
				total+= queue[i] + ",";
		}
		
		
		total = total.substring(0, total.length() - 1) + " { - Back";
		
		return total;
	}
}
