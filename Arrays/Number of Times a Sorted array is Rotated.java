/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Number of Times a Sorted array is Rotated .Assume here array is rotated 
		//Anti-clockwise (meaning Right rotation)
		//So, No of times array is rotated=Index of min element in rotated sorted array.
		/*
		
		Input : arr[] = {15, 18, 2, 3, 6, 12}
        Output: 2
        Explanation : Initial array must be {2, 3,
        6, 12, 15, 18}. We get the given array after 
        rotating the initial array twice.
        
        Input : arr[] = {7, 9, 11, 12, 5}
        Output: 4
        
        Input: arr[] = {7, 9, 11, 12, 15};
        Output: 0
*/

    int[] arr={7, 9, 11, 12, 5};
    
    if(timesArrayRoated(arr)>-1) 
    System.out.print(timesArrayRoated(arr));
    else
    System.out.println("Not found");
	}
	
	public static int timesArrayRoated(int[] arr)
	{
	    int n=arr.length;
	    int l=0;
	    int r=arr.length-1;
	    if(arr[l]<=arr[r])
	    {
	        return 0;
	    }
	    while(l<=r)
	    {
	     
	    int mid=l+(r-l)/2;
	  
	    int next=(mid+1)%n;
	    int prev=(mid+n-1)%n;
	
	    if(arr[mid]<=arr[next] && arr[mid]<=arr[prev])
	    {
	        
	        return mid;
	        
	    }
	    else if(arr[l]<=arr[mid])
	    {
	        l=mid+1;
	    }else 
	    {
	        r=mid-1;
	    }
	    
	   
	}
	 return -1;
}
}
