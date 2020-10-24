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
		
		int[] nums={5, 3, 1, 3, 5, 5};
		//{3,3,3};
		//{5, 3, 1, 3, 5, 5};
		
		
		// Here in this approach we have assumed that array of length n can contain
		//elements from 0 to n-1 only.
		//So with this assumption each array element can be considered as a valid index
		// For index i arr[i] will represent no of times element i occur in arr
		repeatingElements(nums);
	}
	
	public static void repeatingElements(int[] arr) {
	    int n=arr.length;
        
        for(int i=0;i<arr.length;i++)
        {
            arr[arr[i]%n] +=n;
        }
       
       for(int i=0;i<arr.length;i++)
       {
           if((arr[i]/n) >1 )
           {
               System.out.print(i+" ");
           }
       }
       
       //Be a good person and revert the array like it was provided
       for(int i-0;i<arr.length;i++)
       {
           arr[i]=arr[i]%n;
       }
    }
}

