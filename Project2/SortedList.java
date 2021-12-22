package Project2;
import java.util.Iterator;
import java.util.Random;

public class SortedList <E extends Comparable<? super E>> extends List<E>
{
	//test recursive methods in main
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
	
	//Iterator (not recursive)
	@Override
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
		};
	}

	//public insert method calls a private recursive insert method
	@Override
	public void insert(E data) 
	{
		Node<E> temp = new Node<E>(data);
		head = insert(head, temp);		
	}
	
	//recursive insert
	private Node<E> insert(Node<E> curr, Node<E> node)
	{
		if (curr == null || node.data.compareTo(curr.data) < 0) //empty list or before curr
		{
			node.next = curr;
			return node;
		}
		//if inserting after head/curr ==> curr.next value is less than value being inserted OR is empty
		if(curr.next == null || node.data.compareTo(curr.next.data) > 0)
		{
			curr.next = insert(curr.next, node);
			return curr;
		}
		//head/curr == node/temp data
		node.next = curr.next;
		curr.next = node;
		return curr;
	}

	//public remove method calls a private recursive remove method
	@Override
	public void remove(E data) 
	{
		Node<E> temp = new Node<E>(data);
		head = remove(head, temp);	
	}
	
	//recursive remove
	private Node<E> remove(Node<E> curr, Node<E> node) 
	{
		if (curr != null)  //if list is not empty... do something
		{
			if (node.data.compareTo(curr.data) == 0) //if head/curr is pointing to a value equal to temp/node
			{
				curr = curr.next;
			}
			else
			{
				if(curr.next != null)
				{
					if(node.data.compareTo(curr.next.data) == 0)
					{
						curr.next = curr.next.next;
						return curr;
					}
				}
				remove(curr.next, node);
			}
		}
		
		return curr;
	}

	@Override
	public E retrieve(int index) 
	{
		int i = 0;
		return retrieve(head, index, i);
	}

	private E retrieve(Node<E> curr, int index, int i) 
	{
		if(i < index && curr != null) //while (i < index && curr != null) 
		{
			++i;
			return retrieve(curr.next, index, i);
		}
		
		//base case ==> i = index && curr = null
		return curr != null ? curr.data : null; //if curr != null, return curr.data... else return null
	}

	@Override
	public boolean search(E data) 
	{
		return search(head, data);
	}

	private boolean search(Node<E> curr, E data) 
	{
		if(curr != null)	//if curr has a data value... i.e. if list is not empty
		{
			if(data.compareTo(curr.data) == 0) //check if it is equal to data being searched
				return true;
			else								//check again with curr.next
				return search(curr.next, data); 
		}
		return false;		//return false if data not in the sorted list
	}	
}
