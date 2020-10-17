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
		
		int[] arr={1,2,3,4,5,6,7};
		int k=3;
		int n=arr.length;
		k=k%n;
		n=n-1;
		reverseArray(arr,0,n);
		reverseArray(arr,0,k-1);
		reverseArray(arr,k,n);
		
		for(int a:arr)
		System.out.print(a+" ");
		
	}
	
	static int[] reverseArray(int[] arr,int l,int r)
	{
	    while(l<r)
	    {
	        int temp=arr[r];
	        arr[r]=arr[l];
	        arr[l]=temp;
	        l++;r--;
	    }
	    
	    return arr;
	}
}
