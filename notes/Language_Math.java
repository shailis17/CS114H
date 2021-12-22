package notes;
import java.util.Scanner;

public class Language_Math //Languages & Grammar 9/28
{
	private static String s;
	private static int i;
	
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String: ");
		s = sc.next();
		if (E() && i == s.length())
			System.out.println("The string \"" + s + "\" is in the language");
		else
			System.out.println("The string \"" + s + "\" is not in the language");
	}
   
	private static boolean E()
	{
		if (T())
		{
			if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
			{
				++i;
				if (E())
					return true;
				
				return false;
			}
			return true;
      }   
      return false;
	}
	
	private static boolean T()
	{
		if (F())
		{
			if (i < s.length() && (s.charAt(i) == '*' || s.charAt(i) == '/'))
			{
				++i;
				if (T())
					return true;   
            
				return false;
			}
			return true;
		}
		return false;
	}

	private static boolean F()
	{
		if(i < s.length() && '0' <= s.charAt(i) && s.charAt(i) <= '9')
		{
			++i;
			return true;
		}
		return false;
	}
}