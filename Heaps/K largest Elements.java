/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int arr[] = {7,10,4,3,20,15};
        int n = arr.length,k = 3;
       
        //kLargestElements(arr,n, k);
        kLargestElementsMinHeap(arr,n,k);
	}
	
	public static void kLargestElements(int[] arr, int n,int k)
	{
	   //Implementing QuickSelect Algorithm
	   int l=0;
	   int r=n-1;
	   
	   while(l<=r)
	   {
	       int pos=partition(arr,n,l,r);
	       
	       if(pos+1==k){
	           
	           for(int i=pos+1;i<n;i++)
	           {
	               System.out.println(arr[i]);
	           }
	           return;
	       }else if(pos+1<k)
	       {
	           l=pos+1;
	       }else
	       {
	           r=pos-1;
	       }
	   }
	   
	    
	}
	
	public static int partition(int[] arr, int n,int l, int r)
	{
	   
	    //Selecting Pivot Element
	    Random rand=new Random(0);
	    int pivotIndex=rand.nextInt(r-l+1)+l;
	    int pivotValue=arr[pivotIndex];
	    
	    int temp=arr[r];
	    arr[r]=arr[pivotIndex];
	    arr[pivotIndex]=temp;
	    
	    int j=l;
	    for(int i=l;i<r-1;i++)
	    {
	        if(arr[i]<pivotValue)
	        {
	            temp=arr[j];
	            arr[j]=arr[i];
	            arr[i]=temp;
	            j++;
	        }
	    }
	    temp=arr[j];
        arr[j]=arr[r];
        arr[r]=temp;
        
        return j;
	}
	
	public static void kLargestElementsMinHeap(int[] arr, int n,int k)
	{
	    //Create a minHeap
	    PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
	    for(int i=0;i<n;i++)
	    {
	        pq.add(arr[i]);
	        if(pq.size()>k)
	        {
	            pq.remove();
	        }
	    }
	    
	    while(pq.size()>0)
	    {
	        System.out.println(pq.remove());
	    }
	    //return pq.peek();
	}
}
