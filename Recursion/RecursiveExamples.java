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
		
		int[] arr={3,5,1,2,6};
		
		int n=arr.length;
		
		int key=3;
		
		//System.out.println(isSortedArray(arr,0,n-1,n));
		
		//System.out.println(sumOfArrayElements(arr,n));
		
		System.out.println(linearSearch(arr,n-1,key));
	}
	
/*	public static boolean isSortedArray(int[] arr, int start, int end,int size)
	{
	    if(size==0 || size==1)
	        return true;
        
        if(arr[start]>arr[end]){
            return false;
        }else{
            boolean ans=isSortedArray(arr,start+1, end,size-1);
            return ans;
        }
	}*/
	
 	/*public static int sumOfArrayElements(int[] arr, int size)
	{
	    if(size==0)
	        return 0;
	        
        
        //int ans=sumOfArrayElements(arr,size-=1);
        // System.out.println(ans+" "+size);
        // ans=ans+arr[size];
        // return ans;
        return sumOfArrayElements(arr,size-=1)+arr[size];
	}*/
	
	/*public static boolean linearSearch(int[] arr, int size, int target){
	    
	    if(size==0 && arr[size]!=target)
	        return false;
	   
	   if(arr[size]==target)
	   {
	       return true;
	   }else{
	        return linearSearch(arr, size-=1,target);
	   }
	}*/
	
	
}
