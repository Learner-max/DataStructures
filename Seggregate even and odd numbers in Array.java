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
	int[] arr= {12, 34, 45, 9, 8, 90, 3};
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
		while(arr[l]%2==0 && l<r)
		{
		  l++;
			    
		}

		while(arr[r]%2==1 && r>l)
			{
			    
				r--;
			}
			if(l<r)
			{
			    int temp=arr[l];
		    	arr[l]=arr[r];
			    arr[r]=temp;
			    l++;
			    r--;
			}
			
			
	}

	return arr;
}

}
