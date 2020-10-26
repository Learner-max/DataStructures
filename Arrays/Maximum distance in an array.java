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
		
		int[] arr= {1, 2, 3, 4, 5, 6};
		//{34, 8, 10, 3, 2, 80, 30, 33, 1};
		//{9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
		System.out.println(maxDifference(arr));
	}
	
	public static int maxDifference(int[] arr)
	{
	    int[] LMin =new int[arr.length];
	    int[] RMax= new int[arr.length];
	    LMin[0]=arr[0];
	    RMax[arr.length-1]=arr[arr.length-1];
	    
	    for(int i=1;i<arr.length;i++)
	    {
	        LMin[i]=Math.min(arr[i],LMin[i-1]);
	    }
	    for(int x:LMin)
	    {
	        System.out.print(x+" ");
	    }
	    System.out.println();
	    for(int i=arr.length-2;i>=0;i--)
	    {
	        //System.out.println(arr[i]);
	        RMax[i]=Math.max(arr[i],RMax[i+1]);
	    }
	    
	    for(int x: RMax)
	    {
	        System.out.print(x+" ");
	    }
	    System.out.println();
	    int i=0;
	    int j=0;
	    int maxdiff=0;
	    int n=arr.length;
	    while(i<n && j<n)
	    {
	        if(LMin[i]<RMax[j])
	        {
	            maxdiff=Math.max(maxdiff, j-i);
	            j++;
	        }
	        else
	        i++;
	    }
	    
	    return maxdiff;
	    
	}
}
