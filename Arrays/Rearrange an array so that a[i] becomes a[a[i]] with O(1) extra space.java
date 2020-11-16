/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Rearrange an array so that arr[i] becomes arr[arr[i]] with O(1) extra space
		/*
		Input: arr[]  = {3, 2, 0, 1}
        Output: arr[] = {1, 0, 3, 2}
        Explanation: 
        In the given array 
        arr[arr[0]] is 1 so arr[0] in output array is 1
        arr[arr[1]] is 0 so arr[1] in output array is 0
        arr[arr[2]] is 3 so arr[2] in output array is 3
        arr[arr[3]] is 2 so arr[3] in output array is 2
        
        Input: arr[] = {4, 0, 2, 1, 3}
        Output: arr[] = {3, 4, 2, 0, 1}
        Explanation:
        arr[arr[0]] is 3 so arr[0] in output array is 3
        arr[arr[1]] is 4 so arr[1] in output array is 4
        arr[arr[2]] is 2 so arr[2] in output array is 2
        arr[arr[3]] is 0 so arr[3] in output array is 0
        arr[arr[4]] is 1 so arr[4] in output array is 1
        
        Input: arr[] = {0, 1, 2, 3}
        Output: arr[] = {0, 1, 2, 3}
        Explanation:
        arr[arr[0]] is 0 so arr[0] in output array is 0
        arr[arr[1]] is 1 so arr[1] in output array is 1
        arr[arr[2]] is 2 so arr[2] in output array is 2
        arr[arr[3]] is 3 so arr[3] in output array is 3
		
		*/
		
		int[] arr={3, 2, 0, 1};
		rearrangeArray(arr);
		
	}
	
	public static void rearrangeArray(int[] arr)
	{
	    int n=arr.length;
	    for(int i=0;i<arr.length;i++)
	    {
	        arr[i]=arr[i]+((arr[arr[i]]%n)*n);
	    }
	    for(int a:arr)
	    {
	        System.out.print(a+" ");
	    }
	    
	    System.out.println(" New Re Arranged array");
	    for(int a:arr)
	    {
	        System.out.print(a/n+" ");
	    }
	}
}
