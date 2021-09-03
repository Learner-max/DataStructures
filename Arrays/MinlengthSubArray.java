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
		int arr[] = {1, 2, 4};
		int target=8;
		
		System.out.println(minLengthSubArray(arr,target));

	}
	
	public static int minLengthSubArray(int[] arr, int target)
	{
	    int start=0;
	    int minWindow=Integer.MAX_VALUE;
	    int winH=0;
	    int sum=0;
	    int n=arr.length;
	    for(int i=0;i<arr.length;i++)
	    {
	        sum+=arr[i];
	        
            while(sum>target && start<n)
            {
                
                winH=i-start+1;
                minWindow=Math.min(winH,minWindow);
                sum=sum-arr[start];
                start++;
            }
	    }
	    
	    return minWindow;
	}
}
