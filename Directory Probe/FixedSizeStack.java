public class FixedSizeStack implements StackInterface
{/*Austin Hippe
CISC 231
Patrick Jarvis
March 4th, 2019

	This class implements a stack which we used for the
	directory probe. We implemented the stack in a way so
	that the top of the stack is the greatest element in
	the array. We also have methods to add, take off, peek
	at the first element, see its size, and see if it is
	empty or full.

	Instance Variables:

		private Object[] array - holds the stack

		private int top - holds the top of the stack

	Constructors:

		FixedSizeStack( int maxStackSize ) - creates the stack.
		we make the top -1 because that then tells us if it is
		empty or not. When somebody puts something in, then the
		tops gets changed to 0.

	Methods:

		isEmpty() - returns if the stack is empty or not

		isFull() - returns if the stack is full or not

		peek() - does not remove, but returns the first element
		of the stack

		size() - returns how many elements are in the stack

		pop() - takes out the top element in the stack and returns
		it. Top has to be adjusted.

		push( object ) - adds an element to the top of the queue. Top
		has to be adjusted.

*/

	private Object[] array;

	private int top;

	public FixedSizeStack( int maxStackSize )
	{
		if( maxStackSize < 0 )
		{
			throw new IllegalArgumentException( getClass().getName() + " Cant have a stack that is -1 size" );
		}//if( maxQueueSize < 0 )

		array = new Object[maxStackSize];
		top = -1;

	}//FixedSizeStack( int maxStackSize )

	public boolean isEmpty()
	{
		return (top < 0);
	}//isEmpty()

	public boolean isFull()
	{
		return ( top >= this.array.length - 1 );
	}//isFull()

	public Object peek()
	{
		if( isEmpty() == true )
		{
			throw new StackUnderFlowException( " Stack is empty ");
		}//if( isEmpty() == true )

		return this.array[this.top];
	}//peek()

	public int size()
	{
		return this.top + 1;
	}//size()

	public Object pop()
	{
		if( isEmpty() == true )
		{
			throw new StackUnderFlowException( " Stack is empty " );
		}//if( isEmpty() == true )

		Object hold;

		hold = this.array[top];

		this.array[top] = null;

		this.top = this.top - 1;

		return hold;
	}//pop()

	public void push( Object object )
	{
		if( isFull() == true )
		{
			throw new StackOverFlowException( " Stack is full ");
		}//if( isFull() == true )

		if( object == null )
		{
			throw new IllegalArgumentException( getClass().getName() + " passed object is null");
		}//if( object == null )

		this.array[top+1] = object;
		this.top = top+1;
	}//push( Object object )

} //class