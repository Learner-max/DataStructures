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
		
		/*Input:   str = "Ab,c,de!$"
       Output:  str = "ed,c,bA!$"*/
       String input="Ab,c,de!$";
       reverseString(input);
       
	}
	
	public static void reverseString(String input)
	{
	    int l=0;
	    
	    char[] ch=input.toCharArray();
	    int r=ch.length-1;
	    System.out.println(isAlphabet(ch[l]));
	    while(l<r )
	    {
	        if(isAlphabet(ch[r]) && isAlphabet(ch[l]))
	            {
	                char temp=ch[l];
	                ch[l]=ch[r];
	                ch[r]=temp;
	                l++;
	                r--;
	            }
	         if(!isAlphabet(ch[l]))
	            {
	                l++;
	            }
	            if(!isAlphabet(ch[r]))
	            {
	                r--;
	            }
	   }
	    
	    String sb=" ";
	    for(char c:ch)
	    {
	        sb=sb+c;
	    }
	    System.out.print(sb);
	    
	}
	
	public static boolean isAlphabet(char x)
	{
	    if((x>='a' && x<='z' ) || (x>='A' && x<='Z'))
	       return true;
	    return false;
	}
}
