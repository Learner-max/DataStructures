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
		
		int[] nums={5, 3, 1, 3, 5, 5};
		//{3,3,3};
		//{5, 3, 1, 3, 5, 5};
		
		
		// Here in this approach we have assumed that array of length n can contain
		//elements from 0 to n-1 only.
		//So with this assumption each array element can be considered as a valid index
		// For index i arr[i] will represent no of times element i occur in arr
		repeatingElements(nums);
	}
	
	public static void repeatingElements(int[] arr) {
	    int n=arr.length;
        
        // Solution is vaild if array conatins elements  0<=arr[i]<=n-1 
        for(int i=0;i<arr.length;i++)
        {
            arr[arr[i]%n] +=n;
        }
       
       for(int i=0;i<arr.length;i++)
       {
           if((arr[i]/n) >1 )
           {
               System.out.print(i+" ");
           }
       }
       
       //Be a good person and revert the array like it was provided
       for(int i-0;i<arr.length;i++)
       {
           arr[i]=arr[i]%n;
       }
    }
	//New Code added
	public static void findDuplicates(int[] arr, int n)
	{
	    //Assumption: Array with n Elements containing elements from 0 to n-1
	    
	    
	    
	    for(int i=0;i<n;i++)
	    {
	        arr[arr[i]%n]=arr[arr[i]%n]+n;
	    }
	    for(int a:arr)
	    System.out.print(a+" ");
	    System.out.println();
	    for(int i=0;i<n;i++)
	    {
	        if(arr[i]/n>1){
	            System.out.print(i+" ");
	        }
	    }
	}
	
	public static void findDuplicatesInOrder(int[] arr, int n)
	{
	    int f=0;
	    for(int i=0;i<n;i++)
	    {
	        if(arr[arr[i]%n]>n)
	        {
	            if(arr[arr[i]%n]<2*n)
	            {
	                System.out.print(arr[i]%n+" ");
	                f=1;
	            }
	        }
	        arr[arr[i]%n]=arr[arr[i]%n]+n;
	    }
	    
	    if(f==0)
	    System.out.println("No Repeating Elements");
	}
}

