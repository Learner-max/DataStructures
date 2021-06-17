/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Product of array Except itself
		int[] arr={10, 3, 5, 6, 2};
		//long[] result=productExceptSelf(arr,arr.length);
		long[] res=productExceptSelfImproved(arr, arr.length);
		for(long l:res)
		{
		    System.out.print(l+" ");
		}
		
	}
	
	public static long[] productExceptSelf(int[] arr, int n)
	{
	    //Using Prefix and Suffix array Approach
	    
	    long[] res=new long[n];
	    // Create Prefix Array
	    long[] left=new long[n];
	    left[0]=arr[0];
	    for(int i=1;i<n;i++)
	    {
	     left[i]=left[i-1]*arr[i];   
	    }
	    
	    //Creating Suffix Array
	    long[] right=new long[n];
	    right[n-1]=arr[n-1];
	    for(int i=n-2;i>=0;i--)
	    {
	        right[i]=right[i+1]*arr[i];
	    }
	    
	    //Traverse Array
	    res[0]=right[1];
	    res[n-1]=left[n-2];
	    for(int i=1;i<n-1;i++)
	    {
	        res[i]=left[i-1]*right[i+1];
	    }
	    
	    return res;
	}
	
	//Improving above approach by replacing the Prefix and Suffix array with a variable 
	
	public static long[] productExceptSelfImproved(int[] arr, int n)
	{
	    //Why we need prefix array: to calculate product from 0 to (i-1) th index
	    //ie; Prefix array needed to hold previous values
	    long[] res=new long[n];
	    Arrays.fill(res,1);
	    int temp=1;
	    for(int i=0;i<n;i++)
	    {
	        res[i]=temp;
	        temp*=arr[i];
	    }
	    temp=1;
	    for(int i=n-1;i>=0;i--)
	    {
	        res[i]=res[i]*temp;
	        temp=temp*arr[i];
	    }
	    
	    return res;
	}
	
	//Using Divisor Operator
	public static long[] productExceptSelfDivisor(int nums[], int n) 
	{ 
        // code here
        long[] res=new long[n];
        long product=1;
        int flag=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            flag++;
            else
            product*=nums[i];
            
        }
        
        for(int i=0;i<n;i++)
        {
            if(flag>1)
            res[i]=0;
            else if(flag==1 && nums[i]!=0)
            res[i]=0;
            else if(flag==1 && nums[i]==0)
            res[i]=product;
            else
            res[i]=product/nums[i];
        }
        return res;
	} 
}
