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
	
	//TC of this approach O(n) cuz (Note: Even though we have nested for loops, start only goes from 0 to s.length() once
	public int lengthOfLongestSubstring(String s) {
       // System.out.println(s.trim().length());
        if(s.length()==0)
            return 0;
        if(s.length()==1 || s.trim().length()==0)
            return 1;
        int[] count=new int[128];
        int start=0;
        int maxLen=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++)
        {
            
            count[s.charAt(i)]++;
            if(count[s.charAt(i)]>1)
            {
                while(count[s.charAt(i)]>1)
                {
                    count[s.charAt(start)]--;
                    start++;
                }
            }  
            maxLen=Math.max(maxLen,(i-start+1));
                
            
        }
        
        return maxLen;
    }
	
}
