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
	int[] arr= {0, 1, 0, 1, 1, 1};
	int l=0;
	int r=arr.length-1;

	seperate01(arr,l,r);

	for(int a:arr)
	System.out.print(a+" ");

	}
	
	public static int[] seperate01(int[] arr, int l,int r)
{
	while(l<r)
	{
		while(arr[l]==0 && l<r)
		{
		  l++;
			    
		}

		while(arr[r]==1 && r>l)
			{
			    
				r--;
			}
			if(l<r)
			{
		    	arr[l]=0;
			    arr[r]=1;
			    l++;
			    r--;
			}
			
			
	}

	return arr;
}

}
