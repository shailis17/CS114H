package notes;

//      60
//     /  \
//   20    70
//   / \
// 10   40
//     /  \
//   30    50

public class OrderBST 
{
	private static Node root;

	private static class Node 
	{
		private Node(int data) 
		{
			this.data = data;
		}
		private int data;
		private Node left;
		private Node right;
	}
	
	public static void main(String[] args) 
	{
		root = new Node(60);
		root.left = new Node(20);
		root.right = new Node(70);
		root.left.left = new Node(10);
		root.left.right = new Node(40);
		root.left.right.left = new Node(30);
		root.left.right.right = new Node(50);
		System.out.print("pre: ");
		preorder(root);
		System.out.print("\nin:  ");
		inorder(root);
		System.out.print("\npost:");
		postorder(root);
		System.out.println();
	}
	
	private static void inorder(Node curr) //left child, root, right child ==> left < root < right ==> in order
	{
		if (curr != null) 
		{
			inorder(curr.left);
			System.out.print(curr.data + " ");
			inorder(curr.right);
		}
	}
	
	private static void postorder(Node curr) //starts at the bottom of the left subtree and works up to root ==> left child, right child, root
	{
		if (curr != null) 
		{
			postorder(curr.left);
			postorder(curr.right);
			System.out.print(curr.data + " ");
		}
	}
	
	private static void preorder(Node curr) //start at the root and work your way down left subtree, then right subtree ==> root, left child, right child
	{
		if (curr != null) 
		{
			System.out.print(curr.data + " ");  //start at root
			preorder(curr.left); //left child = root of left subtree
			preorder(curr.right); //right child = root of right subtree
		}
	}
}