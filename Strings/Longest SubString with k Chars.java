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
		/*String input="Geeks for Geeks";
		System.out.println(countDistinctChars(input));*/
		
		String str="abcbdbdbbdcdabd";
		int k=2;
		System.out.println(longestSubString(str,k));
	}
	
	public static int countDistinctChars(String input)
	{
	    if(input==null || input.length()==0)
	    return -1;
	    
	    boolean[] chars=new boolean[256];
	    int count=0;
	    
	    for(int i=0;i<input.length();i++)
	    {
	        if(chars[input.charAt(i)]==true)
	        count++;
	        else
	        chars[input.charAt(i)]=true;
	    }
	    
	    return count;
	}

	
	public static int longestSubString(String s, int k)
	{
	    if(s==null || s.length()==0)
	    return -1;
	    
	    Map<Character,Integer> map=new HashMap<>();
	    int start=0;
	    int end=0;
	    int windowSize=0;
	    int maxWindowSize=Integer.MIN_VALUE;
	    String window="";
	    while(end<=s.length()-1)
	    {
	        char requiredChar=s.charAt(end);
	        addToMap(map,requiredChar);
	        
	        if(map.size()==k)
	        {
	            windowSize=end-start+1;
	            if(maxWindowSize<windowSize)
	            {
	                maxWindowSize=windowSize;
	                window=s.substring(start,end+1);
	            }
	        }else if(map.size()>k)
	        {
	            while(map.size()>k)
	            {
	                char charTobeRemoved=s.charAt(start);
	                map.put(charTobeRemoved,map.get(charTobeRemoved)-1);
	                if(map.get(charTobeRemoved)==0)
	                	map.remove(charTobeRemoved);
	                
	                start++;
	            }
	            
	        }
	        
	        end++;
	    }
	    System.out.println(window);
	    return maxWindowSize;
	    
	}
	
	public static void addToMap(Map<Character, Integer> map,char ch)
	{
	    if(map.containsKey(ch))
	    {
	        map.put(ch,map.get(ch)+1);
	    }else
	    {
	        map.put(ch,1);
	    }
	}
}
