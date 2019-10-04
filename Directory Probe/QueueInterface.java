public interface QueueInterface extends StackQueueInterface
{/*Austin Hippe
CISC 231
Patrick Jarvis
March 4th, 2019

	Interface is used so we can implement different
	kinds of queues in subclasses

*/
	public Object deQueue();

	public void enQueue( Object object );

} //class