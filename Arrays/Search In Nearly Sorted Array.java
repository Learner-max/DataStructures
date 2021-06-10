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
		System.out.println(searchInNearlySortedArray(new int[]{10, 3, 40, 20, 50, 80, 70},40));
		System.out.println(searchInNearlySortedArray(new int[]{10, 3, 40, 20, 50, 80, 70},90));
		System.out.println(searchInNearlySortedArray(new int[]{3, 2, 10, 4, 40},4));
	}
	
	public static int searchInNearlySortedArray(int[] arr, int k)
	{
	      int n=arr.length;
	      
	      if(n==0)
	      return -1;
	      if(n==1 && arr[0]==k)
	      return 0;
	      
	      int l=0;
	      int h=n-1;
	      
	      while(l<=h)
	      {
	            int mid=l+(h-l)/2;
	            int next=(mid+1)%n;
	            int prev=(mid+n-1)%n;
	            if(arr[mid]==k )
	            return mid;
	            /*else if(mid>0 && arr[mid-1]==k)
	            return mid-1;
	            else if(mid<n-1 &&arr[mid+1]==k)
	            return mid+1;*/
	            else if(arr[prev]==k)
	            return prev;
	            else if(arr[next]==k)
	            return next;
	             // If element is smaller than mid, then
                  // it can only be present in left subarray
	            else if(k>=arr[l] && k<arr[mid])
	            h=mid-2;
	            else
	            l=mid+2;
	      }
	      
	      return -1;
	      
	}
}
