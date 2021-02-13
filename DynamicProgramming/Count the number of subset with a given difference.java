/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    public static void main (String[] args) throws java.lang.Exception
	{
	
    int arr[] = {1,1,2,3};
        int n = arr.length;
        int diff=1;
        System.out.print("The count of subsets with difference"+ diff+
                        " between two sets is " + 
                         countSubsetsWithDiff(arr, n,diff));
    } 
    
    public static int countSubsetsWithDiff(int[] arr, int n,int diff)
    {
        int totalSum=0;
        for(int i=0;i<n;i++)
        {
            totalSum+=arr[i];
        }
        
      int sum=(diff+totalSum)/2;
      //return countSubsetsWithDiffRecursive(arr,n,sum);
      //return countSubsetsWithDiffMemorizeUtil(arr,n,sum);
      return countSubsetsWithDiffTopDown(arr,n,sum);
    }
	
	/*
	  Recursive Solution ~O(2^n)
	*/
	public static int countSubsetsWithDiffRecursive(int[] arr, int n,int sum)
	{
	  int include=0;
	  int exclude=0;
	  //Base condition
	  if(sum==0)
	    return 1;
	  if(n==0 && sum!=0)
	     return 0;
	  if(arr[n-1]<=sum)
	  {
	      include=countSubsetsWithDiffRecursive(arr,n-1,sum-arr[n-1]);
	  }
	  exclude=countSubsetsWithDiffRecursive(arr,n-1,sum);
	  return include+exclude;
	   
	}
	/*
	   Memorization Version of above problem
	*/
	public static int countSubsetsWithDiffMemorizeUtil(int[] arr, int n,int sum)
	{
	    int[][] dp=new int[n+1][sum+1];
	    
	    for(int i=0;i<n+1;i++)
	       for(int j=0;j<sum+1;j++)
	         dp[i][j]=-1;
	   
	  return countSubsetsWithDiffMemorize(arr,n,sum,dp);      
	    
	}
	public static int countSubsetsWithDiffMemorize(int[] arr, int n,int sum, int[][] dp)
	{
	    //Recursion+storage
	    //Base condition
      int include=0;
	  int exclude=0;
	  //Base condition
	  if(sum==0)
	    return 1;
	  if(n==0 && sum!=0)
	     return 0;
	   if(dp[n][sum]!=-1)
	      return dp[n][sum];
	  if(arr[n-1]<=sum)
	  {
	      include=countSubsetsWithDiffMemorize(arr,n-1,sum-arr[n-1],dp);
	  }
	  exclude=countSubsetsWithDiffMemorize(arr,n-1,sum,dp);
	  dp[n][sum]=include+exclude;
	  return include+exclude;
	   
	  
	    }

	/*
	   Top Down Approach
	*/
	public static int countSubsetsWithDiffTopDown(int[] arr, int n,int sum)
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
	            if(arr[i-1]<=j)
	            {
	                include=t[i-1][j-arr[i-1]];
	            }
	            
	              exclude= t[i-1][j];
	              t[i][j]=include+exclude;
	            
	        }
	    }
	    
	   
	   return t[n][sum];
	}

    

}
