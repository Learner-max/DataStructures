/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr={-12, 11, -13, -5,
                   6, -7, 5, -3, 11};
		   // {12, 11, -13, -5 ,6, -7 ,5 ,-3 ,-6};
		int n=arr.length;
		arr=rearrangeNumbers(arr,n);
		for(int a:arr)
		System.out.print(a+" ");
		
	}
    public static int[] rearrangeNumbers(int[] arr, int n)
    {
        int l=0;//keeper of -ve
        int h=n-1;//keeper of +ve
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(arr[i]<min)
            min=arr[i];
        }
        
        for(int i=0;i<n;i++)
        {
            if(arr[i]>max)
            max=arr[i];
        }
        
        int divisor=max-min+1;
        int k=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=arr[i]-min;
        }
        
        for(int i=0;i<n;i++)
        {
            if(arr[i]%divisor<-min){
            arr[k]=arr[k]+(arr[i]%divisor)*divisor;
            k++;
            }
        }
        
        
        for(int i=0;i<n;i++)
        {
            if(arr[i]%divisor>-min)
            {
                arr[k]=arr[k]+(arr[i]%divisor)*divisor;
                k++;
            }
        }
        
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=arr[i]/divisor;
            arr[i]=arr[i]+min;
        }
        
        return arr;
    }
}
