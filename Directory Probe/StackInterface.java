public interface StackInterface extends StackQueueInterface
{/*Austin Hippe
CISC 231
Patrick Jarvis
March 4th, 2019

	Interface is used so we can implement different
	kinds of stacks in subclasses

*/
	public Object pop();

	public void push( Object object );

} //class