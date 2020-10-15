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
		
		int[] arr={2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
		System.out.println("Odd Occuring Element "+oddOccuringElement(arr));
	}
	
	public static int oddOccuringElement(int[] arr)
	{
	    int oddElement=0;
	    for(int i=0;i<arr.length;i++)
	    {
	        oddElement=oddElement ^ arr[i];
	    }
	    return oddElement;
	}
}
