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
		String exp="(())]";
		System.out.println(checkIfBalanced(exp));
	}
	
	public static boolean checkIfBalanced(String exp)
	{
	    if(exp==null ||exp.length()==0)
	    {
	        return false;
	    }
	    
	    Stack<Character> s=new Stack<>();
	    for(int i=0;i<exp.length();i++)
	    {
	        if(exp.charAt(i)=='(' || exp.charAt(i)=='[' || exp.charAt(i)=='{')
	        s.push(exp.charAt(i));
	        else if(s.isEmpty())
	        return false;
	        else if((exp.charAt(i)==')' && s.peek()=='(')||
	        (exp.charAt(i)==']' && s.peek()=='[')||
	        (exp.charAt(i)=='}' && s.peek()=='{'))
	        {
	           s.pop();
	        }else
	        {
	            return false;
	        }
	    }
	    
	    return s.isEmpty();
	}
}
