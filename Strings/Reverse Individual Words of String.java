/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		String str = "Hello World";
        //reverseWordsInString(str);
        reverseWordsStreams(str);
	}
	
	public static void reverseWordsInString(String s)
	{
	   if(s==null || s.length()==0)
	     return;
	   
	   Stack<Character> st=new Stack<>();
	   
	   for(int i=0;i<s.length();i++)
	   {
	       if(s.charAt(i)!=' ')
	       {
	           st.push(s.charAt(i));
	       }else
	       {
	           while(!st.isEmpty())
	           {
	               System.out.print(st.pop());
	           }
	            System.out.print(" ");
	       }
	      
	   }
	   
	   while(!st.isEmpty())
       {
           System.out.print(st.pop());
       }
	      
	}
	
	public static void reverseWordsStreams(String s)
	{
	    String res=Arrays.asList(s.split(" ")).stream()
	    .map(item->new StringBuilder(item).reverse())
	    .collect(Collectors.joining(" "));
	    
	    System.out.println(res);
	}
}
