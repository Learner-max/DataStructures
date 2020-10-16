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
		int[] res=reverseArray(arr);
	for(int a:res)
	    System.out.print(a+" ");
	}
	public static int[] reverseArray(int[] arr)
	{
	    int l=0;
	    int r=arr.length-1;
	    int size=arr.length;
	    int temp=0;
	    while(l<r)
	    {
	        temp=arr[l];
	        arr[l]=arr[r];
	        arr[r]=temp;
	        l++;
	        r--;
	    }
	    return arr;
	    
	    
	    // Alternative Way
	    /* for (int i = 0; i < size / 2; i++) { 
            temp = arr[i]; 
            arr[i] = arr[size - i - 1]; 
            arr[size - i - 1] = temp; 
        } */
        
       
 
	}
}
