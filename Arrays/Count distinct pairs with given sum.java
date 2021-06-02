/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        System.out.println(countDistinctPairs(new int[]{1,1,2,45,46,46}, 47));		// 2
		System.out.println(countDistinctPairs(new int[]{1,1}, 2));					// 1
		System.out.println(countDistinctPairs(new int[]{1,5,1,5}, 6));				// 1
		System.out.println(countDistinctPairs(new int[]{1,5,3,3,3}, 6));			// 2

	}

    /*
       Solution Approach: To first sort the array then use two pointer techinque
    */
	public static int countDistinctPairs(int[] arr,int sum)
	{
	    Arrays.sort(arr);
	    
	    int l=0;
	    int r=arr.length-1;
	    int count=0;
	    while(l<=r)
	    {
	        if(arr[l]+arr[r]>sum)
	        r--;
	        else if(arr[l]+arr[r]<sum)
	        l++;
	        else
	        {
	            //int a=arr[l]; int x=l;
	            while(l<r && arr[l]==arr[l+1])
	            l++;
	            
	            //int b=arr[r]; int y=r;
	            while(r>l && arr[r]==arr[r-1])
	            r--;
	            
	            count++;
	            l++;
	            r--;
	        }
	    }
	    return count;
	}
	/*
	*Better Solution Using Hashing
	*Assumption -Consider Input array contains duplicate values
	*/
	
	public static int countDistinctPairsUsingHashing(int[] arr,int sum)
	{
		if(arr.length<2)
			return 0;
		HashMap<Integer,Integer> map=new HashMap<>();
		int count=0;
		int occurance=1;
		
		for(int i=0;i<arr.length;i++)
		{
			int value=sum-arr[i];
			if(map.containsKey(value) && map.get(value)>0)
			{
			    count+=1;
			    map.put(value,0);
			    map.put(arr[i],0);
			}
			if(map.get(arr[i])==null && map.get(value)==null )
			map.put(arr[i],1);
			
		}
		return count;
		
	}
	

}
