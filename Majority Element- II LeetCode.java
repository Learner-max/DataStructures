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
		int[] nums= { 3,1,2,3,1,2,1,3};
		System.out.println("Majority Elements "+ majorityElement(nums));
	}
	
	 public static List<Integer> majorityElement(int[] nums) {
        
        
        Integer me1=null;
        Integer me2=null;
        int cme1=0;
        int cme2=0;
        
        List<Integer> arr=new ArrayList<>();
         if(nums.length==0)
            return null;
        if(nums.length==1)
        {
          
            arr.add(nums[0]);
            return  arr;
        } 
        
        for(int i=0;i<nums.length;i++)
        {
            if(me1==null || me1==nums[i])
            {
                me1=nums[i];
                cme1++;
            }
            else if(me2== null || me2==nums[i])
            {
                me2=nums[i];
                cme2++;
            }else if(cme1==0)
            {
                me1=nums[i];
                cme1=1;
                
            }else if(cme2==0)
            {
                me2=nums[i];
                cme2=1;
            }else
            {
                cme1--;
                cme2--;
            }
        }
        
        cme1=0;cme2=0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(me1!=null && nums[i]==me1)
                cme1++;
            if(me2!=null && nums[i]==me2)
                cme2++;
        }
        if(cme1>nums.length/3)
            arr.add(me1);
        if(cme2>nums.length/3)
            arr.add(me2);
        
        return arr;
        
    }
}
