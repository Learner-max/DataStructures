/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main(String[] args){
	/*
	    Intersection of two unsorted arrays
	    TC:O(m+n) SC:O(m) orO(n)
     */
     
    int arr1[] = {7, 1, 5, 2, 3, 6} ;
    int arr2[] = {3, 8, 6, 20, 7} ;
     
     for(int a:intersection(arr1,arr2))
     {
         System.out.print(a+" ");
     }
}
   public static int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> s=new HashSet<>();
        HashSet<Integer> res=new HashSet<>();
        for(int a:nums1)
        {
            s.add(a);
        }
        
        for(int i=0;i<nums2.length;i++)
        {
            if(s.contains(nums2[i]))
                res.add(nums2[i]);
                         
        }
        
        int[] arr=new int[res.size()];
       
        int i=0;
        for(int a:res)
        {
            arr[i]=a;
            i++;
        }
        
        return arr;
    }
}
