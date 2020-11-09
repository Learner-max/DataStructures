/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Minimum number that cannot be formed by any subset of an array
		/*  Time Complexity: O(n)  Space Complexity:O(1)
		*   Input:  arr[] = {1, 3, 6, 10, 11, 15};
            Output: 2
            
            Input:  arr[] = {1, 1, 1, 1};
            Output: 5
            
            Input:  arr[] = {1, 1, 3, 4};
            Output: 10
            
            Input:  arr[] = {1, 2, 5, 10, 20, 40};
            Output: 4
            
            Input:  arr[] = {1, 2, 3, 4, 5, 6};
            Output: 22
         */
		
		int[] arr={1, 2, 3, 4, 5, 6};
		
		smallestNumber(arr);
	}
	
	public static void smallestNumber(int[] arr)
	{
	    int p=1;//smallest number
	    
	    for(int i=0;i<arr.length;i++)
	    {
	        if(arr[i]<=p)
	        {
	            p+=arr[i];
	        }else
	        {
	            break;
	        }
	    }
	    
	    System.out.println(p);
	}
}
