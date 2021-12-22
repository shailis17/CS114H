package ExamPractice;
import java.util.Scanner;

public class PracticeMidterm 
{
	public static void main(String[] args)
	{
		/*
		 * Consider the following alphabet and language:
				Σ = {0, 1}
				L = {w : w ∈ Σ∗	and w = w′} where w is a string and w′ is the reverse of that string. 
				Implement a recursive method (not a whole class) that recognizes strings in this language.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string: ");
		String test = sc.next();
		if(isReversable(test))
			System.out.println("is in the language");
		else
			System.out.println("not in the language :(");
	}
	
	public static boolean isReversable(String s)
	{
		if(s.charAt(0) == '0' || s.charAt(0) == '1')
		{
			if(s.length() == 0 || s.length() == 1)
				return true;
			else //010	01010  11011
			{
				if(s.charAt(0) == s.charAt(s.length() -1))
					return isReversable(s.substring(1,s.length()-1));
				else
					return false;
			}
		}
		return false;
	}
}
