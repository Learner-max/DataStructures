/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr={7,10,4,3,20,15};
		int k=3;
		System.out.println(getKSmallestElement(arr,k));
		
	}
	//Using Quick Select Algorithm
	public static int getKSmallestElement(int[] arr, int k)
	{
	    int n=arr.length;
	    if(k>n)
	    return Integer.MAX_VALUE;
	    
	    int l=0;
	    int r=n-1;
	    while(l<=r){
	    int pos=partition(arr,l,r);
	    System.out.println("pos"+" "+pos);
	    if(pos+1==k)
	    return arr[pos];
	    else if(pos+1>k)
	    {
	        r=pos-1;
	    }
	    else
	    l=pos+1;
	    
	    } 
	    return -1;
	}
	 
	public static int partition(int[] arr, int l, int r)
	{
	    Random rand=new Random(0);
	    int pivotIndex=rand.nextInt(r-l+1)+l;
	    int pivotValue=arr[pivotIndex];
	    
	    int temp1=arr[r];
        arr[r]=arr[pivotIndex];
        arr[pivotIndex]=temp1;
        
	    int lesserItemTailIndex=l;
	    
	    for(int i=l;i<r;i++)
	    {
	        if(arr[i]<pivotValue)
	        {
	            int temp=arr[i];
	            arr[i]=arr[lesserItemTailIndex];
	            arr[lesserItemTailIndex]=temp;
	            lesserItemTailIndex++;
	        }
	    }
	    
	    int temp=arr[lesserItemTailIndex];
        arr[lesserItemTailIndex]=arr[r];
        arr[r]=temp;
        return lesserItemTailIndex;
	}
}
