package notes;
import java.util.Random;

public class Midterm_dequeue 
{
	/*
	    Consider a slight variation on the queue. In this version new items can be added to and removed
		from either end. This data structure is commonly called a doubly-ended queue, or deque. Implement
		one method of each type (“insert” and “remove”) given in the Deque class. You may assume the
		DequeException class has been defined for you.
	 */
	
	public static void main(String[] args) 
	{
		Deque<Integer> deque = new Deque<Integer>();
		Random rand = new Random(1);
		System.out.println("insert");
		for (int i = 0; i < 10; ++i) 
		{
			int n = rand.nextInt(10);
			deque.insertAtTail(n);
			System.out.println(n);
		}
		System.out.println("remove");
		try 
		{
			while (true) 
			{
				Integer m = deque.removeFromHead();
				System.out.println(m);
			}
		}
		catch (DequeException e) 
		{
			System.out.println("done");
		}
	}
}

class Deque<E> 
{
	private Node<E> head; //defined
	private Node<E> tail; //defined
	
	private class Node<T> //defined in question
	{
		private Node(T data) 
		{
			this.data = data;
		}
		private T data;
		private Node<T> next;
		private Node<T> prev;
	}
	
	public void insertAtHead(E data) 
	{
		Node<E> temp = new Node<E>(data);
		if (head == null) //if queue is empty
		{
			head = tail = temp; //head and tail are same
		}
		else //insert before the head node
		{
			temp.next = head;
			head.prev = temp;
			head = head.prev;
		}
	}
	
	public E removeFromHead() throws DequeException 
	{
		E temp = null;
		if (head == null) //if queue is empty
		{
			throw new DequeException();
		}
		else if (head == tail) //remove both by setting to null
		{
			temp = head.data;
			head = tail = null;
		}
		else //delete head
		{
			temp = head.data;
			head = head.next;
		}
		return temp;
	}
	
	//*************************************************************//
	
	public void insertAtTail(E data) 
	{
		Node<E> temp = new Node<E>(data);
		if (tail == null) //if queue is empty
		{
			head = tail = temp;
		}
		else //insert after tail
		{
			temp.prev = tail;
			tail.next = temp;
			tail = tail.next;
		}
	}
	
	public E removeFromTail() throws DequeException 
	{
		E temp = null;
		if (tail == null) // Empty queue
		{
			throw new DequeException();
		}
		else if (head == tail) // only one item in queue
		{
			temp = head.data;
			head = tail = null;
		}
		else //remove from tail
		{
			temp = tail.data;
			tail = tail.prev;
		}
		return temp;
	}
}

class DequeException extends Exception //defined in question
{
	public DequeException() {}
	public DequeException(String msg) {super(msg);}
}