/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
lass Solution {
    public int findMin(int[] nums) {
        
        int n=nums.length;
        int l=0;
        int h=n-1;
        
        if(n==0)
            return -1;
        if(n==1)
            return nums[0];
        
        int minEle=0;
        if(nums[l]>nums[h]) {
        minEle=binarySearch(nums,l,h);
        }
        return nums[minEle];

    }
    
    public static int binarySearch(int[] arr, int l, int h)
	    {
	    	int n=arr.length;
	        
	        while(l<=h)
	        {
	            int mid=l+(h-l)/2;
	            
	            if(arr[mid]>arr[mid+1])
                    return mid+1;
                if(arr[mid]<arr[mid-1])
                    return mid;
                if(arr[mid]>arr[0])
                    l=mid+1;
                else
                    h=mid-1;
	        }
	        
	        return -1;
	    }
	
	// To Handle Duplicates in Array
	public int binarySearch(int[] nums,int l,int h)
    {
        int n=nums.length;
        while(l<=h)
        {
            
            if(nums[l]<nums[h])
                return nums[l];
            
            if(nums[l]==nums[h] && l==h)
                return nums[l];
          
            int mid=l+(h-l)/2;
            
            int next=(mid+1)%n;
            
            int prev=(mid+n-1)%n;
            
            if(nums[mid]>nums[next])
                return nums[mid+1];
            
            if(nums[mid]<nums[prev])
                return nums[mid];
            
            if(nums[0]<nums[mid])
                 l=mid+1;
            else if(nums[h]>nums[mid])
               h=mid-1;
            else
                l++;
        }
            
        
        
        return -1;
    }
}
