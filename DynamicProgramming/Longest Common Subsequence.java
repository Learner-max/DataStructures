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
		


	String s1 = "abcba"; 
    String s2 = "abcbcba"; 
  
    char[] X=s1.toCharArray(); 
    char[] Y=s2.toCharArray(); 
    int m = X.length; 
    int n = Y.length; 
    System.out.println(LCSRecursive(X,Y,m,n));
    System.out.println(LCSMemonizeUtil(X,Y,m,n));
    
    System.out.println(LCSTopDown(X,Y,m,n));
    if(s1.length()>s2.length())
    System.out.println(LCSSpaceOptimized(s1,s2));
    else
    	System.out.println(LCSSpaceOptimized(s2,s1));
		}
	
	public static int LCSRecursive(char[] X,char[] Y,int m,int n)
	{
	    //Base Condition
	    if(m==0 || n==0)
	    {
	        return 0;
	    }
	    
	    if(X[m-1]==Y[n-1])
	    {
	        return 1+LCSRecursive(X,Y,m-1,n-1);
	    }else
	    {
	        return Math.max(LCSRecursive(X,Y,m,n-1),LCSRecursive(X,Y,m-1,n));
	    }
	}
	
	//Memonize version
	public static int LCSMemonizeUtil(char[] X,char[] Y,int m,int n)
	{
	    int[][] dp=new int[m+1][n+1];
	    
	    for(int i=0;i<m+1;i++)
	    {
	        for(int j=0;j<n+1;j++)
	          dp[i][j]=-1;
	    }
	    
	    return LCSMemonize(X,Y,m,n,dp);
	    
	}
	
	public static int LCSMemonize(char[] X,char[] Y,int m, int n,int[][] dp)
	{
	   //Base Condition
	    if(m==0 || n==0)
	    {
	        return 0;
	    }
	    
	    if(dp[m][n]!=-1)
	    {
	        return dp[m][n];
	    }
	    
	    if(X[m-1]==Y[n-1])
	    {
	        return dp[m][n]=1+LCSMemonize(X,Y,m-1,n-1,dp);
	    }else
	    {
	        return dp[m][n]=Math.max(LCSMemonize(X,Y,m,n-1,dp),LCSMemonize(X,Y,m-1,n,dp));
	    }
	}
	
	//Top Down Version
	public static int LCSTopDown(char[] X,char[] Y,int m,int n)
	{
	    //matrix creation
	    int[][] t=new int[m+1][n+1];
	    for(int i=1;i<m+1;i++)
	    {
	        for(int j=1;j<n+1;j++)
	        {
	            if(X[i-1]==Y[j-1])
	            t[i][j]=1+t[i-1][j-1];
	            else
	            {
	                t[i][j]=Math.max(t[i][j-1],t[i-1][j]);
	            }
	        }
	    }
	    
	    return t[m][n];
	}
	
    public static int LCSSpaceOptimized(String s1,String s2)
	{
		char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int m = X.length; 
	    int n = Y.length;
	    int[] dp=new int[n+1];
	    int prev=0;
	    int temp=0;
	    for(int i=1;i<=m;i++)
	    {
	        prev=0;
	        for(int j=1;j<=n;j++)
	        {
	            temp=dp[j];
	            if( X[i-1]==Y[j-1])
	            {
	                dp[j]=1+dp[j-1];
	            }else
	            {
	                dp[j]=Math.max(dp[j],dp[j-1]);
	            }
	            prev=temp;
	        }
	      
	    }
	    
	    return dp[n];
	}
}
