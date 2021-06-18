/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//GCD Of two numbers
		int a=7;
		int b=5;
		findGCD_LCM(a,b);
		findLCM(a,b);
		
	}
	
	public static void findGCD_LCM(int a, int b)
	{
	    int oa=a;
	    int ob=b;
	    while(a % b!=0)
	    {
	        int rem=a%b;
	        a=b;
	        b=rem;
	    }
	    System.out.println("GCD "+b);
	    int LCM=(oa*ob)/b;
	    System.out.println("LCM "+LCM);
	}
	
	public static void findLCM(int a, int b)
	{
	    int max=Math.max(a,b);
	    System.out.println(max);
	    int min=Math.min(a,b);
	    int temp=max;
	    while(max%min!=0)
	    {
	        max+=temp;
	        System.out.println(max);
	    }
	    System.out.println("LCM "+max);
	}
}
