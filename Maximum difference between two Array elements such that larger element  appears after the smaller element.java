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
		/* 
		*Max difference in an array such that larger element 
		*  appears after smaller element.
		*
		*/
		
		int[] arr={3,1,4,7,5,100,10};
		
		//Approach-1 Brute Force
		
		System.out.println("Brute Force: "+maxDiffBruteForce(arr));
		
		//Approach-2 By using difference array
		
		System.out.println("By Using Difference Array: "+maxDiffByArray(arr));
		
		//Approach-3 Optimized Approach .Instead of using differnce array we use variables
		//min_so_far and max_diff to keep track of max_diff thus reducing SC to O(1)
		
		System.out.println("By using variables : "+ maxDiffByVaraibles(arr));
	}
	
	/*
	  By Brute Force TC:O(n^2) SC:O(1)
	  for each element we try to find a diff .If diff>maxdiff update.
	  Here if arr[i]>arr[i-1] then only diff calculated
	*/
	
	public static int maxDiffBruteForce(int[] arr)
	{
	    int curr_diff=Integer.MIN_VALUE;
	    int diff=0;
	    
	    for(int i=0;i<arr.length;i++)
	    {
	        for(int j=i+1;j<arr.length;j++)
	        {
	            if(arr[j]>arr[i])
	            {
	                diff=arr[j]-arr[i];
	            }
	            
	            if(diff>curr_diff)
	            {
	                curr_diff=diff;
	            }
	        }
	    }
	    return curr_diff;
	}
	
	/*
	 By using difference array.Here TC:O(n) SC:O(n)
	 Idea is: The Maximum Sum in Difference Array = Maximum Difference in the given array.
	 Algo:
	 1.Construct the difference array for given array .diff[i]=arr[i+1]-arr[i]
	 2.find max sum subarray in difference array.
	    curr_diff=diff[0];
	    for i=1 to n-1
	       check if diff[i-1]>0
	          update diff[i]=diff[i]+diff[i-1];
	   curr_diff=Max(curr_diff, diff)
	   
	*/
	
	public static int maxDiffByArray(int[] arr)
	{
	    int[] diff_arr=new int[arr.length-1];
	    for(int i=0;i<diff_arr.length;i++)
	    {
	        diff_arr[i]=arr[i+1]-arr[i];
	    }
	    
	    int curr_diff=diff_arr[0];
	    int diff=0;
	    
	    for(int j=1;j<diff_arr.length;j++)
	    {
	        if(diff_arr[j-1]>0)
	          diff_arr[j]=diff_arr[j]+diff_arr[j-1];
	          
	        curr_diff=Math.max(diff_arr[j],curr_diff);  
	    }
	    
	    return curr_diff;
	}
	
	public static int maxDiffByVaraibles(int[] arr)
	{
	    int min_so_far=arr[0];
	    int max_diff=Integer.MIN_VALUE;
	    int curr_diff=0;
	    
	    for(int i=1;i<arr.length;i++)
	    {
	        if(arr[i]<min_so_far)
	        {
	            min_so_far=arr[i];
	        }
	        else
	        {
	            curr_diff=arr[i]-min_so_far;
	            max_diff=Math.max(max_diff,curr_diff);
	        }
	    }
	    
	    return max_diff;
	}
}
