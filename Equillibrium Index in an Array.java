/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Equillibrium Index of an array
		
		int[] arr={1,2,3};
		//{-7, 1, 5, 2, -4, 3, 0};
		
		System.out.println(equllibriumIndex(arr));
	}
	
	public static int equllibriumIndex(int[] arr)
	{
	    int sum=0;
	    int leftSum=0;
	    
	    for(int i=0;i<arr.length;i++)
	    {
	        sum+=arr[i];
	        
	    }
	    
	    for(int i=0;i<arr.length;i++)
	    {
	        sum-=arr[i];
	        if(leftSum==sum)
	           return i;
	       leftSum+=arr[i];
	    }
	    return -1;
	}
}
