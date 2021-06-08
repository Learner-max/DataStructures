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
}
