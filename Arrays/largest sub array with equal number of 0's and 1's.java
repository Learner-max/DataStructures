/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Maximum size subarray with equal number of 1's and 0's
		int[] arr={1, 0, 0, 1, 0, 1, 1};
		//{0,1};
		//{0, 0, 1, 1, 0};
		//{1, 0, 1, 1, 1, 0, 0};
		maxSizeSubArray(arr);
	}
	
	public static void maxSizeSubArray(int[] arr)
	{
	    HashMap<Integer, Integer> map=new HashMap<>();
	    int curr_sum=0;
	    int l=0;
	    int u=0;
	    int msize=0;
	 
	    
	    for(int i=0;i<arr.length;i++)
	    {
	        int a=(arr[i]==0)?-1:1;
	        curr_sum+=a;
	        if(curr_sum==0)
	        {
	            l=0;
	            u=i;
	            msize=i+1;
	        }
	        if(map.containsKey(curr_sum))
	        {
	            int s=i-(map.get(curr_sum)+1);->s=i-(map.get(curr_sum))
	            if(s>msize)
	            {
	                msize=s;
	                l=map.get(curr_sum)+1;
	                u=i;
	            }
	        }
	        if(!map.containsKey(curr_sum))->not necessary
	        map.put(curr_sum,i);
	        
	    }
	    
	    System.out.println(l+" "+u);
	    System.out.println((l==0)?msize:msize+1);-> msize
	}
}
