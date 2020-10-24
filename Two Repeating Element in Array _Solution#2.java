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
		
		int[] nums={1,4,5,6,3,2,5,2};
		
		repeatingElements(nums);
	}
	
	public static void repeatingElements(int[] arr) {
        
       
        
        for(int i=0;i<arr.length;i++)
        {
            if(arr[Math.abs(arr[i])]<0)
            {
               System.out.print( Math.abs(arr[i])+" ");
            }
            else{
                arr[Math.abs(arr[i])]=arr[Math.abs(arr[i])]*-1;
            }
        }
       
    }
}

