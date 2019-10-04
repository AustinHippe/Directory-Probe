public class FixedSizeQueue implements QueueInterface
{/*Austin Hippe
CISC 231
Patrick Jarvis
March 4th, 2019

	This class implements a queue which we used for the
	directory probe. We implemented a circular queue, with
	it front and a rear, using an array. We have some methods
	to add, take out, peak at the first element, and see if
	the queue is full or empty.

	Instance Variables:

		private Object[] array - holds the queue

		private int front - holds the front of the queue

		private int rear - holds the back or rear of the queue

	Constructors:

		FixedSizeQueue( int maxQueueSize ) - creates the queue.
		we make the array one size bigger then the max because
		we want the front to be one ahead from the first element.

	Methods:

		isEmpty() - returns if the queue is empty or not

		isFull() - returns if the queue is full or not

		peek() - does not remove, but returns the first element
		of the queue

		size() - returns how many elements are in the queue

		deQueue() - takes out the front element in the queue and returns
		it. When doing this you have to adjust your front so its not
		to far ahead

		enQueue( object ) - adds an element to the back of the queue.
		When doing this you have to adjust your rear so its not to far
		behind

*/

	private Object[] array;

	private int front;

	private int rear;

	public FixedSizeQueue( int maxQueueSize )
	{
		if( maxQueueSize < 0 )
		{
			throw new IllegalArgumentException( getClass().getName() + " Cant have a queue that is -1 size" );
		}//if( maxQueueSize < 0 )

		this.array = new Object[maxQueueSize+1];

		this.front = maxQueueSize;

		this.rear = maxQueueSize;

	}//FixedSizeQueue( int maxQueueSize )

	public boolean isEmpty()
	{
		return this.front == this.rear;

	}//boolean isEmpty()

	public boolean isFull()
	{
		return (this.rear+1)%this.array.length == this.front;

	}//isFull()

	public Object peek()
	{
		if( isEmpty() == true )
		{
			throw new StackUnderFlowException( " Stack is empty ");
		}//if( isEmpty() == true )

		return this.array[(this.front+1)%this.array.length];

	}//peek()

	public int size()
	{
		int result;

		result = 0;

		if( this.front > this.rear )
		{
			result = this.array.length - this.front + this.rear;

		}//if( this.front > this.rear )

		else
		{
			result = this.rear - this.front;

		}//else

		return result;

	}//size()

	public Object deQueue()
	{
		if( isEmpty() == true )
		{
			throw new QueueUnderFlowException( " Queue is empty " );

		}//if( isEmpty() == true )

		Object hold;

		hold = this.array[(this.front+1)%this.array.length];
		this.array[(this.front+1)%this.array.length] = null;
		this.front = (this.front + 1)%this.array.length;

		return hold;

	}//deQueue()

	public void enQueue( Object object )
	{
		if( isFull() == true )
		{
			throw new QueueOverFlowException( " Queue is full ");
		}//if( isFull() == true )

		if( object == null )
		{
			throw new IllegalArgumentException( getClass().getName() + " passed object is null");
		}//if( object == null )

		this.rear = (this.rear + 1)%this.array.length;
		this.array[this.rear] = object;

	}//enQueue( Object object )

} //class