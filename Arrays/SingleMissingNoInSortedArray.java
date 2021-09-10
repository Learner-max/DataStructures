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
		
		int[] input={1, 2, 3, 4, 6};
		//search element in sorted array
	    missingNumberInSortedArray(input);
	}
	
	public static void missingNumberInSortedArray(int[] arr)
	{
	    int l=0;
	    int h=arr.length-1;
	    int res=0;
	    while(l<=h)
	    {
	        int mid=l+(h-l)/2;
	        if(arr[mid]==mid+1)
	        {
	            l=mid+1;
	            
	        }
	        else
	        {
	            res=mid+1;
	            h=mid-1;
	        }
	    }
	    
	    System.out.println(res);
	}
}
