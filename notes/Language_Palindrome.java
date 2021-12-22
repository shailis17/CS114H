package notes;

//Languages  09/28 ==> Chapter 6
/*
 * Palindromes = {w : w reads the same left to right as right to left} //language definition
 * < pal > = empty string | < ch > | a < pal > a | b  < pal > b | ... | Z < pal > Z
 * < ch > = a | b | ... | z | A | B | ... | Z 
 * 
 * Recognition algorithm:
		isPal(w)
			if (w is the empty string or w is of length 1) 
			{
				return true
			}
			else if (w’s first and last characters are the same letter ) 
			{
				return isPal(w minus its first and last characters)
			}
			else 
			{
				return false
			}
 */

public class Language_Palindrome 
{
	public static void main (String[] args)
	{
		if(palindrome("racecar")) 
			System.out.println("It is a palindrome!"); //this will print
		else
			System.out.println("Not a palindrome");  //if palindrome("happy") ==> this line will print
	}
	
	private static boolean palindrome(String s)
	{
		if(s.length() <= 1) // "e" and "" are palindromes
			return true;
		else if (s.charAt(0) == s.charAt(s.length() - 1))  // if the first and last char of the string are the same
		{
			return palindrome(s.substring(1, s.length() - 1));  //call palindrome with the String after removing the first and last letter
		}
		return false; //if it is not a one letter or empty && the first and last letters are not the same ==> then it is NOT a palindrome
	}
}

//Kapleau's
//L(pal) = { w | w == w'}      //language definition
//<P> => a<P>a | b<P>b | aa | bb | a | b        //grammer; production rules; non terminal symbols
//^ equivalent to:
//<P> => a<P>a
//<P> => b<P>b .... so on

//'abba' \in L(pal)

//<P> -> a<P>a
// -> a bb a
// -> abba

//'abab' \in L(pal)

//<P> -> no rule where it starts with a and ends with b
//'abab' \notin L(pal)


