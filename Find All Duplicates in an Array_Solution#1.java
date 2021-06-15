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
		
		int[] nums={3,3,3};
		//{3,3,3};
		//{5, 3, 1, 3, 5, 5};
		
		repeatingElements(nums);
	}
	
	public static void repeatingElements(int[] nums) {
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            int index=Math.abs(nums[i])-1;
            
            if(nums[index]<0)
            {
                s.add(Math.abs(nums[i]));
              //  System.out.print(Math.abs(nums[i])+" ");
            }
            
            else
            {
                nums[index]=-nums[index];
            }
        }
       
       System.out.print(s);
    
       
    }
	//Refer This approach
	 public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        
        if(n==0)
            return res;
        if(n==1)
        {
            //res.add(nums[0]);
            return res;
        }
         for(int i=0;i<nums.length;i++)
        {
             nums[i]=nums[i]-1;
         }
        for(int i=0;i<nums.length;i++)
        {
            nums[nums[i]%n]=nums[nums[i]%n]+n;
        }
        //for(int a:nums)
           // System.out.print(a+" ");
        System.out.println();
        for(int i=0;i<n;i++)
        {
            if(nums[i]/n==2)
                res.add(i+1);
        }
        
        return res;
    }
}

