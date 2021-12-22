package Project3;

import java.util.Arrays;
import java.util.Random;

public class Sorts 
{
	public static void main(String[] args)
	{
		//SMALL ARRAY HEAPSORT TEST:
		int num = 10; //used to be 10000 but changed to smaller number to show entire array in console
		Integer[] array = new Integer[num];
		Random rand;
		long start, stop; //time how long each test case takes ==> make array length 10000 (i.e. really big) to use effectively
		rand = new Random(1);
		
		//TEST Heapsort:
		System.out.println("Heapsort:");
		System.out.print("Original/Unsorted: ");
		//Create unsorted array
		for (int i = 0; i < array.length; ++i) 
		{
			array[i] = rand.nextInt(num);
			System.out.print(array[i] + " ");
		}
		System.out.println();
		//call Heapsort method and time
		start = System.currentTimeMillis();
		heapSort(array);
		System.out.print("\nSorted:            ");
		
		//print sorted array:
		for(int x : array)
			System.out.print(x + " ");
		
		System.out.print("\n");
		stop = System.currentTimeMillis();
		

		//check if sorted
		for (int i = 0; i < array.length - 1; ++i) 
		{
			if (array[i] > array[i+1]) 
			{
				System.out.println("heap fail");
				System.exit(0);
			}
		}
		System.out.println("Heap pass: " + (stop - start) + "\n");
		/*
		
		//ARRAY[1000000] TEST CASE:
		int n = 1000000;
		Integer[] array = new Integer[n];
		Random rand;
		long start, stop; 
		rand = new Random(1);
		System.out.println("Heap Sort w/ " + n + " data");
		//Create unsorted array
		for (int i = 0; i < array.length; ++i) 
		{
			array[i] = rand.nextInt(n);
		}
		
		//Test HeapSort
		System.out.println("Start");
		start = System.currentTimeMillis();
		heapSort(array);
		stop = System.currentTimeMillis();

		//check if sorted
		for (int i = 0; i < array.length - 1; ++i) 
		{
			if (array[i] > array[i+1]) 
			{
				System.out.println("heap fail");
				System.exit(0);
			}
		}
		
		System.out.println("Heap pass: " + (stop - start) + "\n");
		*/	
	}
	
    public static <T extends Comparable<? super T>> void heapSort(T[] array) 
    {
    	for(int i= array.length / 2 - 1; i >= 0; i--) //starting at parent of last element and work up the heap to the first element
    	{
    		//"builds" heap-structure by comparing parent (i) to it's two children
    		buildHeap(array, array.length, i); //parameters = array, index of last element in the heap, root index
    	}
    	
    	for(int i = array.length -1; i > 0; i--) //the largest elements are always going to be at the root, SWAP with last element in unsorted section, the increment "shrink" unsorted section
    	{
    		T temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            
            buildHeap(array, i, 0); //parameters = array, index of last element in "unsorted" section, root index ALWAYS is the first element (i.e the very top of the heap)
    	}
    	
    }

    private static <T extends Comparable<? super T>>void buildHeap(T[] array, int last, int i) 
    {
    	 int largestIndex = i; // Initialize largestIndex as root/parent index i
         int left = 2 * i + 1; // left child index = 2*i + 1
         int right = 2 * i + 2; // right child index = 2*i + 2
  
         // If left child is larger than root, set largestIndex to left child's index
         // First checks to make sure that left child index < last index... (falls under the "sub-tree")
         if (left < last && array[left].compareTo(array[largestIndex]) > 0)
             largestIndex = left;
  
         // If right child is larger than root, set largestIndex to right child's index
         // First checks to make sure that right child index < last index... (falls under the "sub-tree")
         if (right < last && array[right].compareTo(array[largestIndex]) > 0)
             largestIndex = right;
  
         // If largest value is not the root, SWAP!
         if (largestIndex != i)
         {
             T temp = array[i];
             array[i] = array[largestIndex];
             array[largestIndex] = temp;
  
             //System.out.println(Arrays.toString(array));
             // Recursively "re-build" the sub-tree affected by the parent-child swap, makes sure that heap with child root is a Max Heap
             buildHeap(array, last, largestIndex); //parameters = array, index of last element in the heap, root is the largestIndex (now = index of the larger child being swapped)
         }
	}

	public static <T extends Comparable<? super T>> void bubbleSort(T[] array) 
    {
        T temp;
        boolean sorted;

        for (int i = array.length - 1; i > 0; --i) 
        {
            sorted = true;

            for (int j = 0; j < i; ++j) 
            {
                if (array[j].compareTo(array[j + 1]) > 0) 
                {
                    sorted = false;

                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            if (sorted)
                break;
        }
    }

    public static <T extends Comparable<? super T>> void insertSort(T[] array) 
    {
        T temp;
        int j;

        for (int i = 1; i < array.length; ++i) 
        {
            temp = array[i];

            for (j = i; j > 0; --j) 
            {
                if (array[j - 1].compareTo(temp) > 0)
                    array[j] = array[j - 1];
                else
                    break;
            }

            if (j < i) 
                array[j] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] array) 
    {
        if (array.length > 1) 
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
        int mini;

        for (int i = 0; i < array.length - 1; ++i) 
        {
            mini = i;

            for (int j = i + 1; j < array.length; ++j) 
            {
                if (array[j].compareTo(array[mini]) < 0)
                    mini = j;
            }

            if (i != mini) 
            {
                temp = array[i];
                array[i] = array[mini];
                array[mini] = temp;
            }
        }
    }
}