package notes;
//09/30
//Java identifier

import java.util.Scanner;

/*
 * JavaIds = {w : w is a legal Java identifier ==> ex: num, s, student1, after3hours
 * <identifier> = <letter> | <identifier><letter> | <identifier><digit> ==> can't start with a number
 * 							<LETTER, LETTER>letter OR <LETTER, DIGIT>letter  OR <LETTER, DIGIT>DIGIT
 * <letter > = a | b | ... | z | A | B | ...| Z | _ | $
 * <digit > = 0 | 1 | ... | 9
 * 
 * 		//Kapleau's
		//<ID> => <LETTER><SYMBOL> | <LETTER>
		//<SYMBOL> => <LETTER> | <DIGIT> | <LETTER><SYMBOL> | <DIGIT><SYMBOL> 
		//<LETTER> => A|...|Z|a|...|z| _
		//<DIGIT> => 0|...|9
 * Recognition algorithm
		isId(w)
			if (w is of length 1) 
			{
				if (w is a letter) 
					return true
				else
					return false
			}
			else if (the last character of w is a letter or a digit) 
			{
				return isId(w minus its last character)
			}
			else 
			{
				return false
			}
 */

public class Language_JavaIdentifier 
{
	private static String s;
	private static int i;
	
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String: ");
		s = sc.next();
		if(id() && i==s.length())
			System.out.println("The string \"" + s + "\" is in the language");
		else
			System.out.println("The string \"" + s + "\" is not in the language");
		
		System.out.println("Enter String: ");
		String s2 = sc.next();
		if(RId(s2))
			System.out.println("The string \"" + s2 + "\" is in the language");
		else
			System.out.println("The string \"" + s2 + "\" is not in the language");
	}
	
	private static boolean digit()
	{
		if(i<s.length() && '0' <= s.charAt(i) && s.charAt(i) <= '9')
		{
			i++;
			return true;
		}
		return false;
	}

	private static boolean letter()
	{
		if(i<s.length() && ('A' <= s.charAt(i) && s.charAt(i) <= 'Z' || 'a' < s.charAt(i) && s.charAt(i) <= 'z'))
		{
			i++;
			return true;
		}
		return false;
	}
	
	private static boolean symbol() 
	{
		if(letter() || digit())
		{
			if(symbol())
				return true;
			
			return true;
		}
		return false;
	}
	
	private static boolean id()
	{
		if(letter())
		{
			if(symbol())
			{
				return true;
			}
			return true;
		}
		return false;
	}
	
	
	//recursive ==> textbook:
	private static boolean RId(String x)
	{
		char c = x.charAt(x.length() - 1);
		
		if(x.length() == 1)
		{
			if ('A' <= c && c <= 'Z' || 'a' < c && c <= 'z')
				return true;
				
			return false;
		}
		if('A' <= c && c <= 'Z' || 'a' < c && c <= 'z' || ('0' <= c && c <= '9') )
			return RId(x.substring(0,x.length()-1));
		return false;
	}
}
