/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Heap Sort Implementation
		int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;
        
        sortArray(arr,n);
		printArray(arr,n);
	}
	
	public static void sortArray(int[] arr, int n)
	{
	    /*
	      Sorting Algo used Heap Sort
	      1. Build Map Heap from given array
	    
	      2.Extract element one by one from maxHeap and place it at end of array
	      3.Keep repeating the step 2 till 1 element left in maxheap
	    */
	    buildMaxHeap(arr,n);
	    printArray(arr,n);
	    //Extracting Phase
	    
	    for(int i=n-1;i>=0;i--)
	    {
	        //swap the first/ top element from max Heap with last element of array
	        //and decrease the heapsize and call maxHeapify on decreased maxheap
	        int temp=arr[i];
	        arr[i]=arr[0];
	        arr[0]=temp;
	        maxHeapify(arr,i,0);
	    }
	    
	}
	
	public static void buildMaxHeap(int[] arr, int n)
	{
	    for(int i=(n-1)/2;i>=0;i--)
	    {
	        maxHeapify(arr,n,i);
	    }
	}
	
	public static void maxHeapify(int[] arr, int heapSize, int parent)
	{
	    int leftChild=(2*parent)+1;
	    int rightChild=(2*parent)+2;
	    int largest=parent;
	    if(leftChild<heapSize && arr[leftChild]>arr[largest])
	    {
	        largest=leftChild;
	    }
	    
	   if(rightChild<heapSize && arr[rightChild]>arr[largest])
	   {
	       largest=rightChild;
	      
	   }
	   if(largest!=parent)
	   {
    	    int temp=arr[parent];
    	    arr[parent]=arr[largest];
    	    arr[largest]=temp;
    	    maxHeapify(arr,heapSize,largest);
	   }
	   
	}
	public static void printArray(int[] arr, int n)
	{
	    for(int i=0;i<arr.length;i++)
	    {
	        System.out.print(arr[i]+" ");
	    }
	    System.out.println();
	}
	
}
