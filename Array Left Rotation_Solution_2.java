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
		int size=arr.length-1;
		for(int i=0;i<d;i++)
		{
		    int temp=arr[0];
		    int j=0;
		    for(;j<size;j++)
		    {
		        arr[j]=arr[j+1];
		        
		    }
		    arr[j]=temp;
		}
		
		for(int x:arr)
		{
		    System.out.print(x+" ");
		}
	}
}
