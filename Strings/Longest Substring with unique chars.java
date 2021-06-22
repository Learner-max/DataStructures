/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
     public static void main(String[] args)
     {
         String s = "geeksforgeeks";
        System.out.println("The input String is " + s);
        int length = longestUniqueSubstr(s);
        System.out.println(length);
     }

	 public static int longestUniqueSubstr(String s)
	 {
	     HashMap<Character, Integer> map=new HashMap<>();
	     int start=0;
	     int maxLen=Integer.MIN_VALUE;
	     
	     for(int end=0;end<s.length();end++)
	     {
	         if(map.containsKey(s.charAt(end)))
	         {
	             start=Math.max(start,map.get(s.charAt(end))+1);
	         }
	         map.put(s.charAt(end),end);
	         maxLen=Math.max(maxLen,end-start+1);
	         
	     }
	     
	     return maxLen;
	 }
	
}
