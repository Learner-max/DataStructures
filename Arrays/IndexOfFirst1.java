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
		findFirstOccurence(new int[]{1, 1, 1, 1,1, 1},1);
	}
	
	public static void findFirstOccurence(int[] arr,int key)
	{
	    int l=0;
	    int h=1;
	    int res=-1;
	    while(arr[h]==0)
	    {
	        l=h;
	        h=h*2;
	    }
	    
	    while(l<=h)
	    {
	        int mid=l+(h-l)/2;
	        
	        if(arr[mid]==key)
	        {
	            res=mid;
	            h=mid-1;
	        }
	        else if(arr[mid]<key)
	        l=mid+1;
	        else
	        h=mid-1;
	    }
	    
	    System.out.println(res);
	}
}
