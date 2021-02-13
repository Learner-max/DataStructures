/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    public static void main (String[] args) throws java.lang.Exception
	{
	
    int arr[] = {3, 1, 4, 2, 2, 1};
        int n = arr.length;
        System.out.print("The minimum difference"+
                        " between two sets is " + 
                         findMin(arr, n));
    } 
    
    public static int findMin(int[] arr, int n)
    {
        int totalSum=0;
        for(int i=0;i<n;i++)
        {
            totalSum+=arr[i];
        }
        
        //return minSubsetSumDiffRecursive(arr,n,totalSum,0);
       // return minSubsetSumDiffMemorizeUtil(arr,n,totalSum,0);
       // return minSubsetSumDiffTopDown(arr,n,totalSum);
        return minSubsetSumDiffTopDown(arr,n,totalSum);
    }
	
	/*
	  Recursive Solution ~O(2^n)
	*/
	public static int minSubsetSumDiffRecursive(int[] arr, int n,int totalSum,int calSum)
	{
		//Base condition
	    
	    if(n==0)
	      return Math.abs((totalSum-calSum)-calSum); //no subset even empty cannot be formed
	   
	   return Math.min(minSubsetSumDiffRecursive(arr,n-1,totalSum,calSum+arr[n-1]), minSubsetSumDiffRecursive(arr,n-1,totalSum,calSum));
	    
	}
	/*
	   Memorization Version of above problem
	*/
	public static int minSubsetSumDiffMemorizeUtil(int[] arr, int n,int sum,int calSum)
	{
	    int[][] dp=new int[n+1][sum+1];
	    
	    for(int i=0;i<n+1;i++)
	       for(int j=0;j<sum+1;j++)
	         dp[i][j]=-1;
	   
	  return minSubsetSumDiffMemorize(arr,n,sum,calSum,dp);      
	    
	}
	public static int minSubsetSumDiffMemorize(int[] arr, int n,int totalSum,int calSum, int[][] dp)
	{
	    //Recursion+storage
	    //Base condition

	    if(n==0)
	      {
	          return Math.abs((totalSum-calSum)-calSum); //no subset even empty cannot be formed
	      }
	      if(dp[n][calSum]!=-1)
	        return dp[n][calSum];
	   
	   return dp[n][calSum]=Math.min(minSubsetSumDiffRecursive(arr,n-1,totalSum,calSum+arr[n-1]), minSubsetSumDiffRecursive(arr,n-1,totalSum,calSum));
	    
	    }

	/*
	   Top Down Approach
	*/
	public static int minSubsetSumDiffTopDown(int[] arr, int n,int sum)
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
	            if(arr[i-1]<=j)
	            {
	                t[i][j]=t[i-1][j-arr[i-1]]||t[i-1][j];
	            }
	            else
	              t[i][j]= t[i-1][j];
	            
	        }
	    }
	    
	   int j=sum/2;
	   int min=Integer.MAX_VALUE;
	   for(int i=0;i<=j;i++)
	   {
	       if(t[n][i]==true  && min>(sum-(2*i)))
	         min=sum-(2*i);
	   }
	   
	   return min;
	}

    

}
