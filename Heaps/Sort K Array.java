/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
        kSort(arr, n, k);
        
        //printArray(arr, n);
	}
	
	
	public static void kSort(int[] arr, int n,int k)
	{
	    //Create a minHeap
	    PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
	    
	    for(int i=0;i<=k;i++)
	    {
	        pq.add(arr[i]);
	    }
	    int index=0;
	    for(int i=k+1;i<n;i++)
	    {
	        arr[index++]=pq.remove();
	        pq.add(arr[i]);
	    }
	    
	    while(pq.size()>0)
	    {
	        arr[index++]=pq.remove();
	        
	    }
	    for(int a:arr)
	    {
	        System.out.println(a);
	    }
	}
}
