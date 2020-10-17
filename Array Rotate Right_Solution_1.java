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
		int n=arr.length-1;
		int[] temp =new int[d];
		
		for(int i=0;i<d;i++)
		{
		    temp[i]=arr[n];
		    n--;
		}
		
		n=arr.length-1;
		int j=n;
		for(;j>0;j--)
		{
		    
		    if((j-d)>=0)
		    {
		 		    arr[j]=arr[j-d];
		    }
		    else
		    break;
		}
		
	
		for(int x=0;x<temp.length;x++)
		{
		    arr[j]=temp[x];
		    j--;
		}
		
		for(int a:arr)
		System.out.print(a+" ");
	}
}
