package notes;

public class recursiveMethods 
{
	public static void main(String[] args) //used to test the methods
	{
		//test choose
		int x = choose(6,2);
        System.out.println(x);
        
        //test fact
        x = fact(6);
        System.out.println(x);
        
        
	}
	
	//like nCk
	public static int choose(int n, int k) 
	{
		if (k > n) 
			return 0;
		else if (k == 0 || k == n) 
			return 1;
		
		return choose(n-1, k-1) + choose(n-1, k);
	}
	
	//factorial
	public static int fact(int n) 
	{
		if (n == 0) 
			return 1;
		return n * fact(n-1);
	}
	
	//fibonacci sequence
	public static int fibo(int n) 
	{
		if (n == 0 || n == 1) 
			return n;
		return fibo(n-1) + fibo(n-2);
	}
	
	//recursive power method
	public static int pow(int x, int n) 
	{
		if (n == 0) 
			return 1;
		else if (n % 2 == 0) 
			return pow(x*x, n/2);
		else 
			return x * pow(x*x, n/2);
	}
	
	//iterative power method
	//this is actually more less efficient than the recursive version ... weird 
	public static int powI(int x, int n)
	{
		int ans = 1;
		
		while(n-- > 0)
			ans *= x;
		
		return ans;
	}
	
	//reverse a String
	//add the first letter to the end 
	public static String reverse(String s) 
	{
		if (s.length() > 0) 
			return reverse(s.substring(1)) + s.charAt(0);
		return s;
	}
	
	//0 + 1 + 2 + 3 + 4 + ... + n
	public static int sum(int n) 
	{
		if (n == 0) 
			return 0;
		return n + sum(n-1);
	}
	
	//towers of hanoi
	public static void tower(int n, char src, char dst, char use) 
	{
		if (n > 0) 
		{
			tower(n-1, src, use, dst);
			System.out.println("Move disk " + n + " from " + src + " to " + dst);
			tower(n-1, use, dst, src);
		}
	}
}
