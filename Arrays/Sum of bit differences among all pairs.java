/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		/*
		    Sum of bit differences among all pairs.
		    Bit difference of a pair (x, y) is count of different bits
		    at same positions in binary representations of x and y.
		    
            Input: arr[] = {1, 2}
            Output: 4
            All pairs in array are (1, 1), (1, 2)
                                   (2, 1), (2, 2)
            Sum of bit differences = 0 + 2 +
                                     2 + 0
                                  = 4
            
            Input:  arr[] = {1, 3, 5}
            Output: 8
            All pairs in array are (1, 1), (1, 3), (1, 5)
                                   (3, 1), (3, 3) (3, 5),
                                   (5, 1), (5, 3), (5, 5)
            Sum of bit differences =  0 + 1 + 1 +
                                      1 + 0 + 2 +
                                      1 + 2 + 0 
                                   = 8
		*/
		
		int[] arr={1,2};
		
		sumOfDifferentBits(arr);
	}
	
	public static void sumOfDifferentBits(int[] arr)
	{
	    long res=0;
	    
	    for(int i=0;i<32;i++)
	    {
	        int counton=0;
	        for(int a:arr)
	        {
	            if((a & (1<< i) )!=0)
	            counton++;
	        }
	        int countoff=arr.length-counton;
	        int diff=counton*countoff*2;
	        
	        res=res+diff;
	    }
	    
	    System.out.println(res);
	}
}
