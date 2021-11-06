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
		int[] arr={7,6,0,5,1,2};
		//getMinMaxBruteForce(arr);
		
		//Improving number of comparisoins by using Comparison by pair method
		getMinMaxPairComparison(arr);
	}
	
	public static void getMinMaxBruteForce(int[] arr)
	{
	    // Number of comparisons Best case- n-1( when arr is in ascending order)
	    //Number of comparisons Worst case - 2(n-1) ( when arr is in descending order)
	    int max=arr[0];
	    int min=arr[0];
	    int n=arr.length;
	    for(int i=1;i<n;i++)
	    {
	        if(max<arr[i])
	        {
	            max=arr[i];
	        }
	        else if(min>arr[i])
	        {
	            min=arr[i];
	        }
	    }
	    
	    System.out.println(max);
	    System.out.println(min);
	}
	
	public static void getMinMaxPairComparison(int[] arr)
	{
	    //Number of comparisons-3n/2
	    int i=0;
	    int n=arr.length;
	    int min;
	    int max;
	    if(n%2!=0)
	    {
    	    min=arr[0];
    	    max=arr[0];
    	    i=1;
	    }else
	    {
	        if(arr[0]>arr[1])
	        {
	            max=arr[0];
	            min=arr[1];
	        }else
	        {
	            max=arr[1];
	            min=arr[0];
	        }
	        i=2;
	    }
	    
	    while(i<n)
	    {
	        if(arr[i]>arr[i+1])
	        {
	            if(arr[i]>max)
	            {
	                max=arr[i];
	            }if(arr[i+1]<min)
	            {
	                min=arr[i+1];
	            }
	        }
	        else
	        {
	            if(arr[i+1]>max)
	            {
	                max=arr[i+1];
	            }if(arr[i]<min)
	            {
	                min=arr[i];
	            }
	        }
	        i+=2;
	    }
	    
	    System.out.println(max);
	    System.out.println(min);
	}
	
	public static int[] getMinMaxDivideAndConq(int[] arr, int start,int end)
	{
	    //Using Divide and Conquer Strategy
	    //Base Condn
	    int max;
	    int min;
	   
	    if(start==end)
	    {
	        int[] ans=new int[2];
	        ans[0]=arr[start];//max
	        ans[1]=arr[end];//min
	        
	        return ans;
	    }
	    else if(end==start+1)
	    {
	        int[] ans=new int[2];
	        if(arr[end]>arr[start])
	        {
	            ans[0]=arr[end];//max
	            ans[1]=arr[start];//min
	        }else
	        {
	            ans[0]=arr[start];//max
	            ans[1]=arr[end];//min
	        }
	        
	        return ans;
	    }
	    else
	    {
	        int mid=start+(end-start)/2;
	        
	        int[] left=getMinMaxDivideAndConq(arr,start,mid);
	        int[] right=getMinMaxDivideAndConq(arr,mid+1,end);
	        if(left[0]>right[0])
	        {
	            max=left[0];
	        }else
	        {
	            max=right[0];
	        }
	        if(left[1]<right[1])
	        {
	            min=left[1];
	        }else
	        {
	            min=right[1];
	        }
	        
	        int[] ans={max,min};
	        return ans;
	    }
	    
	}
}
