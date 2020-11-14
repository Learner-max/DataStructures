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
		        Count set bits in a integer.
		        
		            Input : n = 6
                    Output : 2
                    Binary representation of 6 is 110 and has 2 set bits
                    
                    Input : n = 13
                    Output : 3
                    Binary representation of 13 is 1101 and has 3 set bits
		        
		        Method#1 : Naive approach
		        Check Bit in the number and increment the counter if it is set.
		        TC:theta(log n)
		
		        Method#2 : Kernighan’s Algorithm
		        Idea is to subtract Rsbm from the number , it will flip or delete/remove
		        or unset the bit (from 1 to 0)
		        We will repeat this step until number becomes 0. And while doing this 
		        every time we increment the counter.
		        TC: O(logn)
		            Where n means number of set bits in the given number
		            ***** the number of times it loops is equal to the 
		            number of set bits in a given integer*******
		            
		*/
		
		
		int n=13;
		
		countSetBits(n);
	}
	
	public static void countSetBits(int x)
	{
	    int counter=0;
	    
	    while(x!=0)
	    {
	      int rsbm =x & -x;
	        x=x-rsbm;
	        counter++;
	    }
	    
	    System.out.println(counter);
	}
}
