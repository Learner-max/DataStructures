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
}
