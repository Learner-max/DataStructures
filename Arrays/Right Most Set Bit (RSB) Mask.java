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
    		 Rightmost Set Bit Mask (Rsb)
    		 Given a number in Decimal Base -> Binary Base-> Right most set bit is a last bit 
    		 with value 1 before which there can be any number of 0's and 1's and after which only 
    		 0's should be there.
    		    
    		    Rsb Mask would be a binary reperentation of number with only Right most set bit as1
    		    and rest all bits as 0.
    		    
    		    Formula:
    		    Rsbm= x & (~x+1)
    		    Where x= Given number
    		          ~x = 1's complement of given number
    		          (~x+1) = 2's complement of a given number
    		
    		*/
    		
    		int x=76;
    		findRsb(x);
	}
	
	public static void findRsb(int x)
	{
	    x=x & -x;
	    System.out.println(Integer.toBinaryString(x));
	}
}
