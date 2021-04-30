/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	 
	   //Anagram Strings
	   String s1="Listen";
	   String s2="Silenj";
	   
	   String input1=s1.toLowerCase();
	   String input2=s2.toLowerCase();
	   
	   System.out.println(areAnagramStrings(input1,input2));
	 	
	}
	
	public static boolean areAnagramStrings(String input1,String input2)
	{
	    //Time Complexity=O(n) and Space Complexity:O(1)
	    if(input1.length()!=input2.length())
	      return false;
	    int[] countArr=new int[26];
	    for(int i=0;i<input1.length();i++)
	    {
	        countArr[input1.charAt(i)-'a']++;
	        countArr[input2.charAt(i)-'a']--;
	    }
	    
	    for(int i=0;i<26;i++)
	    {
	        if(countArr[i]!=0)
	        return false;
	    }
	    return true;
	}
}
