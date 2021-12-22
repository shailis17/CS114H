package notes;

import java.util.Arrays;
import java.util.Random;

public class Sorting 
{
	public static void main(String[] args) 
	{
		int num = 50; //used to be 10000 but changed to smaller number to show entire array in console
		Integer[] array = new Integer[num];
		Random rand;
		long start, stop; //time how long each test case takes ==> make array length 10000 (i.e. really big) to use effectively
		rand = new Random(1);
		
		//TEST BUBBLESORT:
		System.out.println("BUBBLESORT:");
		//Create unsorted array
		for (int i = 0; i < array.length; ++i) 
		{
			array[i] = rand.nextInt(num);
			System.out.print(array[i] + " ");
		}
		
		//call Bubblesort method from Sorts class and time
		start = System.currentTimeMillis();
		Sorts.bubbleSort(array);
		System.out.print("\n");
		
		//print sorted array:
		for(int x : array)
			System.out.print(x + " ");
		
		System.out.print("\n");
		stop = System.currentTimeMillis();
		
		//check to make sure it is properly sorted!
		for (int i = 0; i < array.length - 1; ++i) 
		{
			if (array[i] > array[i+1]) 
			{
				System.out.println("bubble fail");
				System.exit(0);
			}
		}
		System.out.println("bubble pass: " + (stop - start) + "\n");
		
		//TEST INSERTION SORT:
		System.out.println("INSERTION SORT");
		//create unsorted array
		rand = new Random(1);
		for (int i = 0; i < array.length; ++i) 
		{
			array[i] = rand.nextInt(num);
			System.out.print(array[i] + " ");
		}
		
		//call insert sort method & time
		start = System.currentTimeMillis();
		Sorts.insertSort(array);
		stop = System.currentTimeMillis();
		
		//print sorted array
		System.out.print("\n");
		for(int x : array)
			System.out.print(x + " ");
		
		//confirm array is sorted!
		for (int i = 0; i < array.length - 1; ++i) 
		{
			if (array[i] > array[i+1]) 
			{
				System.out.println("insert fail");
				System.exit(0);
			}
		}
		System.out.println("\ninsert pass: " + (stop - start));
		
		//TEST SELECTION SORT
		System.out.println("\nSELECTION SORT:");
		//create unsorted array
		rand = new Random(1);
		for (int i = 0; i < array.length; ++i) 
		{
			array[i] = rand.nextInt(num);
			System.out.print(array[i] + " ");
		}
		
		//call selection sort method and time
		start = System.currentTimeMillis();
		Sorts.selectSort(array);
		stop = System.currentTimeMillis();
		
		//print sorted array
		System.out.print("\n");
		for(int x : array)
			System.out.print(x + " ");
		
		//confirm array is sorted!
		for (int i = 0; i < array.length - 1; ++i) 
		{
			if (array[i] > array[i+1]) 
			{
				System.out.println("select fail");
				System.exit(0);
			}
		}
		System.out.println("\nselect pass: " + (stop - start) + "\n");
		
		//TEST MERGE SORT
		System.out.println("MERGE SORT:");
		//create unsorted array
		rand = new Random(1);
		for (int i = 0; i < array.length; ++i) 
		{
			array[i] = rand.nextInt(num);
			System.out.print(array[i] + " ");
		}
		
		//call sorting method and time
		start = System.currentTimeMillis();
		Sorts.mergeSort(array);
		stop = System.currentTimeMillis();
		
		//print sorted array
		System.out.print("\n");
		for(int x : array)
			System.out.print(x + " ");
		System.out.print("\n");
		//confirm array is sorted!
		for (int i = 0; i < array.length - 1; ++i) 
		{
			if (array[i] > array[i+1]) 
			{
				System.out.println("merge fail");
				System.exit(0);
			}
		}
		System.out.println("merge pass: " + (stop - start) + "\n");
		
		//TEST QUICK SORT
		System.out.println("QUICK SORT");
		//create unsorted array
		rand = new Random(1);
		for (int i = 0; i < array.length; ++i) 
		{
			array[i] = rand.nextInt(num);
			System.out.print(array[i] + " ");
		}
		
		//call sorting method and time
		start = System.currentTimeMillis();
		Sorts.quickSort(array);
		stop = System.currentTimeMillis();
		
		//print sorted array
		System.out.print("\n");
		for(int x : array)
			System.out.print(x + " ");
		System.out.print("\n");
		
		//confirm array is sorted!		
		for (int i = 0; i < array.length - 1; ++i) 
		{
			if (array[i] > array[i+1]) 
			{
				System.out.println("quick fail");
				System.exit(0);
			}
		}
		System.out.println("quick pass: " + (stop - start));
	}
}

