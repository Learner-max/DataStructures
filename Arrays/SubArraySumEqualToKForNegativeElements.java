/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	//Same program can be used to find Subarray with sum zero.
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		//subarray sum equal to k
		int[] arr={10, 2, -2, -20, 10};
		int sum=-10;
		
		subarraySum(arr,sum);
		
	}
	
	public static void subarraySum(int[] arr,int sum)
	{
	     HashMap<Integer, Integer>map=new HashMap<>();
	     int curr_sum=0;
	     for(int i=0;i<arr.length;i++)
	     {
	            curr_sum=curr_sum+arr[i];
	            
	            if(curr_sum==sum)
	            {
	                   System.out.println("Sub array found at indexs: "+0 +" "+i);
	                   return;
	            }
	            if(map.containsKey(curr_sum-sum))
	            {
	                   System.out.println("Sub array found at indexs: "+(map.get(curr_sum-sum)+1)+" "+i);
	                   return;
	            }
	            map.put(curr_sum,i);
	     }
	     
	    System.out.println("No subarray found with given sum");
	}
}
