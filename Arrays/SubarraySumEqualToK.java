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
		//subarray sum equal to k
		int[] arr={1, 4, 20, 3, 10, 5};
		int sum=33;
		
		subarraySum(arr,sum);
		
	}
	
	public static void subarraySum(int[] arr,int sum)
	{
	       int l=0;
	       int n=arr.length;
	       int curr_sum=arr[0];
	       
	       for(int i=1;i<n;i++)
	       {
	              curr_sum=curr_sum+arr[i];
	              while(curr_sum>sum && l<i)
	              {
	                     curr_sum=curr_sum-arr[l];
	                     l++;
	              }
	              
	              if(curr_sum==sum)
	              {
	                     System.out.println(l+" "+i);
	                     return;
	              }
	              
	       }
	       System.out.println("No subarray");
	}
}
