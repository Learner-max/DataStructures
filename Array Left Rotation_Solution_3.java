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
		//GCD Method to left rotate an array
		
		int[] arr={1,2,3,4,5,6,7,8,9,10,11,12};
		
		int d=3;
		
		int n=arr.length;
		
		int gcd=findGCD(n,d);
		int temp;
		for(int i=0;i<gcd;i++)
		{
		    temp=arr[i];
		    int j=i,k=0;
		    while(true)
		    {
		        k=j+d;
		        if(k>=n)
		        k=k-n;
		        if(k==i)
		        break;
		        arr[j]=arr[k];
		        j=k;
		    }
		    
		    arr[j]=temp;
		}
		
		for(int a:arr)
		System.out.print(a+" ");
	}
	
	public static int findGCD(int n,int d)
	{
	    if(d==0)
	    return n;
	    else
	    return findGCD(d,n%d);
	}
}
