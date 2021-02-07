/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
	{
		//Equal Sum Parition Problem DP
	    int arr[] = { 1,5,5,11 };
        int n = arr.length;
       
        // Function call
        if (isEqualSumPartiton(arr, n) == true)
            System.out.println("Can be divided into two "
                               + "subsets of equal sum");
        else
            System.out.println(
                "Can not be divided into "
                + "two subsets of equal sum");
    }
    

	
	/*
	  Recursive Solution ~O(2^n)
	*/
	public static boolean isEqualSumPartiton(int[] arr, int n)
	{
	    
	    int arrSum=0;
	    for(int i=0;i<arr.length;i++)
	    {
	        arrSum+=arr[i];
	    }
	    if(arrSum%2!=0)
	      return false;
	    else
	    {
	        //return isSubsetSumRecursive(arrSum/2,arr,n);
	        return isSubsetSumSpaceOptimize(arrSum/2,arr,n);
	    }
	}
	public static boolean isSubsetSumRecursive(int sum,int[] set, int n)
	{
	    //Base condition
	    if(sum==0)
	      return true; // Because we can make empty subset
	      
	    if(n==0 && sum!=0)
	      return false; //no subset even empty cannot be formed
	      
	    if(set[n-1]<=sum)
	    {
	        return isSubsetSumRecursive(sum-set[n-1],set,n-1)||
	                        isSubsetSumRecursive(sum,set,n-1);
	    }else
	    {
	        return isSubsetSumRecursive(sum,set,n-1);
	    }
	}
	
	/*
	   Memorization Version of above problem
	*/
	public static boolean isSubsetSumMemorizeUtil(int sum,int[] set,int n)
	{
	    boolean[][] dp=new boolean[n+1][sum+1];
	    
	    for(int i=0;i<n+1;i++)
	       for(int j=0;j<sum+1;j++)
	         dp[i][j]=false;
	   
	  return  isSubsetSumMemorize(sum,set,n,dp);      
	    
	}
	public static boolean isSubsetSumMemorize(int sum,int[] set,int n, boolean[][] dp)
	{
	    //Recursion+storage
	    //Base condition
	     //Base condition
	    if(sum==0)
	      return true; // Because we can make empty subset
	      
	    if(n==0)
	      return false; //no subset even empty cannot be formed
	    if(dp[n][sum]!=false)
	    {
	        return dp[n][sum];
	    }
	    if(set[n-1]<=sum)
	    {
	        return dp[n][sum]=isSubsetSumMemorize(sum-set[n-1],set,n-1,dp)||
	                        isSubsetSumMemorize(sum,set,n-1,dp);
	    }else
	    {
	        return dp[n][sum]=isSubsetSumMemorize(sum,set,n-1,dp);
	    }
	}
	
    /*
	   Top Down Approach
	*/
	public static boolean isSubsetSumTopDown(int sum, int[] set,int n)
	{
	    boolean[][] t=new boolean[n+1][sum+1];
	    
	    //initialization of t
	    
	    for(int i=0;i<n+1;i++){
	       for(int j=0;j<sum+1;j++)
	       {
	           if(i==0)
	           {
	               t[i][j]=false;
	           }
	           if(j==0)
	             t[i][j]=true;
	       }
	    }
	    
	    for(int i=1;i<n+1;i++)
	    {
	        for(int j=1;j<sum+1;j++)
	        {
	            if(set[i-1]<=j)
	            {
	                t[i][j]=t[i-1][j-set[i-1]]||
	                                    t[i-1][j];
	            }else
	            {
	                t[i][j]=t[i-1][j];
	            }
	        }
	    }
	    
	    return t[n][sum];
	}

	/*
	  Space Optimized version of Subset sum problem
	*/
public static  boolean  isSubsetSumSpaceOptimize(int sum, int[] set, int n)
{
    boolean[] t=new boolean[sum+1];
    
    t[0]=true;
    for(int i=1;i<n;i++)
    {
         for(int j=sum;j>=set[i-1];j--)
         {
             t[j]=t[j]||t[j-set[i-1]];
         }
    }
  
    return t[sum];
}

}
