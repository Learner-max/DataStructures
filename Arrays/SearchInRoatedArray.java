/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
        
		//System.out.println(searchInRotatedArray(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3},3));
		//System.out.println(searchInRotatedArray(new int[]{3, 4, 5, 1, 2},1));
		//System.out.println(searchInRotatedArray(new int[]{ 4, 5, 6, 7, 8, 9, 1, 2, 3 },6));
		System.out.println(searchSingleTraversal(new int[]{ 4, 5, 6, 7, 8, 9, 1, 2, 3 },0,8,6));
		System.out.println(searchSingleTraversal(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3},0,8,3));
		System.out.println(searchSingleTraversal(new int[]{3, 4, 5, 1, 2},0,4,1));
	
	}
	
   //Search In a Rotated Array	
   public static int searchInRotatedArray(int arr[], int target)
	{
	    int n=arr.length;
	    int l=0;
	    int r=n-1;
	    int pivot=binarySearch(arr,l,r,n,target,"PIVOT");
	    //Two subarrays are there 0->pivot-1 and pivot->n-1
	    if(arr[0] >target)
	    {
	        l=pivot+1;
	        return binarySearch(arr,l,r,n,target,"Element");
	    }else
	    {
	        return binarySearch(arr,l,pivot-1,n,target,"Element");
	    }
	    
	    
	}
	
	public static int binarySearch(int[] arr, int l,int h,int n,int target, String type)
	{
	    while(l<=h)
	    {
	        int mid=l+(h-l)/2;
	        if(type.equals("PIVOT")){
	        if((mid>0 || mid>n-1) && arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1])
	        return mid;
	        else if(arr[mid]<arr[mid+1] && arr[mid]>arr[mid-1])
	        l=mid+1;
	        else
	        	h=mid-1;
	        }else
	        {
	        if(arr[mid]==target)
	        return mid;
	        else if(arr[mid]<target)
	        l=mid+1;
	        else
	        h=mid-1; 
	        }
	    }
	    return -1;
	}
	
	//Using Recursion and In Single Traversal
	public static int searchSingleTraversal(int[] arr, int l,int h, int target)
	{
	    if(l>h)
	    return -1;
	    
	    int mid=l+(h-l)/2;
	    
	    if(arr[mid]==target)
	    return mid;
	    
	    if(arr[l]<=arr[mid])
	    {
	        if(target>=arr[l] && target<=arr[mid])
	        return searchSingleTraversal(arr,l,mid-1,target);
	        else
	        return searchSingleTraversal(arr,mid+1,h,target);
	    }
	    
        if(target>=arr[mid+1] && target<=arr[h])
        return searchSingleTraversal(arr,mid+1,h,target);
      
        return searchSingleTraversal(arr,l,mid-1,target);
	    
	}
	
	//Using Iterative Approach and Single Array Traversal
	public  int binarySearch(int[] arr, int target)
	{
        int l=0;
        int h=arr.length-1;
        int n=arr.length;
	    while(l<=h)
	    {
	        int mid=l+(h-l)/2;
	        
            if(arr[mid]==target)
                return mid;
            else if((target>=arr[l] && target<arr[mid]) ||
                   (arr[l]>arr[mid] &&(target>=arr[l] || target<arr[mid])))
                h=mid-1;
            else
                l=mid+1;
	    }
	    return -1;
	}  
	
	//Above methods do not handle duplicate elements in array
	
	public  int binarySearchWithDuplicates(int[] arr, int target)
	{
        int l=0;
        int h=arr.length-1;
        int n=arr.length;
	    while(l<=h)
	    { 
	        
            while(l<h && arr[l]==arr[l+1])
                l++;
            
            while(h>l && arr[h]==arr[h-1])
                h--;
            
            int mid=l+(h-l)/2;
            
            if(arr[mid]==target)
                return mid;
            else if((target>=arr[l] && target<arr[mid]) ||
                   (arr[l]>arr[mid] &&(target>=arr[l] || target<arr[mid])))
                h=mid-1;
            else
                l=mid+1;
	    }
	    return -1;
	}  
	
	//More Simpler Implementation 
	
	public int search(int[] nums, int target) {
        
        int l=0;
        int h=nums.length-1;
        int n=nums.length;
        int pivot = findPivotIndex(nums,l,h,n);
        //System.out.println(pivot);
        if(target==nums[pivot])
        {
            return pivot;
        
         }else if(nums[pivot]<=target && target<=nums[n-1]){
            
           l=pivot+1;
            
        }else{
            h=pivot-1;
        }
    
        return binarySearch(nums, l, h, target);
        
    }
    
    
    public int findPivotIndex(int[] nums,int l, int h, int n)
    {
        if(nums[0]<=nums[n-1])
            return 0;
        while(l<h){
            int mid=l+(h-l)/2;
            if(nums[mid]>=nums[0]){
                l=mid+1;
            }else
                h=mid;
        }
        
        return l;
    }
    
    public int binarySearch(int[] nums, int l, int h, int target){
        
        while(l<=h){
            int mid = l+(h-l)/2;
            if(target==nums[mid]){
                return mid;
            }
             else if(target>nums[mid]){
                 l=mid+1;   
             }else{
                 h=mid-1;
             }   
           }
        
        return -1;
    }
	    
}
