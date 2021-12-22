package notes;
import java.util.Iterator;

public class Queues 
{
	public static void main(String[] args) 
	{
		Queue<Integer> queue = Math.random() < 0.5 ? new AQueue<Integer>(): new RQueue<Integer>();
		int num = args.length == 1 ? Integer.parseInt(args[0]) : 11;
		System.out.println("enqueue");
		
		for (int i = 0; i < num; ++i) 
		{
			queue.enqueue(i);
			System.out.print(i + " => ");
			for (Integer k : queue) 
			{
				System.out.print(k + " ");
			}
			System.out.println();
		}

		Integer j;
		System.out.println("dequeue");
		while ((j = queue.dequeue()) != null) 
		{
			System.out.print(j + " => ");
			for (Integer k : queue) 
			{
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
}

interface Queue<E> extends Iterable<E> 
{
	E dequeue();
	void enqueue(E data);
}

class AQueue<E> implements Queue<E> //Array-Based
{
	private Object[] queue = new Object[10];
	private int head; 
	private int tail;
	
	private class QueueIterator<E> implements Iterator<E> 
	{
		private int curr = head;	

		public boolean hasNext() 
		{
			return curr < tail;
		}
		
		public E next() 
		{
			return (E)queue[curr++];
		}
	}
	
	public E dequeue() 
	{
		if (queue.length > 10 && (queue.length + tail - head) % queue.length <= queue.length / 3) //less than 1/3 of the array is full
		{
			shrink(); //make manageable
		}
		
		E temp = null;
		
		if (head != tail) //if queue not empty
		{
			temp = (E)queue[head];
			head = (head + 1) % queue.length;
		}
		
		return temp;
	}
	
	public void enqueue(E data) 
	{
		if (head == (tail + 1) % queue.length) //if queue is full, grow then add data
			grow();
		
		//if there is room to add data, add it
		queue[tail] = data;
		tail = (tail + 1) % queue.length;
	}
	
	private void grow() 
	{
		Object[] temp = new Object[queue.length * 2]; //create a new array double the length of queue
		for (int i = 0; i < queue.length; ++i) 
		{
			temp[i] = queue[(head + i) % queue.length];
		}
		
		head = 0; 
		tail = queue.length - 1;
		queue = temp;
		
	}
	
	public Iterator<E> iterator() 
	{
		return new QueueIterator<E>();
	}
	
	private void shrink() 
	{
		Object[] temp = new Object[queue.length / 2]; //create a new array half the length of queue
		for (int i = 0; i < temp.length; ++i) 
		{
			temp[i] = queue[(head + i) % queue.length];
		}
		
		head = 0;
		tail = queue.length / 3;
		queue = temp;
	}	
}

class RQueue<E> implements Queue<E> 
{
	private Node<E> head;
	private Node<E> tail;
	
	private class Node<T> 
	{
		private T data;
		private Node<T> next;
		
		private Node(T data) 
		{
			this.data = data;
		}
	}
	
	public E dequeue() 
	{
		E temp = null;
		if (head != null) //if head is pointing to a valid node
		{
			temp = head.data;
			if (head == tail) //if that node is the only node
			{
				head = tail = null; //make queue empty
			}
			else 
			{
				head = head.next; //replace head with head.next, thus removing the current value of head from the queue
			}
		}
		
		return temp;
	}
	
	public void enqueue(E data) 
	{
		Node<E> temp = new Node<E>(data);
		
		if (head == null) //if queue is empty... head isn't pointing to a node
		{
			head = tail = temp; //make head and tail both point to temp... adds first item
		}
		else 
		{
			tail.next = temp; //adds temp to the end of the queue
			tail = tail.next; //make tail point at the newly added value at the end of the queue
		}	
	}
	
	public Iterator<E> iterator() 
	{
		return new Iterator<E>() 
		{
			public boolean hasNext() 
			{
				return curr != null;
			}
			public E next() 
			{
				E temp = curr.data;
				curr = curr.next;
				return temp;
			}
			private Node<E> curr = head;
		}
	;}
	}