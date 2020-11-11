/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main(String[] args){
	
	/* 
	   Check if array in wave form
	    Input: arr[] = {1, 2, 3, 4, 5}
        Output: NO
        
        Input: arr[] = {1, 5, 3, 7, 2, 8, 6}
        Output: YES
                         
    */
    
    int[] arr={1, 2, 3, 4, 5};
    
    checkWaveForm(arr);
	    
	}
	
	public static void checkWaveForm(int[] arr)
	{
	    int n=arr.length;
	    boolean result=false;
	  if(arr[1]>arr[0] && arr[1]>arr[2])
	  {
	      for(int i=1;i<n;i+=2)
	      {
	          if(arr[i]>arr[i-1]&& arr[i]>arr[i+1])
	          result=true;
	          else
	          {
	              result=false;
	              break;
	          }
	      }
	  }
	  else if(arr[1]<arr[0] && arr[1]<arr[2])
	  {
	      for(int i=1;i<n;i+=2)
	      {
	          if(arr[i]<arr[i-1]&& arr[i]<arr[i+1])
	          result=true;
	          else
	          {
	              result=false;
	              break;
	          }
	      }
	  }
	  
	  System.out.println(result);
	}

}
