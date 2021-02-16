/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    //Unbounded Knapsack
	public static void main (String[] args) throws java.lang.Exception
	{
		int W = 8;
        int val[] = {10, 40, 50, 70};
        int wt[] = {1, 3, 4, 5};
        int n = val.length;
       // System.out.println(unboundedKnapSackRecursive(W, wt,val,n));
        //System.out.println(unboundedKnapSackMemonize(W,wt,val,n));
        //System.out.println(unboundedKnapSackTopDown(W,wt,val,n));
        System.out.println(unboundedKnapSackSpaceOptimized(W,wt,val,n));
	}
	
	/*
	  Recursive knapsack ~O(2^n)
	*/
	public static int unboundedKnapSackRecursive(int W,int[] wt, int[] val, int n)
	{
	    //Base condition
	    if(n==0|| W==0)
	      return 0;
	      
	    if(wt[n-1]<=W)
	    {
	        return Math.max(val[n-1]+ unboundedKnapSackRecursive(W-wt[n-1],wt,val,n),
	                        unboundedKnapSackRecursive(W,wt,val,n-1));
	    }else
	    {
	        return unboundedKnapSackRecursive(W,wt,val,n-1);
	    }
	}
	
	/*
	  Unbounded Knapsack Memonoize version
	*/
	public static int unboundedKnapSackMemonize(int W,int[] wt, int[] val, int n)
	{
	    int[][] dp=new int[n+1][W+1];
	    
	    for(int i=0;i<n+1;i++)
	    {
	        for(int j=0;j<W+1;j++)
	        {
	            dp[i][j]=-1;
	        }
	    }
	    
	    return unboundedKnapSackMemonizeUtil(W,wt,val,n,dp);
	}
	
	public static int unboundedKnapSackMemonizeUtil(int W,int[] wt, int[] val, int n,int[][] dp)
	{
	    //Base condition
	    if(n==0|| W==0)
	      return 0;
	      
	    if(dp[n][W]!=-1)
	       return dp[n][W];
	    if(wt[n-1]<=W)
	    {
	        return dp[n][W]=Math.max(val[n-1]+ unboundedKnapSackMemonizeUtil(W-wt[n-1],wt,val,n,dp),
	                        unboundedKnapSackMemonizeUtil(W,wt,val,n-1,dp));
	    }else
	    {
	        return dp[n][W]=unboundedKnapSackMemonizeUtil(W,wt,val,n-1,dp);
	    }
	}
	
	/*
	  Top Down Approach
	*/
	public static int unboundedKnapSackTopDown(int W,int[] wt, int[] val, int n)
	{
	    
	    int[][] t=new int[n+1][W+1];
	    
	    for(int i=0;i<n+1;i++)
	    {
	        for(int j=0;j<W+1;j++)
	        {
	            if(i==0)
	            t[i][j]=0;
	            if(j==0)
	            t[i][j]=0;
	        }
	    }
	    
	    for(int i=1;i<n+1;i++)
	    {
	        for(int j=1;j<W+1;j++)
	        {
	            if(wt[i-1]<=j)
	            {
	                t[i][j]=Math.max(val[i-1]+t[i][j-wt[i-1]],t[i-1][j]);
	            }
	            else
	            {
	                t[i][j]=t[i-1][j];
	            }
	        }
	    }
	    
	    return t[n][W];
	}
	
	/*
	   Space Optimized version makes use of 1D
	*/
	public static int unboundedKnapSackSpaceOptimized(int W,int[] wt, int[] val, int n)
	{
	    int[] dp=new int[W+1];
	    
	    dp[0]=0;
	    
	    for(int i=0;i<W+1;i++)
	    {
	        for(int j=0;j<n;j++)
	        {
	            if(wt[j]<=i)
	            dp[i]=Math.max(dp[i],dp[i-wt[j]]+val[j]);
	        }
	    }
	    
	    return dp[W];
	}
}
