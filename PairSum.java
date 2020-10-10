package com.dataStructure.learning;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class PairSum {

	// Given an array A[] and a number x, check for all  pairs in A[] with sum as x
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr={1, 4, 45, 6, 10, -8};
        //int[] arr={6, 4, 12, 10, 22, 54, 32, 42, 21, 11};
        int[] arr={1,4,2,4,2,3};
        int sum=4;
		
		//int sum=64;
		
        pairSum(arr,sum);
        System.out.println(pairSumTwoPointers(arr,sum));
	}

	//Solution Approach: Hashing
	public static void pairSum(int[] arr,int sum)
	{
		Set<Integer> s=new LinkedHashSet<>();
		for(int i=0;i<arr.length;i++)
		{
			 int temp=sum-arr[i];
			 if(s.contains(temp))
				 System.out.println("Pairs are "+ arr[i]+" "+temp);
			 s.add(arr[i]);
			            
		}
	}
	
	//Solution Approach : Two Pointers approach. If Array is Unsorted , first sort the array
	public static boolean pairSumTwoPointers(int[] arr, int target_sum)
	{
		Arrays.sort(arr);
		int L=0;
		int R=arr.length-1;
		
		while(L<=R)
		{
			if(arr[L]+arr[R]==target_sum)
				return true;
			else if(arr[L]+arr[R]>target_sum)
				R=R-1;
			else
				L=L-1;
		}
		return false;
	}
	
}
