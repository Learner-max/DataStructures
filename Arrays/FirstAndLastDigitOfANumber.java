/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   int num=1238900;
	   getLastDigit(num);
	   getFirstDigit(num);
	}
	
	public static void getLastDigit(int num)
	{
	    /* 
	       To get the last digit perform modulo of num with 10
	   */
	   
	   System.out.println("Last Digit "+num%10);
	}
	
	public static void getFirstDigit(int num)
	{
	    /*
	       To get the firstdigit of num we would have to sweat a little bit
	       idea is to use division operation with 10
	    */
	    
	    while(num>=10)
	    {
	        num=num/10;
	    }
	    
	    System.out.println("First Digit "+num);
	}
}
