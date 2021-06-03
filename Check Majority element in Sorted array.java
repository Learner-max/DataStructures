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
		
		int[] arr={1,2,2,2,3,3,3};
		int target=2;
		
		System.out.println(target+" is the majority element in given array "+isMajority(arr, target));
		
	}
	
	public static boolean isMajority(int[] arr, int target)
	{
		if(arr.length==0 || arr ==null)
			return false;
	    int l=0;
	    int  r= arr.length-1;
	    while(l<r)
	    {
	        int mid=l+(r-l)/2;
	        if(arr[mid]<target)
	        {
	            l=mid+1;
	        }else
	            r=mid;
	    }
	    
	    return (l+arr.length/2)<arr.length && arr[l+arr.length/2]==target;
	    
	}
	/* 
	  New Code- Refer This
	  public static int binarySearch(int[] arr, int target)
	{
	    int l=0;
	    int  r= arr.length-1;
	    while(l<=r)
	    {
	        int mid=l+(r-l)/2;
	        if((mid==0 ||(target>arr[mid-1]) && arr[mid]==target))
	        return mid;
	        if(arr[mid]<target)
	        {
	            l=mid+1;
	        }else
	            r=mid;
	    }

		return -1;
	}
	
	public static boolean isMajority(int[] arr, int target)
	{
		if(arr.length==0 || arr ==null)
			return false;
	    int index=binarySearch(arr,target);
	    System.out.println(index);
	    int n=arr.length/2;
	    if(index==-1)
	    return false;
	    if(arr[index]==arr[index+n])
	    return true;
	    else
	    return false;
	    
	  
	    
	}
	*/
}
