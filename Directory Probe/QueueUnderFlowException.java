public class QueueUnderFlowException extends StackQueueException
{/*Austin Hippe
CISC 231
Patrick Jarvis
March 4th, 2019

	Exception for when the queue is empty

*/
	private static final long serialVersionUID = 1;

	public QueueUnderFlowException( String message ) { super( message ); }

} //class