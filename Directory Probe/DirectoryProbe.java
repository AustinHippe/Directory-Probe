import java.io.*;

public class DirectoryProbe
{/*Austin Hippe
CISC 231
Patrick Jarvis
March 4th, 2019

	In this assignment we used our implementations
	of stacks and queues to make a directory probe that
	prints out the deepest level of directory nesting as
	well as the file path to get there. It does this in
	the main method by putting each level of the directory
	tree in the stack using a queue to hold all of the
	directories. It goes down as far as it possibly can,
	and when it finds no more directories, it works its
	way back up to a level with directories in it and starts
	the process of going down again.

	Methods:

		getQueueOfFiles( files ) - this method puts an
		array of files into a queue. I had this method
		so that I could easily create queues out of
		directories files.

*/

	public static void main ( String[] args )
	{
		int count;
		FixedSizeQueue holdQ;
		File holdFile;
		boolean isEmpty;
		FixedSizeStack levels;
		FixedSizeQueue Q1;
		String string;

		count = 0;
		string = "";

		levels = new FixedSizeStack(100);

		holdFile = new File("C:/");

		Q1 = new FixedSizeQueue(1);

		Q1.enQueue(holdFile);

		levels.push(Q1);

		Q1 = getQueueOfFiles(holdFile.listFiles());

		levels.push(Q1);

		while( levels.size() > 1 )
		{
			holdQ = (FixedSizeQueue)levels.peek();
			isEmpty = false;

			if(holdQ.size() != 0)
			{
				holdFile = (File)holdQ.peek();
				Q1 = getQueueOfFiles(holdFile.listFiles());

			}//if(holdQ.size() != 0)

			else
			{
				isEmpty = true;
				levels.pop();

			}//else

			if( Q1.size() == 0 && levels.size() > count )
			{
				holdFile = (File)holdQ.peek();
				count = levels.size();
				string = holdFile.getPath();

			}//if( Q1.size() == 0 &&  levels.size() > count )

			if( isEmpty == false )
			{
				holdQ = (FixedSizeQueue)levels.peek();

				holdQ.deQueue();

				levels.pop();

				levels.push(holdQ);

			}//if(isEmpty == false)

			if( Q1.size() != 0 && isEmpty == false )
			{
				holdQ = (FixedSizeQueue)levels.peek();
				levels.push(Q1);

			}//if( Q1.size() != 0 && isEmpty ==false )

		}//while( levels.size() > 1 )

		System.out.println("deepest level: " + count);
		System.out.println("file path: " + string);

	} //main

	public static FixedSizeQueue getQueueOfFiles( File[] files )
	{
		int length;
		FixedSizeQueue queue;

		length = 0;

		if( files != null )
		{
			queue = new FixedSizeQueue(files.length);
			length = files.length;

		}//if( files != null )

		else
		{
			queue = new FixedSizeQueue(1);

		}//else

		for( int i = 0; i < length && files != null; i++ )
		{
			if( files[i].isDirectory() == true )
			{
				queue.enQueue(files[i]);

			}//if( files[i].isDirectory() == true )

		}//for( int i = 0; i < length && files != null; i++ )

		return queue;

	}//getQueueOfFiles

} //class