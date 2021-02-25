/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    public static void main (String[] args) throws java.lang.Exception
	{
	
       int coins[] = {2,3,5,6};
        int m = coins.length;
        int V = 10;
        System.out.println(countMinCoinsRecursive(V,coins,m)); 
        System.out.println(countMinCoinsMemorizeUtil(V,coins,m));
        System.out.println(countMinCoinsTopDown(V,coins,m));
        System.out.println(countMinCoins1D(V,coins,m));
    } 
    

	
	/*
	  Recursive Solution ~O(2^n)
	*/
	public static int countMinCoinsRecursive(int sum,int[] set,int n)
	{
	    
	    //Base condition
	    if(sum==0)
	    {
	      
	      return 0; 
	    }
	      
	    if(n==0 && sum!=0)
	      return Integer.MAX_VALUE-1; 
	      
	    if(set[n-1]<=sum)
	    {
	        return Math.min(countMinCoinsRecursive(sum-set[n-1],set,n)+1,countMinCoinsRecursive(sum,set,n-1));
	                       
	    }else{
	       return countMinCoinsRecursive(sum,set,n-1);
	    }
	       
	    
	}
	/*
	   Memorization Version of above problem
	*/
	public static int countMinCoinsMemorizeUtil(int sum,int[] set,int n)
	{
	    int[][] dp=new int[n+1][sum+1];
	    
	    for(int i=0;i<n+1;i++)
	       for(int j=0;j<sum+1;j++)
	         dp[i][j]=-1;
	   
	  return  countMinCoinsMemorize(sum,set,n,dp);      
	    
	}
	public static int countMinCoinsMemorize(int sum,int[] set,int n, int[][] dp)
	{
	    //Base condition
	    if(sum==0)
	    {
	      return 0; 
	    }
	      
	    if(n==0 && sum!=0)
	      return Integer.MAX_VALUE-1; 
	      
	     if(dp[n][sum]!=-1)
	    {
	        return dp[n][sum];
	    }
	    if(set[n-1]<=sum)
	    {
	        return dp[n][sum]=Math.min(countMinCoinsMemorize(sum-set[n-1],set,n,dp)+1,countMinCoinsMemorize(sum,set,n-1,dp));
	                       
	    }else{
	       return dp[n][sum]=countMinCoinsMemorize(sum,set,n-1,dp);
	    }
	   
	    
 }

	/*
	   Top Down Approach
	*/
	public static int countMinCoinsTopDown(int sum, int[] set,int n)
	{
	    int[][] t=new int[n+1][sum+1];
	    
	    //initialization of t
	    
	    for(int i=0;i<n+1;i++){
	       for(int j=0;j<sum+1;j++)
	       {
	           if(i==0)
	             t[i][j]=Integer.MAX_VALUE-1;
	           if(j==0)
	             t[i][j]=0;
	           
	       }
	    }
	    
	    for(int i=1;i<n+1;i++)
	    {
	        for(int j=1;j<sum+1;j++)
	        {
	            if(set[i-1]<=j)
	            {
	                t[i][j]=Math.min(1+t[i][j-set[i-1]],t[i-1][j]);
	            }else
	            {
	            t[i][j]=t[i-1][j];
	           
	            }
	            
	        }
	    }
	    
	    return t[n][sum];
	}
	
	/*
	    Space optimized version of Coin change problem
	*/
	public static int countMinCoins1D(int sum,int[] set,int n)
	{
	    int[] dp=new int[sum+1];
	    Arrays.fill(dp,Integer.MAX_VALUE-1);
	    dp[0]=0;
	    
	    for(int i=0;i<n;i++)
	    {
	        for(int j=set[i];j<=sum;j++)
	        {
	            dp[j]=Math.min(dp[j],1+dp[j-set[i]]);
	        }
	    }
	    
	    return dp[sum];
	}

    

}
