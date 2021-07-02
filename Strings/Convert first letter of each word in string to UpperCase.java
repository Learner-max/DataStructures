/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	
	public static void main (String[] args) throws java.lang.Exception
	{
		//Capitalize first character of each word in a string
		String s="preeti this is";
	
		System.out.println(firstLetterWord(s.substring(0,1).toUpperCase()+s.substring(1)));
      
	}
	
	public static String firstLetterWord(String s)
	{
	    if(s==null || s.length()==0)
	       return s;
	       
	   int start=0;
	   int end=s.length()-1;
	   String s1="";
	   while(start<=end)
	   {
		   int l=start;
		   if(s.charAt(start)!=' ')
		   {
			   while(start<=end && s.charAt(start)!=' ' )
		       {
		           start++;
		       }
			   
			  s= s.substring(0, l)+s.substring(l,l+1).toUpperCase()+s.substring(l+1);
			 
		   }else
		   {
			   start++;
		   }
		   
	      
	   }
	   return s;
	}

	public static String trimString(String s)
	{
		int start=0;
		int end=s.length()-1;
		
		
			
			
			while(start<=end && s.charAt(start)==' ')
			{
				start++;
			}
			
			
			while(end>=start && s.charAt(end)==' ')
			{
				end--;
			}
		
		
		return new String(s.substring(start,end+1));
	}


}
