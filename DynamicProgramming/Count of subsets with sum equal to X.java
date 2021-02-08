/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    public static void main (String[] args) throws java.lang.Exception
	{
	
    int arr[] = { 2,3,1,7,4,5}; 
    int sum = 7; 
    int n = arr.length; 
  
    System.out.print(//countSubsetSumTopDown(sum,arr,n));
       // countSubsetSumMemorizeUtil(sum,arr, n));
        countSubsetSum(sum,arr, n)); 
    } 
    

	
	/*
	  Recursive Solution ~O(2^n)
	*/
	public static int countSubsetSum(int sum,int[] set, int n)
	{
	    int include=0;
	    int exclude=0;
	    //Base condition
	    if(sum==0)
	    {
	      
	      return 1; // Because we can make empty subset
	    }
	      
	    if(n==0 && sum!=0)
	      return 0; //no subset even empty cannot be formed
	      
	    if(set[n-1]<=sum)
	    {
	        include= countSubsetSum(sum-set[n-1],set,n-1);
	                       
	    }
	       exclude= countSubsetSum(sum,set,n-1);
	       
	       return include+exclude;
	    
	}
	/*
	   Memorization Version of above problem
	*/
	public static int countSubsetSumMemorizeUtil(int sum,int[] set,int n)
	{
	    int[][] dp=new int[n+1][sum+1];
	    
	    for(int i=0;i<n+1;i++)
	       for(int j=0;j<sum+1;j++)
	         dp[i][j]=-1;
	   
	  return  countSubsetSumMemorize(sum,set,n,dp);      
	    
	}
	public static int countSubsetSumMemorize(int sum,int[] set,int n, int[][] dp)
	{
	    //Recursion+storage
	    //Base condition
	     //Base condition
	     int include=0;
	     int exclude=0;
	    if(sum==0)
	      return 1; // Because we can make empty subset
	      
	    if(n==0&& sum!=0)
	      return 0; //no subset even empty cannot be formed
	    if(dp[n][sum]!=-1)
	    {
	        return dp[n][sum];
	    }
	    if(set[n-1]<=sum)
	    {
	       include =countSubsetSumMemorize(sum-set[n-1],set,n-1,dp);
	        dp[n][sum]=include;
	                        
	    }
	        exclude=countSubsetSumMemorize(sum,set,n-1,dp);
	        dp[n][sum]=exclude;
	        return include+exclude;
	    }

	/*
	   Top Down Approach
	*/
	public static int countSubsetSumTopDown(int sum, int[] set,int n)
	{
	    int[][] t=new int[n+1][sum+1];
	    
	    //initialization of t
	    
	    for(int i=0;i<n+1;i++){
	       for(int j=0;j<sum+1;j++)
	       {
	           if(i==0)
	           {
	               t[i][j]=0;
	           }
	           if(j==0)
	             t[i][j]=1;
	       }
	    }
	    
	    for(int i=1;i<n+1;i++)
	    {
	        int include=0;
	        int exclude=0;
	        for(int j=1;j<sum+1;j++)
	        {
	            if(set[i-1]<=j)
	            {
	                include=t[i-1][j-set[i-1]];
	            }
	            exclude=t[i-1][j];
	            t[i][j]=include+exclude;
	            
	        }
	    }
	    
	    return t[n][sum];
	}

    

}
