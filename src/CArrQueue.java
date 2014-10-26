import java.util.NoSuchElementException;

/**
 * A implementation of a bounded queue using a circular array
 * @author Nick
 *
 */
public class CArrQueue 
{
	int[] queue;
	int backPos;
	int elementCount;
	
	/**
	 * Creates a bounded queue object with specified size
	 * @param size - an positive integer to be the initial size of the queue.
	 */
	public CArrQueue(int size)
	{
		queue = new int[size];
		backPos = 0;
		elementCount = 0;
	}
	
	/**
	 * Enqueues an integer into the queue, and updates the position and elementCount instances.
	 * If queue overflow happens, double queue size
	 * @param back - the integer to be enqueued
	 */
	public void enqueue(int back) 
	{
		if (elementCount == queue.length) //Double queue size if queue is full. Or should I throw exception?
		{			
			int[] temp = new int[queue.length * 2];
			
			int frontPos = (backPos - elementCount) % queue.length;
			if (frontPos < 0) 
				frontPos += queue.length;
			
			int i = (frontPos);
			int newPos = 0;
			do
			{
				temp[newPos] = queue[i];
				newPos++;
				i = (i + 1) % queue.length;
			}
			while(i != backPos);
			
			backPos = queue.length;
			queue = temp;
			
		}
		
		queue[backPos] = back;
		backPos++;
		backPos %= queue.length; //Or should I use another instance variable to hold size instead of computing it?
		if(elementCount < queue.length)
			elementCount++; //Only increase element count to a max of array.length
	}
	
	/**
	 * Dequeues the oldest integer from the queue, and reduces the elementCount variables.
	 * If queue underflow happens, returns -42. TODO: Throw exception
	 * @return
	 */
	public int dequeue() throws NoSuchElementException
	{
		if(elementCount <= 0) //If no elements in queue, throw an exception.
			throw new NoSuchElementException();
			
		int frontPos = (backPos - elementCount) % queue.length;
		if (frontPos < 0) 
			frontPos += queue.length;
		
		elementCount--;
		return queue[frontPos];
	}
	
	
	
	/**
	 * A toString method to print the array contents, and where the queue starts and ends in that circular array.
	 * TODO: Remove this before submission
	 */
	public String toString()
	{

		int frontPos = (backPos - elementCount) % queue.length;
		if (frontPos < 0) 
			frontPos += queue.length;
		
		String total = "Array: [";
		for(int i = 0; i < queue.length; i++)
			total += queue[i] + ",";
		total = total.substring(0, total.length() - 1) + "], Back(oldest) at index=" 
			+ (frontPos) + ", incoming to be at index=" + (backPos) + "\nElement count of " + elementCount;
		
		return total;
	}
	
	/**
	 * A toString method to print a more visual representation of the queue.
	 * TODO: Remove this before submission
	 */
	public String toStringFormatted()
	{
		String total = "Front - { ";
		
		if (elementCount > 0)
		{
			int frontPos = (backPos - elementCount) % queue.length;
			if (frontPos < 0) 
				frontPos += queue.length;
			
			/*for(int i = frontPos; i != frontPos; i = (i + 1)%queue.length)
				total += queue[i] + ",";*/ //This loop Doesn't work if queue is full
			
			int i = (frontPos);
			do
			{
				total += queue[i] + ",";
				i = (i + 1) % queue.length;
			}
			while(i != backPos);
		}
		
		
		total = total.substring(0, total.length() - 1) + " { - Back";
		
		return total;
	}
}
