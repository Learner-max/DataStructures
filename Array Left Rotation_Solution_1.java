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
		
		int d=4;
		
		int[] temp=new int[d];
		
		for(int i=0;i<d;i++)
		{
		    temp[i]=arr[i];
		    
		}
		int j=0;
		
		for( ;j<arr.length;j++)
		{
		    if((d+j)<arr.length)
		    {
		        arr[j]=arr[d+j];
		    }
		    else
		    break;
		}
		
		for(int x=0;x<temp.length;x++)
		{
		    arr[j]=temp[x];
		    j++;
		}
		
		System.out.println("Rotated array by "+d +" elements");
		
		for(int l:arr)
		System.out.print(l+" ");
	}
}
