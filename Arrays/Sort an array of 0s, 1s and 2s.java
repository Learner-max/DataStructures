/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Sort an array of 0s, 1s and 2s
		
		/*
		
		Input: {0, 1, 2, 0, 1, 2}
        Output: {0, 0, 1, 1, 2, 2}
        
        Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
        Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

      */
       int[] arr={2,2};
       sortColors(arr);
	}
	
	public static void sortColors(int[] arr) {
        
            if(arr.length==0 || arr.length==1)
                return;
	        
	        int l=0;
	        int h=arr.length-1;
	        int mid=0;
	        
	        while(mid<=h)
	        {
	            if(arr[mid]==0 )
	            {
	            	if(mid!=l)
	            	{ int temp=arr[l];
	                arr[l]=arr[mid];
	                arr[mid]=temp;}
	                l++;
	                mid++;
	            }else if(arr[mid]==1)
	            {
	                mid++;
	            }else if(arr[mid]==2 )
	            {
	               if(arr[mid]!=arr[h])
	              {
	                int temp=arr[h];
	                arr[h]=arr[mid];
	                arr[mid]=temp;
	              }
	              
	                h--;
	            }
	        }
	        for(int a:arr)
	        System.out.print(a+" ");
	       
	        
	    }
	
	//New Code-Refer this code//
	public static int[] sortArray(int[] arr, int n)
    {
        int l=0;//l keeper of 0
        int m=0;//keeper of 1
        int h=n-1;//keeper of 2
        
        while(m<=h)
        {
            if(arr[m]==0)
            {
                int temp=arr[l];
                arr[l]=arr[m];
                arr[m]=temp;
                m++;
                l++;
            }
            else if(arr[m]==1)
            m++;
            else
            {
                int temp=arr[h];
                arr[h]=arr[m];
                arr[m]=temp;
                //m++;
                h--;
            }
        }
        
        return arr;
    }
	
}
