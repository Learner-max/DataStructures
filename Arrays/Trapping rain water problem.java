/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		/* 
		    Trapping Rain Water
		    Solution#1: TC:O(n) SC:O(n)
		    Using Dynamic programming
		
		*/
	}
	//Using Dynamic programming
	public int trap(int[] height) {
        
        
        int vol=0;
        int n=height.length;
        if(n==0)
            return 0;
        int[] LMax=new int[n];
        
        int[] RMax=new int[n];
        
        LMax[0]=height[0];
        RMax[n-1]=height[n-1];
        
        for(int i=1;i<n;i++)
        {
            LMax[i]=Math.max(LMax[i-1],height[i]);
        }
        
        for(int i=n-2;i>=0;i--)
        {
            RMax[i]=Math.max(RMax[i+1],height[i]);
        }
        
        for(int i=0;i<n;i++)
        {
            vol=vol+Math.min(LMax[i],RMax[i])-height[i];
        }
        
        return vol;
        
    }
    
    //Using two pointers approach
    public static int trapWater(int[] arr)
    {
        int n=arr.length;
        int left=0;
        int right=n-1;
        int vol=0;
        int lmax=0;
        int rmax=0;
        
        while(left<right)
        {
            if(arr[left]<arr[right])
            {
                if(arr[left]>=lmax)
                lmax=arr[left];
                else
                vol=vol+(lmax-arr[left]);
                left++;
            }
            else
            {
                if(arr[right]>=rmax)
                rmax=arr[right];
                else
                vol=vol+(rmax-arr[right]);
                right--;
            }
        }
        
        System.out.println(vol);
    }
}
