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
		
		int[] arr={1,2,3,4,5};
		int d=2;
		int n=arr.length;
		for (int i=0;i<d;i++)
		{
		    int temp=arr[n-1];
		    int j=n-1;
		    for(;j>0;j--)
		    {
		        arr[j]=arr[j-1];
		    }
		    arr[j]=temp;
		}
		for(int a:arr)
		System.out.print(a+" ");
	}
}