class Sorts 
{
	public static <T extends Comparable<? super T>> void heapSort(T[] array) 
	{
		//What is a heap?
		/*
		 * a tree like data structure in which the value of the root node > either children
		 * both children are heaps
		 */
		//Max heap = a tree in which the parent value > either of it's children and both children are max heaps
		/*
		 * 		 	 10 
		 * 		   /	\
		 * 		  9		  7
		 *	 	 /	\    / \
		 *	 	8   5    4   3
		 *	   / \
		 *    6   2
		 */
		//How do we convert an array into a heap?
		/*
		 * this is mostly index manipulation
		 * https://www.cs.usfca.edu/~galles/visualization/HeapSort.html 
		 */
		//example with array:
		/*
		 * index: 0	1 2 3 4 5 6 7
		 * value: 4 2 7 5 1 8 3 6
		 * 
		 * 			 4
		 * 		   /   \
		 * 		  2      7
		 * 		 / \    / \
		 *      5   1  8   3
		 *     /
		 *    6
		 *    
		 * first round:
		 * 			 8	
		 * 		   /   \
		 * 		  6      4
		 * 		 / \    / \
		 *      5   1  7   3
		 *     /
		 *    2
		 */
	}
	
	public static <T extends Comparable<? super T>> void bubbleSort(T[] array) 
	{
		T temp;
		boolean sorted;
		for (int i = array.length - 1; i > 0; --i) 
		{
			sorted = true; //assumes the pass will be of a sorted array until proven otherwise
			for (int j = 0; j < i; ++j) 
			{
				if (array[j].compareTo(array[j + 1]) > 0) //finds unsorted adjacent data... SWAP
				{
					sorted = false;
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			if (sorted) //else... proven unsorted, do another pass to see if that was the last swap needed to sort
			{
				break;
			}
		}
	}
	
	public static <T extends Comparable<? super T>> void insertSort(T[] array) 
	{
		T temp;
		int j;
		for (int i = 1; i < array.length; ++i) //traverses the unsorted section
		{
			temp = array[i];
			for (j = i; j > 0; --j) //traverses the sorted section
			{
				if (array[j - 1].compareTo(temp) > 0) //determine where to insert
					array[j] = array[j - 1];
				else 
					break;
			}
			if (j < i) 
			{
				array[j] = temp; //complete swap
			}
		}
	}
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] array) 
	{
		if (array.length > 1) //split the array in half, recursive mergesort each of the halves
		{
			T[] left  = Arrays.copyOfRange(array, 0, array.length / 2);
			T[] right = Arrays.copyOfRange(array, array.length / 2, array.length);
			mergeSort(left);
			mergeSort(right);
			int i, l = 0, r = 0;
			for (i = 0; i < array.length && l < left.length && r < right.length; ++i) 
			{
				if (left[l].compareTo(right[r]) <= 0) 
					array[i] = left[l++];
				else 
					array[i] = right[r++];
			}
			if (i < array.length) 
			{
				if (l < left.length) 
				{
					while (i < array.length) 
					{
						array[i++] = left[l++];
					}
				}
				else 
				{
					while (i < array.length) 
					{
						array[i++] = right[r++];
					}
				}
			}
		}
	}
	
	public static <T extends Comparable<? super T>> void quickSort(T[] array) 
	{
		quickSort(array, 0, array.length - 1);
	}
	private static <T extends Comparable<? super T>> void quickSort(T[] array, int left, int right) 
	{
		int pivot = right;
		int l = left, r = right;
		if (left < right) 
		{
			while (l < r) 
			{
				while (l < r && array[l].compareTo(array[pivot]) <= 0) 
				{
					++l;
				}
				while (l < r && array[pivot].compareTo(array[r]) <= 0) 
				{
					--r;
				}
				if (l < r) 
				{
					T temp = array[l];
					array[l] = array[r];
					array[r] = temp;
				}
			}
			if (r != pivot) 
			{
				T temp = array[pivot];
				array[pivot] = array[r];
				array[r] = temp;
			}
			quickSort(array, left, r - 1);
			quickSort(array, r + 1, right);
		}
	}
	
	public static <T extends Comparable<? super T>> void selectSort(T[] array) 
	{
		T temp;
		int mini; //index of the smallest value of the array
		for (int i = 0; i < array.length - 1; ++i) //starting position of unsorted array
		{
			mini = i;
			for (int j = i + 1; j < array.length; ++j) //traverses unsorted section of the array
			{
				if (array[j].compareTo(array[mini]) < 0) //if value at array[j] is smaller
				{
					mini = j; //index of smallest data item is j
				}
			}
			if (i != mini) //swap to bring smallest item to the beginning of the unsorted section
			{
				temp = array[i];
				array[i] = array[mini];
				array[mini] = temp;
			}
		}
	}
}
