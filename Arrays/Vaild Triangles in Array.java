/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Valid Triangle number
		
		int[] arr={0,1,0,1};
		//{6,7,8,10,12,14,50};
		
		validTriangleNumbers(arr);
	}
	
	public static void validTriangleNumbers(int[] arr)
	{
	    int count=0;
	    int n=arr.length;
	    int k=0;
		Arrays.sort(arr);
	    for(int i=0;i<=n-3;i++)
	    {
	        k=i+2;
	        for(int j=i+1;j<=n-2 && arr[i]!=0;j++)
	        {
	            while(k<n && arr[i]+arr[j]>arr[k])
	            k++;
	            
	            count+=k-j-1;
	        }
	    }
	    
	    System.out.println("Count "+ count);
	}
}
