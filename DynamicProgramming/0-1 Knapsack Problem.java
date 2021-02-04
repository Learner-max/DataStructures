/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int val[] = new int[] { 200,240,140,150 }; 
        int wt[] = new int[] { 1,3,2,5 }; 
        int W = 5; 
        int n = val.length; 
       // System.out.println(knapSackRecursive(W, wt, val, n)); 
        
        //System.out.println("\n++++++++++");
       // System.out.println(knapSackMemorizeUtil(W,wt,val,n));
        //System.out.println("\n++++++++++");
        System.out.println(knapSackTopDown(W,wt,val,n));
	}
	
	/*
	  Recursive knapsack ~O(2^n)
	*/
	public static int knapSackRecursive(int W,int[] wt, int[] val, int n)
	{
	    //Base condition
	    if(n==0|| W==0)
	      return 0;
	      
	    if(wt[n-1]<=W)
	    {
	        return Math.max(val[n-1]+ knapSackRecursive(W-wt[n-1],wt,val,n-1),
	                        knapSackRecursive(W,wt,val,n-1));
	    }else
	    {
	        return knapSackRecursive(W,wt,val,n-1);
	    }
	}
	
	/*
	   Memorization Version of above problem
	*/
	public static int knapSackMemorizeUtil(int W,int[] wt, int[] val,int n)
	{
	    int[][] dp=new int[n+1][W+1];
	    
	    for(int i=0;i<n+1;i++)
	       for(int j=0;j<W+1;j++)
	         dp[i][j]=-1;
	   
	  return  knapSackMemorize(W,wt,val,n,dp);      
	    
	}
	public static int knapSackMemorize(int W,int[] wt, int[] val,int n, int[][] dp)
	{
	    //Recursion+storage
	    //Base condition
	    if(n==0|| W==0)
	      return 0;
	    if(dp[n][W]!=-1)
	    {
	        return dp[n][W];
	    }
	    if(wt[n-1]<=W)
	    {
	        return dp[n][W]=Math.max(val[n-1]+ knapSackRecursive(W-wt[n-1],wt,val,n-1),
	                        knapSackRecursive(W,wt,val,n-1));
	    }else
	    {
	        return dp[n][W]=knapSackRecursive(W,wt,val,n-1);
	    }
	}
	
	/*
	   Top Down Approach
	*/
	public static int knapSackTopDown(int W, int[] wt, int[] val,int n)
	{
	    int[][] t=new int[n+1][W+1];
	    
	    //initialization of t
	    
	   /* for(int i=0;i<n+1;i++){
	       for(int j=0;j<W+1;j++)
	       {
	           if(i==0|| j==0)
	           {
	               t[i][j]=0;
	           }
	       }
	    }*/
	    
	    for(int i=1;i<n+1;i++)
	    {
	        for(int j=1;j<W+1;j++)
	        {
	            if(wt[i-1]<=j)
	            {
	                t[i][j]=Math.max(val[i-1]+ t[i-1][j-wt[i-1]],
	                                    t[i-1][j]);
	            }else
	            {
	                t[i][j]=t[i-1][j];
	            }
	        }
	    }
	    
	    return t[n][W];
	}


}
