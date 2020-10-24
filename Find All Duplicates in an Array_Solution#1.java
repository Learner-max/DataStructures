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
}

