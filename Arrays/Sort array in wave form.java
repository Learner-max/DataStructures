/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main(String[] args){
	
	/* 
	   sort array in wave form
	   Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
         Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
                         {20, 5, 10, 2, 80, 6, 100, 3} OR
                         any other array that is in wave form
        
         Input:  arr[] = {20, 10, 8, 6, 4, 2}
         Output: arr[] = {20, 8, 10, 4, 6, 2} OR
                         {10, 8, 20, 2, 6, 4} OR
                         any other array that is in wave form
        
         Input:  arr[] = {2, 4, 6, 8, 10, 20}
         Output: arr[] = {4, 2, 8, 6, 20, 10} OR
                         any other array that is in wave form
        
         Input:  arr[] = {3, 6, 5, 10, 7, 20}
         Output: arr[] = {6, 3, 10, 5, 20, 7} OR
                         any other array that is in wave form
                         
    */
    
    int[] arr={10, 5, 6, 3, 2, 20, 100, 80};
    
    waveForm(arr);
	    
	}
	
	public static void waveForm(int[] arr)
	{
	    int n=arr.length;
	    for(int i=0;i<arr.length;i+=2)
	    {
	        if(i>0 && arr[i]<arr[i-1])
	        {
	            int temp=arr[i];
	            arr[i]=arr[i-1];
	            arr[i-1]=temp;
	        }
	        if(i<n && arr[i]<arr[i+1])
	        {
	            int temp=arr[i];
	            arr[i]=arr[i+1];
	            arr[i+1]=temp;
	        }
	    }
	    
	    for(int a:arr)
	    {
	        System.out.print(a+" ");
	    }
	}

}
