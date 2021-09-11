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
		
		int x=2;
		int y=3;
		
		System.out.println(powRecursive(x,y));
		System.out.println(powIterative(x,y));
	}
	
	public static int powRecursive(int x,int y)
	{
	    if(y==0)
	    return 1;
	    if(x==0)
	    return 0;
	    return x*powRecursive(x,y-1);
	}
	
	public static int powIterative(int x, int y)
	{
	    int result=1;
	    
	    while(y>0)
	    {
	        if(y%2==0)
	        {
	            x=x*x;
	            y=y/2;
	        }
	        else
	        {
	            result=result*x;
	            y--;
	        }
	    }
	    
	    return result;
	}
}
