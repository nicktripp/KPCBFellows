		=======================================================
			KPCB ENGINEERING FELLOWSHIP	APPLICATION
		=======================================================

			****INTRODUCTION****
		
	 This bounded queue implementation is for my 2015 Kleiner Perkins Caufield & Byers Engineering Fellowship application.  
	 The implementation is written with Java.

			****TECHNICAL INFORMATION****

	 This implementation uses a linked list to store values. The linked list itself is made of ListItem elements, which are defined within the inner class ListItem.
	 Each ListItem is a member of the linked list, (and thus the queue) and stores an integer value, as well as 
	 a 'nextItem' reference pointing to the next ListItem in the linked list.
	 
	 This is a 'bounded' queue, with a max item count represented by an integer value instance variable. The bound is taken by the constructor.
	 Trying to make a Queue with a negative or zero bound throws an IllegalArgumentException.
	 
	 Each Queue stores pointers to the ListItem elements at the 'front' and 'back' of the queue. 
	 Initially, there are no 'front' or 'back' values.

	 The method to enqueue a value into the queue places the value in a new ListItem object. That object is then placed at the 'back' of the queue by updating the
	 'back' reference of the queue and the 'nextItem' reference of the next-youngest ListItem to point to that object.
	 If the queue is already full, the enqueue method throws an IllegalStateException, the same exception thrown by the standard Java implementation of Queue.

	 The method to dequeue a value from the queue removes ListItem object at the 'front' of the queue, and then returns its value.  The 'front' reference is then
	 updated to point to the removed ListItem's 'nextItem' reference. 
	 If the queue is empty when trying to dequeue, a NoSuchElementException is thrown, the same exception thrown by the standard Java implementation of Queue.
	 
	 For convenience, I have included a simple example of a program with a main() method which implements the Queue class, located in ExampleQueueApp.java. 
	 I have also included a toString() method to convert the queue into a text representation stored in a String object, for use in the example app.
	 
	 jUnit tests have also been provided in QueueTest.java.
	 
			****IMPLEMENTATION****
	 
	 Queue is a public class that can be implemented into any Java program.  To use the Queue class, first import or copy the Queue.java file into the current package.
	 The public constructors and methods of Queue will then be available for use. Consult the javadoc comments when implementing Queue.
	 
			****HOW TO RUN****
	 
	 Since Queue does not have a main() method, it can not be executed directly from the command line.
	 
	 To run an example of Queue, you can do any of the following:
	   - implement Queue into another program, and run that program.
	   - run the ExampleQueueApp. To do this, do the following:
	       * Open up the terminal or command prompt (in Linux or Mac/Windows). Navigate to the directory that ExampleQueueApp.java is in.
	       * Type "javac ExampleQueueApp.java" and hit enter to compile the program.
	       * Type "java ExampleQueueApp" and hit enter to run the program. Respond to the prompts in the terminal/command prompt.
	   - run the jUnit tests. 
	 
			****THANKS****
									
	 Thanks for reviewing my application and checking out this queue implementation!
	 
	 	- Nick Tripp
