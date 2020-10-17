/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		int[] arr={1,2,3,4,5,6};
		int d=2;
		int n=arr.length-1;
		
		reverseArray(arr,0,d-1);
		
		reverseArray(arr,d,n);
		
		reverseArray(arr,0,n);
		
		for(int a:arr)
			System.out.print(a+" ");
	}
	public static int[] reverseArray(int[] arr,int l, int r)
	{
	    //System.out.println("new");
	    //for(int a:arr)
		//	System.out.print(a+" ");
		// System.out.println("End");
		
	    while(l<r)
	    {
	        
	        int temp=arr[r];
	        arr[r]=arr[l];
	        arr[l]=temp;
	        l++;
	        r--;
	    }
	    
	    return arr;
	}
}
