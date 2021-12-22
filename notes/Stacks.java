package notes;
import java.util.Iterator;

public class Stacks 
{
	public static void main(String[] args)
	{
		//Stack<Integer> stack = Math.random() < 0.5 ? new Astack<Integer>() : new Rstack<Integer>();
		Stack<Integer> stackA = new Astack<Integer>();
		Rstack<Integer> stackR = new Rstack<Integer>();
		
		System.out.println("Astack output!!!");
		System.out.println("Push:");
		for (int i = 0; i < 11; ++i) 
		{
			stackA.push(i);
			System.out.print(i + " => ");
			for (Integer k : stackA) 
				System.out.print(k + " ");
			System.out.println();
		}
		System.out.println("Pop:");
		Integer j;
		while ((j = stackA.pop()) != null) 
		{
			System.out.print(j + " => ");
			for (Integer k : stackA) 
			{
				System.out.print(k + " ");
			}
			System.out.println();
		}
		
		System.out.println("\nRstack output!!!");
		System.out.println("Push:");
		for (int i = 0; i < 11; ++i) 
		{
			stackR.push(i);
			System.out.print(i + " => ");
			for (Integer k : stackR) 
				System.out.print(k + " ");
			System.out.println();
		}
		System.out.println("Pop:");
		while ((j = stackR.pop()) != null) 
		{
			System.out.print(j + " => ");
			for (Integer k : stackR) 
				System.out.print(k + " ");
			System.out.println();
		}
	}
}

interface Stack<E> extends Iterable<E>
{
	E pop(); //remove recent item added; returns an E value (arbitrary data type)
	void push(E data); //add new item to the stack
}

class Astack<E> implements Stack<E> //Array Based
{	
	private Object[] stack = new Object[10];
	private int top; // = 0 by default
	
	private class StackIterator<E> implements Iterator<E> 
	{
		public boolean hasNext() 
		{
			return curr > 0;
		}
		public E next() 
		{
			return (E)stack[--curr];
		}
		private int curr = top;
	}
	
	public Iterator<E> iterator() 
	{
		return new StackIterator<E>();
	}
	
	public void push(E data) // add data to the stack
	{
		if (top >= stack.length) //check to see if you need more spots
			grow();
	
		stack[top++] = data;
	}
	
	private void grow() //if stack is too small to keep adding... make it bigger
	{
		Object[] temp = new Object[stack.length * 2];
		
		for (int i = 0; i < stack.length; ++i) 
		{
			temp[i] = stack[i];
		}
		stack = temp;
	}
	
	public E pop() //remove items from stack one at a time
	{
		if (stack.length > 10 && top <= stack.length / 3) //makes stack more manageable at smaller length
			shrink();
		
		E temp = null;
		
		if (top > 0) 
		{
			temp = (E)stack[--top];
		}
		return temp;
	}
	
	public void shrink() //gets rid of unwanted tailing spots
	{
		Object[] temp = new Object[stack.length / 2];
		
		for (int i = 0; i < temp.length; ++i)
			temp[i] = stack[i];
		
		stack = temp;
	}
}

class Rstack<E> implements Stack<E> //Reference-based
{
	private Node<E> head;
	
	private class Node<T>
	{		
		private Node(T data)
		{
			this.data = data;
		}
		
		private T data;
		private Node<T> next; 
	}
	
	public Iterator<E> iterator() 
	{
		return new Iterator<E>() 
		{
			public boolean hasNext()  //from Iterator class
			{
				return curr != null;
			}
			
			public E next() //from Iterator class 
			{
				E temp = curr.data;
				curr = curr.next;
				return temp;
			}
			
			Node<E> curr = head;
		};
			
	}
	
	public E pop()
	{
		E temp = null;
		
		if(head != null) //if not empty, do something
		{
			temp = head.data;
			head = head.next; //updates head to point to the next node... removes current head node 
		}
		
		return temp; //returns data/value removed
	}
	
	public void push(E data)
	{
		Node<E> temp = new Node<E>(data);
		temp.next = head; // temp.next points to head
		head = temp;	//head points to temp
	}
}

