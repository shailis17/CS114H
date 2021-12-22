package Project4;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> 
{
	private Vector<E> vector;

	public static void main(String[] args)
	{
		BinaryTree<Integer> tree = new BinarySearchTree<Integer>();
		Random rand = new Random(1);
		int num = args.length == 1 ? Integer.parseInt(args[0]) : 11;
		long start, stop;
		
		System.out.println("insert");
		start = System.currentTimeMillis();
		for (int i = 0; i < num; ++i) 
		{
			int n = rand.nextInt(num);
			tree.insert(n);
			System.out.print(n + ": ");
			for (Integer j : tree) 
			{
				System.out.print(j + " ");
			}
			System.out.println();
		}
		stop = System.currentTimeMillis();
		System.out.println(stop-start);
		
		// System.out.println("height: " + ((BinarySearchTree)tree).height());
		rand = new Random(1);
		System.out.println("search");
		start = System.currentTimeMillis();
		for (int i = 0; i < num; ++i) 
		{
			int n = rand.nextInt(num);
			tree.search(n);
			System.out.println(n + (tree.search(n) ? " " : " not ") + "found");
		}
		System.out.println();
		for (int i = 0; i < num/2; ++i) 
		{
			int n = rand.nextInt(num);
			tree.search(n);
			System.out.println(n + (tree.search(n) ? " " : " not ") + "found");
		}
		stop = System.currentTimeMillis();
		System.out.println(stop-start);
		
		// rand = new Random(1);
		System.out.println("remove");
		start = System.currentTimeMillis();
		for (int i = 0; i < num; ++i) 
		{
			int n = rand.nextInt(num);
			tree.remove(n);
			System.out.print(n + ": ");
			for (Integer j : tree) 
			{
				System.out.print(j + " ");
			}
			System.out.println();
		}
		stop = System.currentTimeMillis();
		System.out.println(stop-start);
		System.out.println(tree.root == null);
	}
	
	@Override
	public Iterator<E> iterator() 
	{
		vector = new Vector<E>();
		traverse(root);
		return vector.iterator();
	}
	
	private void traverse(Node<E> curr) 
	{
		if (curr != null) 
		{
			traverse(curr.left);
			vector.add(curr.data);
			traverse(curr.right);
		}
	}
	
	private Node<E> findIOP(Node<E> curr) 
	{
		curr = curr.left;
		while (curr.right != null) 
		{
			curr = curr.right;
		}
		return curr;
	}

	@Override
	public void insert(E data) 
	{
		Node<E>temp = new Node<E>(data);
		root = insert(root, temp);
	}

	private Node<E> insert(Node<E> curr, Node <E> node)
	{
		if (curr == null)
		{
			return node;
		}
		else if (node.data.compareTo(curr.data) <= 0) //insert in left if node.data less than curr.data
		{
			if (curr.left == null) //if curr doesn't have left child, insert
				curr.left = node;
			else //curr has left child, make left child root and create a subtree
				curr.left = insert(curr.left, node);
			
			return curr;
		}
		else //insert in right if node.data greater than curr.data
		{  
			if (curr.right == null) //if curr doesn't have right child
				curr.right = node;
			else //curr has right child, make right child root and create a subtree
				curr.right = insert(curr.right, node);
			
			return curr;
		}
	}
	
	@Override
	public void remove(E data) 
	{
		Node<E>temp = new Node<E>(data);
		root = remove(root, temp);
	}
	
	public Node<E> remove(Node<E> curr, Node<E> node)
	{
		if(curr != null) //if tree not empty... do something
		{
			if (node.data.compareTo(curr.data) == 0) // if curr is node that we want to delete
			{
				if(curr.left == null && curr.right == null)
					curr = null;
				else if(curr.left == null || curr.right == null)
				{
					if(curr.left != null)
						curr = curr.left;
					else
						curr = curr.right;
				}
				else //swap with iop (easier to delete) and then call remove on left subtree to remove iop (which now has data to be deleted)
				{
					Node<E> iop = findIOP(curr);
					E temp = iop.data;
					iop.data = curr.data;
					curr.data = temp;
					
					curr.left = remove(curr.left, node); //iop is in the left subtree
				}
			}
			else if(node.data.compareTo(curr.data) < 0) //if curr < node, check left child
				curr.left = remove(curr.left, node);
			else									//if curr > node, check right child
				curr.right = remove(curr.right, node);
		}
		
		return curr;
	}
	
	@Override
	public boolean search(E data) 
	{
		Node<E>temp = new Node<E>(data);
		return search(root, temp);
	}

	private boolean search(Node<E> curr, Node<E> node) 
	{
		if(curr != null)
		{
			if(node.data.compareTo(curr.data) == 0) //if curr == node 
				return true;
			else if(node.data.compareTo(curr.data) < 0) //if curr < node, check left child
				return search(curr.left, node);
			else									//if curr > node, check right child
				return search(curr.right, node);
		}
		
		return false;
	}
}
