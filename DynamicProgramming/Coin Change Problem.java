import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    public static void main (String[] args) throws java.lang.Exception
	{
	
        int arr[] = {1, 2, 3}; //Coins of given dinominatons
        int m = arr.length; 
        int n = 4; //No of ways to be found for sum=4 using coins of dinominations as in arr
        System.out.println(countWaysRecursive( n,arr,m)); 
        System.out.println(countWaysMemorizeUtil(n,arr,m));
        System.out.println(countWaysTopDown(n,arr,m));
        System.out.println(countWays1D(n,arr,m));
    } 
    

	
	/*
	  Recursive Solution ~O(2^n)
	*/
	public static int countWaysRecursive(int sum,int[] set,int n)
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
	        include= countWaysRecursive(sum-set[n-1],set,n);
	                       
	    }
	       exclude= countWaysRecursive(sum,set,n-1);
	       
	       return include+exclude;
	    
	}
	/*
	   Memorization Version of above problem
	*/
	public static int countWaysMemorizeUtil(int sum,int[] set,int n)
	{
	    int[][] dp=new int[n+1][sum+1];
	    
	    for(int i=0;i<n+1;i++)
	       for(int j=0;j<sum+1;j++)
	         dp[i][j]=-1;
	   
	  return  countWaysMemorize(sum,set,n,dp);      
	    
	}
	public static int countWaysMemorize(int sum,int[] set,int n, int[][] dp)
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
	       include =countWaysMemorize(sum-set[n-1],set,n,dp);
	        //dp[n][sum]=include;
	                        
	    }
	        exclude=countWaysMemorize(sum,set,n-1,dp);
	        dp[n][sum]=include+exclude;
	        return include+exclude;
	    }

	/*
	   Top Down Approach
	*/
	public static int countWaysTopDown(int sum, int[] set,int n)
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
	                include=t[i][j-set[i-1]];
	            }
	            exclude=t[i-1][j];
	            t[i][j]=include+exclude;
	            
	        }
	    }
	    
	    return t[n][sum];
	}
	
	/*
	    Space optimized version of Coin change problem
	*/
	public static int countWays1D(int sum,int[] set,int n)
	{
	    int[] dp=new int[sum+1];
	    dp[0]=1;
	    
	    for(int i=0;i<n;i++)
	    {
	        for(int j=set[i];j<=sum;j++)
	        {
	            dp[j]=dp[j]+dp[j-set[i]];
	        }
	    }
	    
	    return dp[sum];
	}

    

}
