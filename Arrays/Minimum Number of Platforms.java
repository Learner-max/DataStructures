/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Minimum Number of Platforms Required for a Railway/Bus Station
		
		/*
		    Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
            dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
            Output: 3
            Explantion: There are at-most three trains at a time (time between 11:00 to 11:20)
            
            Input: arr[] = {9:00, 9:40}
            dep[] = {9:10, 12:00}
            Output: 1
            Explantion: Only one platform is needed.
		*/
		
		int[] arr={900, 940};
		int[] dep={910, 1200};
		
		minimumPlatformReq(arr,dep);
		minimumPlatform(arr,dep);
	}
	
	//TC:O(nlogn) SC: O(logn)
	public static void minimumPlatformReq(int[] arr, int[] dep)
	{
	    Arrays.sort(arr);
	    Arrays.sort(dep);
	    int i=0;
	    int j=1;
	    int platfneeded=1;
	    int minplatform=1;
	    int n=arr.length;
	    
	    while(i<n && j<n)
	    {
	        if(arr[j]<dep[i])
	        {
	            platfneeded++;
	            j++;
	        }
	        else
	        {
	            platfneeded--;
	            i++;
	        }
	        
	        if(platfneeded>minplatform)
	        {
	            minplatform=platfneeded;
	        }
	    }
	    
	    System.out.println(minplatform);
	}
	
	public static void minimumPlatform(int[] arr, int[] dep)
	{
	    int[] platform=new int[2361];
	    int n=arr.length;
	    int platformNeeded=1;
	    int sum=0;
	    for(int i=0;i<n;i++)
	    {
	        platform[arr[i]]++;
	        platform[dep[i]]--;
	    }
	    int requiredPlatf=0;
	    for(int i=0;i<2361;i++)
	    {
	        sum+=platform[i];
	        requiredPlatf=Math.max(sum,requiredPlatf);
	    }
	    System.out.println(requiredPlatf);
	}
}
