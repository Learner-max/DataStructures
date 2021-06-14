/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main(String[] args)
	{
	    
      int[] booksPages= {12, 34, 67, 90};
      int students=2;
      //Output:113
      allocateBooks(booksPages,students);

	}
	
	public static void allocateBooks(int[] arr, int k)
	{
	    int l=0;
	    //int h=getMaxElement(arr);
	    int h=getSum(arr);
	    System.out.println(h);
	    int res=-1;
	    while(l<=h)
	    {
	        int mid=l+(h-l)/2;
	        
	        if(isValidScheme(arr,k,mid))
	        {
	            res=mid;
	            h=mid-1;
	        }else
	        {
	            l=mid+1;
	        }
	        
	    }
	    
	    System.out.println(res);
	}
	public static int getSum(int[] arr)
	{
	    int sum=0;
	    for(int i=0;i<arr.length;i++)
	    {
	        sum+=arr[i];
	    }
	    return sum;
	}
	public static int getMaxElement(int[] arr)
	{
	    int max=Integer.MIN_VALUE;
	    
	    for(int i=0;i<arr.length;i++)
	    {
	        if(arr[i]>max)
	        max=arr[i];
	    }
	    return max;
	}
	
	public static boolean isValidScheme(int[] arr,int k, int max)
	{
	    int sum=0;
	    int students=1;
	    for(int i=0;i<arr.length;i++)
	    {
	        sum+=arr[i];
	        if(sum>max)
	        {
	            students++;
	            sum=arr[i];
	        }
	        if(students>k)
	        return false;
	    }
	    return (students==k)?true:false;
	}
	
	
}
