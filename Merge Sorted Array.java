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
		
		int[] nums1={1,2,3,0,0,0};
		int m=3;
		int[] nums2={2,5,6};
		int n=3;
		
		merge(nums1,m,nums2,n);
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int l=m-1;
        int r=n-1;
        int index=nums1.length-1;
        
        while(index>=0)
        {
            if(l<0)
            {
                nums1[index]=nums2[r];
                r--;
            }
            else if(r<0)
            {
                nums1[index]=nums1[l];
                l--;
            }
            else
            {
                if(nums1[l]>nums2[r])
                {
                    nums1[index]=nums1[l];
                    l--;
                }
                else
                {
                    nums1[index]=nums2[r];
                r--;
                }
            }
            
            index--;
        }
        for(int a: nums1)
            System.out.print(a+" ");
    }
}

