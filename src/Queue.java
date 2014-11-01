import java.util.NoSuchElementException;

/**
 * A Queue implementation that uses a linked list to store values. 
 * The linked list is made of ListItem elements, which are defined as an inner class in this class.
 * Each Queue stores pointers to the ListItem elements at the 'front' and 'back' of the queue.
 * This is a 'bounded' queue, with a max item count, represented by the 'bound' int instance variable.
 * Has enqueue and dequeue functionality.
 * @author nicktripp
 *
 */
public class Queue 
{
	/**
	 * An inner class of Queue.  Each ListItem is a member of the queue (and the linked list which represents it), 
	 * and points to the member of the queue 'behind' it.
	 * @author nick.e.tripp
	 *
	 */
	private static class ListItem
	{
		private int value;
		private ListItem nextItem;
		
		/**
		 * A constructor to instantiate a member of the queue.
		 * @param value - the int value stored, which will be enqueued
		 * @param nextItem - a reference to the ListItem in the queue which is 'behind' this ListItem
		 */
		public ListItem(int value, ListItem nextItem)
		{
			this.value = value;
			this.nextItem = nextItem;
		}

		/**
		 * Gets the value of the queue in this ListItem
		 * @return - the int value stored in this ListItem
		 */
		public int getValue() { return value; }

		/**
		 * Gets a reference to the ListItem which stores the value that is 'behind' this one in the queue.
		 * @return - a ListItem reference to the next item in the queue
		 */
		public ListItem getNextItem() { return nextItem; }

		/**
		 * Sets this ListItem to point to the next one in the queue.
		 * 
		 */
		public void setNextItem(ListItem nextItem) { this.nextItem = nextItem; }
	}
	
	private int size;
	private int bound;
	private ListItem front;
	private ListItem back;

	/**
	 * A constructor to instantiate the queue.
	 * Initially, the size of the queue is zero, and there are no 'front' or 'back' values.
	 * Throws an exception if the bound is less than or equal to zero.
	 * @param bound - the max number of values that can be stored in this queue. Must be greater than zero, or this instance is not a valid queue.
	 */
	public Queue(int bound) throws IllegalArgumentException
	{
		if (bound <= 0)
			throw new IllegalArgumentException("Bound must be greater than 0."); //throw an exception if bound is not a valid size
		this.bound = bound;
		size = 0;
		front = null;
		back = null;
	}
	
	/**
	 * A method to 'enqueue' a value into the queue, placing the value at the 'back' of the queue.
	 * If the queue is already full, this method throws an exception.
	 * @param value - the int value to be enqueued at the back of the queue
	 */
	public void enqueue(int value)
	{
		if (size==0)
		{
			front = new ListItem(value, null);
			back = front;
			size++;
		}
		else if (size >= bound)
			throw new IllegalStateException();//throw an exception if trying to add beyond max capacity
		else
		{
			back.setNextItem(new ListItem(value, null)); //set back to point to newest item
			back = back.getNextItem(); //reassign back to newest item
			size++;
		}
	}
	
	/**
	 * A method to 'dequeue' a value from the queue, removing the value at the 'front' of the queue.
	 * @return - the int value which was at the front of the queue
	 */
	public int dequeue() throws NoSuchElementException
	{
		if (front == null)
			throw new NoSuchElementException();
		
		size--;
		
		ListItem oldFront = front; 
		front = oldFront.getNextItem(); //set front to point to next oldest item
		return oldFront.getValue();
		//leave oldest item to be garbage collected
	}
	
	
	
	/**
	 * A method returning a text representation of queue, a list in square brackets, with the oldest member on the left.
	 * Uses the following recursive method to iterate through the ListItems of the queue.
	 * @return - a text representation of the queue
	 */
	public String toString()
	{
		return "[" + Queue.toString(front) + "]";
	}
	
	/**
	 * A recursive method to convert a section of the queue to a string. 
	 * This method converts the current list item and everything behind it to a list in a String separated by commas.
	 * @param - the ListItem holding the earliest value to be printed.
	 * @return - a text representation of the values of the given ListItem, and every ListItem behind it.
	 */
	private static String toString(ListItem item)
	{
		String str = "";
	    if (item == null)
	    	return str;
	    str+= item.getValue();
	    str += (item.getNextItem()==null ? "":",") + toString(item.getNextItem());
		return str;
	}
}

