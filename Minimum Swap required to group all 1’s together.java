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
		
		int[] arr={1,0,1,0,1,0,0,1,1,0,1};
		System.out.println(minSwap(arr));
                           
	}
	
	public static int minSwap(int[] arr)
	{
	    int sizeOfWindow=0;
	    
	    for(int i=0;i<arr.length;i++)
	    {
	        if(arr[i]==1)
	        sizeOfWindow++; //sizeofWindow should be equal to number of 1's in an array
	        
	    }
	    
	    /*In first window we intend to find no of zeros
	    * x=number of zeros in a window = number of swaps we have to do
	    */
	    int zeros=0;
	    for(int i=0;i<sizeOfWindow;i++)
	    {
	        if(arr[i]==0)
            zeros++;
	    }
	    
	    int minSwap=zeros;
	    
	    /* We will be using sliding window technique
	    * we will be using Fixed Length window variant of Sliding window technique
	    *Goal is:
	    * finding a window that contains most 1's or finding a window that contains min 0's
	    */
	    int n=arr.length;
	    
	    for(int j=1;j<=n-sizeOfWindow;j++)
	    {
	        /* Check if previous window removed element 
	        * is 0 or 1. If 0 means number of zeros must decrease.
	        * else not
	        */
	        
	       
	        if(arr[j-1]==0)
	        {
	            zeros-=1;
	        }
	        
	        /* Check if current window newly added element 
	        * is 0 or 1. If 0 means number of zeros must increase.
	        * else not
	        */
	        if(arr[j+sizeOfWindow-1]==0)
	        {
	            zeros+=1;
	        }
	        
	        minSwap=Math.min(zeros,minSwap);
	    }
	    
	    return minSwap;
	}
}
