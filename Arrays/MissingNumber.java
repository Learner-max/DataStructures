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
		int[] arr={1, 2, 4, 6, 3, 7, 8};
		int n=arr.length;
		missingNumber(arr,n);
	}
	
	public static void missingNumber(int[] arr, int n )
	{
	    int missingNo=1;
	    int x1=arr[0];
	    int x2=1;
	    for(int i=1;i<n;i++)
	    {
	        x1=x1^arr[i];
	    }
	    for(int i=2;i<=n+1;i++)
	    {
	        x2=x2^i;
	    }
	    
	    System.out.println(x1^x2);
	}
}
