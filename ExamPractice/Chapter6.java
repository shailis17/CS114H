package ExamPractice;
import java.util.Scanner;

public class Chapter6 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter String: ");
		String s = sc.next();
		if(isAnBn(s))
			System.out.println("The string \"" + s + "\" is in the language");
		else
			System.out.println("The string \"" + s + "\" is not in the language");
	}
	
	//A^nB^n language
	/*
	 * L = {w : w is of the form AnBn for some n ≥ 0} ==> 
	 * 		- String that consists of n consecutive A’s followed by n consecutive B’s
	 * < legal-word > = empty string | A < legal-word > B
	 * 
	 * Recognition Algorithm:
		 * isAnBn(w)
				if (the length of w is zero)
					return true
				else if (w begins with the character A and ends with the character B) 
				{
					return isAnBn(w minus its first and last characters)
				}
				else 
				{
				return false
				}
	 * 
	 */
	
	private static boolean isAnBn(String s)
	{
		if(s.length() == 0)
			return true;
		if(s.charAt(0) == 'A' && s.charAt(s.length()-1) == 'B')
			return isAnBn(s.substring(1,s.length()-1));
		return false;
	}
	
	}
