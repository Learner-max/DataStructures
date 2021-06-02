package com.dataStructure.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class CountPairsWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr={10, 12, 10, 15, -1, 7, 6, 
                5, 4, 2, 1, 1, 1};
			//{1, 5, 7, -1};
			//{1, 1, 1, 1};
			//{1, 5, 7, -1, 5};
		
		int sum=11;
				//6;
				//2;
				//6;
		System.out.println(getPairsCountBruteForce(arr,sum));

	}

	//Brute Force
	public static int getPairsCountBruteForce(int[] arr,int sum)
	{
		
		int count=0;
		
		if(arr.length<2)
			return 0;
		
		for(int i=0;i<arr.length;i++)
		{
			int temp=sum-arr[i];
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]+arr[j]==sum)
					count++;
			}
		}
		return count;
	}
	
	/*

	*Better Solution Using Hashing
	*Assumption -Consider Input array contains duplicate values
	*
	* If array dosen't have duplicate values then we can use method getPairsCount()
	*/
	
	public static int getPairsCountHashing(int[] arr,int sum)
	{
		if(arr.length<2)
			return 0;
		HashMap<Integer,Integer> map=new HashMap<>();
		int count=0;
		int occurance=1;
		
		for(int i=0;i<arr.length;i++)
		{
			int value=sum-arr[i];
			if(map.get(value)!=null && value!=arr[i])
			{
				//occurance=map.get(value);
				count=count+map.get(value);
			}
			if(map.get(arr[i])!=null)
			{
				occurance=map.get(arr[i])+1;
				map.put(arr[i], occurance);
			}
			else
			map.put(arr[i], 1);
			
		}
		return count;
		
	}
	
	/*
	 * * If array dosen't have duplicate values then we can use method getPairsCount()
	*/
	public static int getPairsCount(int[] arr,int sum)
	{
		Set<Integer> s=new LinkedHashSet<>();
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			
			 int temp=sum-arr[i];
			 if(s.contains(temp))
			 {
				 count++;
				 System.out.println("Pairs are "+ arr[i]+" "+temp);
			 }
			 s.add(arr[i]);
			 
			            
		}
		return count;
	}
}
