package ExamPractice;

public class Chapter5<E> 
{
	//Node Class --> special class used to create Reference-Based Linked Lists
	protected class Node<T> //anonymous inner class
	{
		private Node<T> next;
		private T data;
		private Node<T> prev; //used for doubly linked list
		
		private Node(T data)
		{
			this.data = data;
		}
		
		/*
		 * private Node(T data, Node<T> n)
		 * {
		 * 		this.data = data;
		 * 		this.next = n;
		 * }
		 */
		
		// can have other constructors, accessors/mutators (setters/getters) if you want... 
		// kinda unnessacary based on how Kapleau teaches us 
		// 					==> curr.next and curr.next.data allows direct access
	}
	
	private Node<E> head; //reference variable ==> refers to the first node in the list; exists as null when list is empty
	/*
	 * head = new Node(); // Don’t really need to use new here
	 * head = null; // since we lose the new Node object here
	 */
	private Node<E> temp; //place holder
	private Node<E> curr; //another ref. var. that is commonly used
	
	{
	//Deleting a Node from a Linked List
	// 2	 5		8
	//head	curr		head   curr
	curr = curr.next; // 2		8
	
	//SPECIAL CASE: deleting the first Node
	// 2	 5		8
	//head	curr		head   curr
	head = head.next; // 5		8
	
	//SPECIAL CASE: 
	//deleting the last node
	//using curr
	// 2    5	 8
	//head	   curr   		head   		curr
	curr = null; 		//    2		5
	//using tail ==> tail = null
	
	//Inserting a Node into a Linked List
	//SPECIAL CASE: before the first node (head)
	//temp--> 1
	// 2     5     8
	//head  				//   1       2     5     8
	temp.next = head;		//  temp	head
	head = temp;       		//  head
	
	//SPECIAL CASE: right after first node (head)
	//SPECIAL CASE: before the first node (head)
	//temp--> 3
	// 2     5     8
	//head  h.n				//   2       3     5     8
	temp.next = head.next;	// 	head	temp  h.n
	head.next = temp;       //  		h.n

	//SPECIAL CASE: Insert at the end
	//if curr == null
	// 2    5	 8
	//head	         curr  
	//temp--> 9
	curr = temp;
	//if curr.next == null
	// 2    5	 8
	//head	    curr    c.n
	curr.next = temp;
	
	Node<E> tail; //ref. var. for last Node
	//In a circular linked list tail.next = head;
	
	//Doubly Linked Lists
	//each Node is linked to 2 nodes, prev and next
	
	//Deleting a Node from a Doubly Linked List
	// 3	  5		 7		8    ....
	//head   c.p    curr   c.n		5		 7		8
	curr.next.prev = curr.prev;	//	c.n'p	curr
	curr.prev.next = curr.next;	//			curr   c.p'n			curr
	curr = curr.next;			//					curr  ===> 5     8
	
	//Inserting a Node into a Doubly Linked List
	//temp --> 6
	// 3	  5		 7		8    ....
	//head   c.p    curr   c.n		 5		6		7	
	curr.prev.next = temp;		  // c.p	temp
	temp.next = curr;			  //			   curr
	
}
}


