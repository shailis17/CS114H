package notes;
import java.util.Iterator;
import java.util.Random;

public class IteratingSortedList 
{
	public static void main(String[] args) 
	{
		List<Integer> list = new SortedList<Integer>();
		Random rand = new Random(1);
		int n, num = args.length == 1 ? Integer.parseInt(args[0]) : 11;

		//test insert
		System.out.println("insert");
		for (int i = 0; i < num; ++i) 
		{
			n = rand.nextInt(num);
			list.insert(n);
			System.out.print(n + " => ");
			for (Integer j : list) 
				System.out.print(j + " "); //print out list after inserting n
			System.out.println();
		}
		
		//test search
		System.out.println("\nSearch for 3: " + list.search(3));
		System.out.println("Search for 7: " + list.search(7));
		
		//test retrieve
		System.out.println("\nRetrieve index 5: " + list.retrieve(5));
		
		//test remove
		rand = new Random(1);
		System.out.println("\nremove");
		for (int i = 0; i < num; ++i) 
		{
			n = rand.nextInt(num);
			list.remove(n);
			System.out.print(n + " => ");
			for (Integer j : list) 
				System.out.print(j + " "); //print out list after removing n
			System.out.println();
		}
	}
}

abstract class List<E> implements Iterable<E>  
{
	protected class Node<T> 
	{	
		protected T data;
		protected Node<T> next;
		
		protected Node(T data) 
		{
			this.data = data;
		}
	}
	
	public abstract void insert(E data);
	public abstract void remove(E data);
	public abstract E retrieve(int index);
	public abstract boolean search(E data);
	protected Node<E> head;
}

class SortedList<E extends Comparable<? super E>> extends List<E> 
{
	public void insert(E data) //inserts and sorts
	{
		Node<E> temp = new Node<E>(data); //set Node to the data that will be inserted into the list
		if (head == null || data.compareTo(head.data) < 0) //empty list or value is less than what head is pointing to
		{
			temp.next = head; //next points to null || next points to larger head value
			head = temp; //head points to temp
		}
		else 
		{
			Node<E> curr = head;
			while (curr.next != null && data.compareTo(curr.next.data) > 0) //finds the first spot where data is greater than the current node
				curr = curr.next;  //traverses the list
			temp.next = curr.next; //temp.next points to curr.next
			curr.next = temp;		//curr.next points to temp
		}
	}
	
	public Iterator<E> iterator() 
	{
		return new Iterator<E>() 
		{
			public boolean hasNext()  //determines if the node can point to a next value
			{
				return curr != null;
			}
			
			public E next()  //returns the next value of the curr node
			{
				E temp = curr.data;
				curr = curr.next;
				return temp;
			}
			
			private Node<E> curr = head;
		};
	}
	
	public void remove(E data) 
	{
		if (head != null)  //if list is not empty... do something
		{
			if (data.compareTo(head.data) == 0) //if head is pointing to a value equal to data
			{
				head = head.next;
			}
			else 
			{
				for (Node<E> curr = head; curr.next != null; curr = curr.next) 
				{
					if (data.compareTo(curr.next.data) == 0) 
					{
						curr.next = curr.next.next; //make curr.next = the value two nodes down
						break;
					}
				}
			}
		}
	}
	
	public E retrieve(int index) 
	{
		Node<E> curr = head;
		int i = 0;
		
		while (i < index && curr != null) 
		{
			curr = curr.next;
			++i;
		}
		
		return curr != null ? curr.data : null; //if curr != null, return curr.data... else return null
	}
	
	public boolean search(E data) 
	{
		for (Node<E> curr = head; curr != null; curr = curr.next) //traverse all nodes in the sorted list until you find a node pointing to the value being searched
		{
			if (data.compareTo(curr.data) == 0) 
				return true;
		}
		return false; //return false if data not in the sorted list
	}
}