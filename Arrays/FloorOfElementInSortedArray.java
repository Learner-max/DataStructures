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
		System.out.println(getFloorElement(new int[]{1, 2, 8, 10, 10, 12, 19},7,5));
		//Output:2
	   System.out.println(getFloorElement(new int[]{1, 2, 8, 10, 10, 12, 19},7,20));
	   //Output:19
	   System.out.println(getFloorElement(new int[]{1, 2, 8, 10, 10, 12, 19},7,0));
	   //Output:-1
	    System.out.println(getFloorElement(new int[]{ 1, 2, 4, 6, 10, 12, 14 },7,7));
	   //Output:6
	}
	
	public static int getFloorElement(int[] arr, int n,int k)
	{
	    int l=0;
	    int h=n-1;
	    int res=-1;
	    
	    while(l<=h)
	    {
	        int mid=l+(h-l)/2;
	        
	        if(arr[mid]==k)
	        return arr[mid];
	        else if(arr[mid]<k)
	        {
	            res=mid;
	            l=mid+1;
	        }
	        else
	        {
	            h=mid-1;
	        }
	    }
	    return res>-1?arr[res]:-1;
	}
}
