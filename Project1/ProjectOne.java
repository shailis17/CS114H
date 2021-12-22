package Project1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * Shaili Soni
 * CS114-H01
 * Project 1
 */

public class ProjectOne 
{
	private static char[][] maze;
	private static int startRow, startCol;
	
	public static void main(String[] args)
	{
		buildMaze(); //using samp.dat or maze.dat
		if(path(startRow, startCol))
			System.out.println("Success! Here is the path through the maze \n");
		else
			System.out.println("There is no solution to this maze \n");
		
		printMaze();
	}
	
	//builds maze array from File input
	private static void buildMaze()
	{
		Scanner sc = null;
		String[] dimensions = null;
		
		//get dimensions from first line
		try 
		{
			sc = new Scanner(new File("maze.dat")); // = new Scanner(new File(samp.dat))
			dimensions = sc.nextLine().split(" "); 
			maze = new char[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[0])];
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		//System.out.print(dimensions[0] + " by " + dimensions[1]);  ==> WORKS!
		
		//fill maze array
		int i = 0; 
		while(sc.hasNext())
		{
			maze[i] = sc.nextLine().toCharArray();
			i++;
		}	
		
		//find startRow and startCol
		start();
	}
	
	private static void start()
	{
		for(int r = 0; r < maze.length; r++)
		{
			for(int c = 0; c < maze[0].length; c++)
				if(maze[r][c] == '+')
				{
					startRow = r;
					startCol = c;
				}
		}
	}
	
	private static boolean path(int r, int c)
	{
		char left = 0, right = 0, up = 0, down = 0;
		//check surroundings
		if(c != 0) //left can only be defined if c != 0
			left = maze[r][c-1];
		if(c != maze[0].length - 1) //right can only be defined if c != maze[0].length - 1
			right = maze[r][c+1];
		if(r != 0) //up can only be defined if r != 0
			up = maze[r-1][c];
		if(r != maze.length -1)//down can only be defined if c != maze.length - 1
			down = maze[r+1][c];
		
		//is the exit in the surroundings? ==> BASE CASE
		if(left == '-' || right == '-' || up == '-' || down == '-')
		{
			maze[r][c] = '+';
			return true;
		}
		try //find the next position
		{
			maze[r][c] = '+';

			if(right == ' ' && path(r, c+1))
			{
				return true;
			}
			else if(left == ' ' && path(r, c-1))
			{
				return true;
			}
			else if(up == ' ' && path(r-1, c))
			{
				return true;
			}
			else if(down == ' ' && path(r+1, c))
			{
				return true;
			}
			else //dead end
			{
				maze[r][c] = '.';
				return false;
			}
		}
		catch(StackOverflowError e)
		{
			
		}
		return false;
	}
	
	private static void printMaze()
	{
		for(int r = 0; r < maze.length; r++)
		{
			for(int c = 0; c < maze[0].length; c++)
				System.out.print(maze[r][c]);
			System.out.print("\n");
		}
	}
}
