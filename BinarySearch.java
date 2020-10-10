package com.dataStructure.learning;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={2,5,8,12,16,23,38,50,72,91};
		int l=0;
		int h=arr.length-1;
		int target=23;
		int index=binarySearch(arr,l,h,target);
		int indx=binarySearchRecursive(arr,l,h,target);
		System.out.println(indx);

	}

	//Binary Search Iterative
	public static int binarySearch(int[] arr,int l,int h,int target)
	{
		int m=0;
		while(l<=h)
		{
			m=l+((h-l)/2);
			
			if(arr[m] ==target)
				return m;
			if(arr[m]>target)
				h=m-1;
			else
				l=m+1;
			
			
		}
		return -1;
	}
	//Binary Search Recursive
	public static int binarySearchRecursive(int[] arr, int l, int h,int target)
	{
		int m=l+((h-l)/2);
		if(l>h)
			return -1;     
		if(arr[m]== target)
			return m;
		if(arr[m]>target)
			return binarySearchRecursive(arr,l,m-1,target);
		if(arr[m]<target)
			return binarySearchRecursive(arr,m+1,h,target);
		return -1;
	}
	
	//Time Complexity:O(logn)
}
