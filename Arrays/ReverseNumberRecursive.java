/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static int base_pos=1;
    static int rev_num=0;
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		int x=12345;
	
		
		System.out.println(reverseNumberRecursive(x));
	
	}
	
	public static int reverseNumberRecursive(int x)
	{
	    if(x>0){
	    reverseNumberRecursive(x/10);
	    rev_num=rev_num+(x%10)*base_pos;
	    base_pos=base_pos*10;
	   
	    }
	    //System.out.println(rev_num);
	    return rev_num;
	}
	
	
}
