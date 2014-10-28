=======================================================
	KPCB ENGINEERING FELLOWSHIP APPLICATION
=======================================================

		****INTRODUCTION****
		
	 This bounded queue implementation is for my 2015 Kleiner Perkins Caufield & Byers Engineering Fellowship application. The implementation is written with Java.

		****TECHNICAL INFORMATION****

	 This implementation uses a linked list to store values. The linked list itself is made of ListItem elements, which are defined within the inner class ListItem. Each ListItem is a member of the linked list, (and thus the queue) and stores an integer value, as well as a 'nextItem' reference pointing to the next ListItem in the linked list.
	 
	 This is a 'bounded' queue, with a max item count represented by an integer value instance variable. The bound is taken by the constructor. Trying to make a Queue with a negative or zero bound throws an exception.
	 
	 Each Queue stores pointers to the ListItem elements at the 'front' and 'back' of the queue. Initially, there are no 'front' or 'back' values.

	 The method to enqueue a value into the queue places the value in a new ListItem object. That object is then placed at the 'back' of the queue by updating the 'back' reference of the queue and the 'nextItem' reference of the next-youngest ListItem to point to that object. If the queue is already full, the enqueue method throws an exception.

	 The method to dequeue a value from the queue removes ListItem object at the 'front' of the queue, and then returns its value.  The 'front' reference is then updated to point to the removed ListItem's 'nextItem' reference.
	 
		****THANKS****
		
	 Thanks for reviewing my application and checking out this queue implementation!
	 
	 	- Nick Tripp
