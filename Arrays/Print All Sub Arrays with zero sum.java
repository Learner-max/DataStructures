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
		int[] arr={6, 3, -1, -3, 4, -2, 2,
             4, 6, -12, -7};
             
        int sum=0;
        
        printSubarrays(arr, sum);
	}
	
	public static void printSubarrays(int[] arr, int sum)
	{
	    HashMap<Integer,List<Integer>> map=new HashMap<>();
	    
	  
	    int curr_sum=0;
	     map.put(curr_sum,new ArrayList<>());
	     map.get(curr_sum).add(-1);
	    
	    for(int i=0;i<arr.length;i++)
	    {
	        curr_sum+=arr[i];
	        
	        
	        if(map.containsKey(curr_sum))
	        {
	            List<Integer> list=map.get(curr_sum);
	            for(int a:list)
	            {
	            System.out.println("Subarray Index"+ (a+1)+" "+i);
	            }
	           map.get(curr_sum).add(i);
	        }
	        else
	        {
	     
	         map.put(curr_sum,new ArrayList<Integer>());
	         map.get(curr_sum).add(i);
	        }
	    }
	    
	}
	

}
