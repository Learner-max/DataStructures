/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Determine if a string has all Unique Characters
		/*
		    Input : abcd10jk
            Output : true
            
            Input : hutg9mnd!nk9
            Output : false

		*/
		String s="hutg9mnd!nk9";
		
		//System.out.println(uniqueCharString(s));
		//System.out.println(uniqueCharString1(s));
		System.out.println(uniqueCharString2(s));
	
		
	}
	//Using HashSet 
	public static boolean uniqueCharString(String s)
	{
	    HashSet<Character> hs=new HashSet<>();
	    
	    for(char c:s.toCharArray())
	    {
	        if(hs.contains(c))
	        {
	            return false;
	        }else
	        {
	            hs.add(c);
	        }
	    }
	    
	    return true;
	}
	
	//Using Fixed Size Array
	public static boolean uniqueCharString1(String s)
	{
	    boolean[] res=new boolean[256];
	    
	    for(int i=0;i<s.length();i++)
	    {
	        char c=s.charAt(i);
	        //int j=c-'a';
	        if(res[c]==false)
	           res[c]=true;
	        else
	        {
	            return false;
	        }
	    }
	    
	    return true;
	}
	
	//Using Bit Vector
	public static boolean uniqueCharString2(String s)
	{
	  int checked=0;
	  for(int i=0;i<s.length();i++)
	  {
	      int ch=s.charAt(i)-'a';
	      if((checked &(1<<ch))>0)
	      {
	          return false;
	      }
	      checked=checked | (1<<ch);
	  }
	  
	  return true;
	}
}
