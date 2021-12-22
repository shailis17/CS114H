package ExamPractice;

/*
 * CH 3: Recursion ⇒ definitely expect questions ⇒ BE COMFORTABLE
		- Write and implement a recursive method
		- Inbetween factorial AND tower  ⇒ medium difficulty
		- Binary search
		- Nothing about k smallest element
 */

public class Chapter3 
{
	public static void main(String[] args)
	{
		System.out.println(factorial(4));
		System.out.println(writeBackwards("Hello"));
		System.out.println(fib(7));
		System.out.println(parade(4));
		System.out.println(choose(3,3) + " "  + choose(3,0) + " " + choose(3,4) + " " + choose(7,3));
		int[] a = {1,2,3,6,7,8,9};
		System.out.println(bsearch(a, 4, 0, 6) + " " + bsearch(a, 7, 0, 6));
	}
	
	private static int factorial(int n)
	{
		/*
		 * Recursive Definition:
		 * if n = 0 ==> factorial(n) = 1;
		 * if n > 0 ==> factorial(n) = n * factorial(n-1)
		 */
		
		if(n == 0)
			return 1;
		return n * factorial(n-1);
	}
	
	private static String writeBackwards(String s)
	{
		/*
		 * Recursive Solution:
		 * last letter + last letter of the string after removing the last letter
		 */
		
		if(s.length() == 1)
			return s;
		return s.substring(s.length() - 1) + writeBackwards(s.substring(0, s.length() -1));
	}
	
	private static int fib(int n)
	{
		/*
		 * 1 + 1 + 2 + 3 + 5 + 8 + 13 + ... ==> fib(5) = 5; fib(6) = 8; fib(7) = 13
		 * Recursive Definition:
		 * fib(n) = fib(n-1) + fib(n-2)
		 * if n == 1 || 2 ==> fib(n) = 1
		 * if n > 2		  ==> fib(n) = fib(n-1) + fib(n-2)
		 */
		
		if(n == 1 || n == 2)
			return 1;
		return fib(n-1) + fib(n-2);
	}
	
	private static int parade(int n)
	{
		/*
		 * Parade Rules: 
		 * 	- there are bands and floats in the parade
		 * 	- two bands cannot walk next to each other... but two floats can
		 *  - BFFFFB, FFBFB, BFBFBFBFFFB
		 *  
		 *  How many ways can you organize the parade?
		 *  
		 *  Special Cases:
		 *  parade with length = 1 ==> parade(1) = 2 since its either a band or a float
		 *  parade with length = 2 ==> FF, BF, FB ==> parade(2) = 3
		 *  
		 *  so... parade(n) = parade(n-1) + parade(n-2) 
		 *   - parade(3) = FFF, FFB, FBF, BFF, BFB = 5
		 *   - parade(4) = FFFF, FFFB, FFBF, FBFF, FBFB, BFFF, BFBF, BFFB = 8 ==> 3 + 5 
		 * 
		 */
		
		if(n == 1)
			return 2;
		if(n == 2)
			return 3;
		return parade(n-1) + parade(n-2);
	}
	
	private static int choose(int n, int k)
	{
		/*
		 * choose k out of n things
		 * 
		 * Recursive Definition:
		 * c(n, k) = c(n-1, k-1) + c(n-1, k)
		 * 
		 * Special Cases:
		 * 	- c(n, k) = 1 if n = k
		 * 	- c(n, 0) = 1
		 * 	- c(n, k) = 0 if k > n
		 */
		
		if(n == k)
			return 1;
		if(k == 0)
			return 1;
		if(k > n)
			return 0;
		return choose(n-1, k-1) + choose(n-1, k);
	}
	
	//binary search ==> repeatedly splits array in half to search for value... assume array is sorted
	//				==> returns index where value is present				
	public static int bsearch(int[] a, int val, int left, int right) 
	{
		if (left <= right) //if not empty... do something
		{
			int mid = (left+right) / 2;
			
			if(a[mid] == val)
			{
				return mid;
			}
			else if (val < a[mid]) //keeps searching the first half until finished
			{
				return bsearch(a, val, left, mid-1);
			}
			else //now searches right half
			{
				return bsearch(a, val, mid+1, right);
			}
		}
		return -1;
	}
}

