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
		 String str = "geeks for       geeks geeks      for geeks";
        firstLetterWord(str);
	}
	
	public static void firstLetterWord(String s)
	{
	    if(s==null || s.length()==0)
	       return;
	       
	   int start=0;
	   int end=s.length()-1;
	   //String s1="";
	   while(start<=end)
	   {
		   int l=start;
		   if(s.charAt(start)!=' ')
		   {
			   while(start<=end && s.charAt(start)!=' ' )
		       {
		           start++;
		       }
			   //s1=s.substring(l,start);
			   
			   System.out.print(s.charAt(l)+"");
		   }else
		   {
			   start++;
		   }
		   
	      
	   }
}
