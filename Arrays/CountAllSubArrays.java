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
		int[] arr={10,2,-2,-20,10};
		
		int sum=-10;
		
		countSubArrays(arr, sum);
	}
	
	/*public static void countSubArrays(int[] arr , int sum)
	{
	    HashMap<Integer, Integer> map=new HashMap<>();
	    int curr_sum=0;
	    int count=0;
	    map.put(curr_sum,1);
	    
	    for(int i=0;i<arr.length;i++)
	    {
	        curr_sum+=arr[i];
	        if(map.containsKey(curr_sum-sum))
	        {
	            count+=map.get(curr_sum-sum);
	        }
	        if(!map.containsKey(curr_sum))
	        map.put(curr_sum,1);
	        else
	        map.put(curr_sum,map.get(curr_sum)+1);
	    }
	    
	    System.out.println(count);
	}*/
	
	//////OR Can be done as below:
	public static void countSubArrayWithSumK(int[] arr,int target)
	{
	    int count=0;
	    if(arr.length==0)
	       {
	           System.out.println("No SubArray");
	           return;
	       }
	       
	   HashMap<Integer,Integer> map=new HashMap<>();
	   int currsum=0;
	   for(int i=0;i<arr.length;i++)
	   {
	      currsum+=arr[i];
	      if(currsum==target)
	      {
	          count++;
	         
	      }
	      if(map.containsKey(currsum-target))
	      {
	         //map.put(currsum-target,map.get(currsum-target)+1);
	          count=count+map.get(currsum-target);
	          
	      }
	      if(map.containsKey(currsum))
	      map.put(currsum,map.get(currsum)+1);
	      else
	      map.put(currsum,1);
	   }
	   if(count==0)
	   System.out.println("No SubArray with target sum found ");
	   else
	   System.out.println(count);
	}
}
