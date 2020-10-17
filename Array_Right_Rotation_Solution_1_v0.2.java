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
		int[] temp =new int[n-d];
		// Move n-d elements in temp array
		for(int i=0;i<temp.length;i++)
		{
		    temp[i]=arr[i];
		}
		
		//Now shift rest d elements to right of array
		
		for(int j=n-d;j<arr.length;j++)
		{
		    arr[j-d-1]=arr[j];
		}
		
		//now copy elements from temp array to arr
		for(int x=0;x<temp.length;x++)
		{
		    arr[x+d]=temp[x];
		}
		for(int a:arr)
		System.out.print(a+" ");
	}
}
