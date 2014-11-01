import java.util.NoSuchElementException;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * A set of test cases for the Queue class.
 * @author nicktripp
 *
 */
public class QueueTest extends TestCase
{	
	@Test
	public void testInvalidQueueBoundThrowsException() 
	{
		try //Case: negative bound
		{
			Queue queue = new Queue(-1);
			fail("Did not throw IllegalArgumentException upon constructing queue with invalid bound.");
		}
		catch (IllegalArgumentException e) {/*Threw the right exception. Pass.*/}
		
		try //Case: zero bound
		{
			Queue queue = new Queue(0);
			fail("Did not throw IllegalArgumentException upon constructing queue with invalid bound.");
		}
		catch (IllegalArgumentException e) {/*Threw the right exception. Pass.*/}
	}
	
	@Test
	public void testDequeueEmptyQueueThrowsException() 
	{
		try //Case: Always empty queue
		{
			Queue queue = new Queue(3);
			queue.dequeue();
			fail("Did not throw NoSuchElementException upon dequeueing an empty queue.");
		}
		catch (NoSuchElementException e) {/*Threw the right exception. Pass.*/}
		try //Case: queue that was at one time full, now empty 
		{
			Queue queue = new Queue(3);
			queue.enqueue(43);
			queue.enqueue(-9);
			queue.enqueue(0); //Enqueue three times
			queue.dequeue();
			queue.dequeue();
			queue.dequeue();
			queue.dequeue(); //Dequeue four times
			fail("Did not throw NoSuchElementException upon dequeueing an empty queue.");
		}
		catch (NoSuchElementException e) {/*Threw the right exception. Pass.*/}
	}
	
	@Test
	public void testEnqueueFullQueueThrowsException() 
	{
		try //Case: Always empty queue
		{
			Queue queue = new Queue(2);
			queue.enqueue(0);
			queue.enqueue(0);
			queue.enqueue(0); //Try to enqueue a full queue, past bound
			fail("Did not throw IllegalStateException upon trying to enqueue on a full queue.");
		}
		catch (IllegalStateException e) {/*Threw the right exception. Pass.*/}
	}
	
	@Test
	public void testValidEnqueueDequeue() 
	{
		final int BOUND = 5;
		Queue queue = new Queue(BOUND);
		assertNotNull(queue);
		
		//Test one enqueue/dequeue
		final int FIRST_VALUE = 1;
		queue.enqueue(FIRST_VALUE);
		assertEquals(queue.dequeue(), FIRST_VALUE); //Queue has one value of '1'
		
		//test removal of value from previous dequeue AND full enqueue/dequeue 
		final int SECOND_VALUE = 398239;
		final int THIRD_VALUE = -434;
		final int FOURTH_VALUE = -434;
		final int FIFTH_VALUE = 0;
		queue.enqueue(FIRST_VALUE);
		queue.enqueue(SECOND_VALUE);
		queue.enqueue(THIRD_VALUE);
		queue.enqueue(FOURTH_VALUE);
		queue.enqueue(FIFTH_VALUE);//Queue is full with representation 'oldest'->'youngest' as [1, 398239, -434, -434, 0]
		assertEquals(queue.dequeue(), FIRST_VALUE);
		assertEquals(queue.dequeue(), SECOND_VALUE);
		assertEquals(queue.dequeue(), THIRD_VALUE);
		assertEquals(queue.dequeue(), FOURTH_VALUE);
		assertEquals(queue.dequeue(), FIFTH_VALUE);
		
		//Test removal of all values during previous full dequeue AND full enqueue, partial dequeue, then partial enqueue and full dequeue.
		//Also tests that the oldest value is returned upon dequeue.
		queue.enqueue(FIRST_VALUE);
		queue.enqueue(SECOND_VALUE);
		queue.enqueue(THIRD_VALUE);
		queue.enqueue(FOURTH_VALUE);
		queue.enqueue(FIFTH_VALUE); //Queue is full with representation 'oldest'->'youngest' as [1, 398239, -434, -434, 0]
		assertEquals(queue.dequeue(), FIRST_VALUE);
		assertEquals(queue.dequeue(), SECOND_VALUE);
		assertEquals(queue.dequeue(), THIRD_VALUE); //Queue is partially full with representation 'oldest'->'youngest' as [-434, 0]
		
		queue.enqueue(FIRST_VALUE);
		queue.enqueue(SECOND_VALUE);
		queue.enqueue(THIRD_VALUE); //Queue is full with representation 'oldest'->'youngest' as [-434, 0, 1, 398239, -434,]. 
		//Note the order of the following dequeue, with oldest values being dequeued first.
		assertEquals(queue.dequeue(), FOURTH_VALUE);
		assertEquals(queue.dequeue(), FIFTH_VALUE);
		assertEquals(queue.dequeue(), FIRST_VALUE);
		assertEquals(queue.dequeue(), SECOND_VALUE);
		assertEquals(queue.dequeue(), THIRD_VALUE);
		
	}
}
