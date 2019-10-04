public class StackQueueDriver
{

public static void main ( String[] args )
{
	FixedSizeStack x;

	x = new FixedSizeStack(3);

	Object y;

	y = 0;

	System.out.println(x.isEmpty());
	System.out.println(x.size());

	for( int i = 0; i < 3; i++ )
	{
		x.push(y);
		y = (Object)(i + 1);
		System.out.println(x.peek());
	}

	System.out.println(x.size());
	System.out.println(x.isFull());
	System.out.println(x.isEmpty());

	for( int i = 0; i < 3; i++ )
	{
		System.out.println(x.pop());
		System.out.println(x.size());
	}

	//System.out.println(x.size());
	System.out.println(x.isEmpty());
	System.out.println(x.isFull());




} //main



} //class