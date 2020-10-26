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
		int[] arr={1, 2, 3, 4, 5};
		//{12, 3, 4, 1, 6, 9};
		int sum=9;
		//24;
		
	    findTriplet(arr, sum);
	    System.out.println("+++++++++++++++++++++++++++");
		findTripletsUsingHashMap(arr, sum);
	}
	
	//The TC:O(n^2) SC:O(n)
	public static void findTriplet(int[] arr, int sum)
	{
	    int n=arr.length;
	    if(n<=3)
	    return;
	    Arrays.sort(arr);
	    for(int i=0;i<n-2;i++)
	    {
	        int l=i+1;
	        int r=n-1;
	        while(l<r)
	        {
	            int target_sum=arr[l]+arr[r]+arr[i];
	            if(sum==target_sum)
	            {
	                System.out.print("Triplet's are :"+ arr[i]+" "+ arr[l]+ " "+arr[r]);
	                return;
	            }
	            if(target_sum<sum)
	            {
	                l++;
	            }
	            else
	            r--;
	        }
	    }
	}
	
	
	// Using HashMap
	public static void findTripletsUsingHashMap(int[] arr,int sum)
	{
	    int n=arr.length;
	    if(n<=3)
	    return;
	    
	    for(int i=0;i<n-2;i++)
	    {
	        HashSet<Integer> set= new HashSet<>();
	        int target=sum-arr[i];
	        for(int j=i+1;j<n;j++)
	        {
	            if(set.contains(target-arr[j]))
	            {
	                System.out.print("Triplet's are : "+arr[i]+" "+arr[j]+" "+(target-arr[j]));
	                return;
	            }
	            set.add(arr[j]);
	        }
	    }
	    
	   System.out.println("No Triplet's");
	}
	
}


