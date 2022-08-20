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
		int num=2;
		
		int power=4;
		
		System.out.println(powerRecursive(num,power));
	}
	
	public static int powerRecursive(int num, int power)
	{
	    if(power==0)
	     return 1;
	     
       if(power==1)
         return num;
         
        int ans=powerRecursive(num,power/2);
        
        if(power%2==0)
          return ans*ans;
        else
          return num*ans*ans;
	}
}
