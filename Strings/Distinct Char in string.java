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
		
		String str="Geeks for Geeks";
		System.out.println(countDistinctChar(str));
	}
	public static int countDistinctChar(String s)
	{
	    if(s==null || s.length()==0)
	    return 0;
	    
	    int[] count=new int[256];
	    int[] index=new int[256];
	    int n=s.length();
	    Arrays.fill(index,n);
	    
	    for(int i=0;i<n;i++)
	    {
	        count[s.charAt(i)]++;
	         if(count[s.charAt(i)]==1 && s.charAt(i)!=' ')
	         {
	             
	             index[s.charAt(i)]=i;
	         }
	         else if(count[s.charAt(i)]>1)
	         {
	            // count[s.charAt(i)]++;
	             index[s.charAt(i)]=n;
	         }
	             
	     
	    }
	    int countR=0;
	    for(int c:index)
	    {
	        if(c!=n)
	        {
	            countR++;
	            System.out.print(s.charAt(c)+" ");
	        }
	    }
	    
	    return countR;
	}
}
