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
	
 /*                   New Code --Refer This
 class Codechef
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	getMajorityElementsLinearSpace(new int[]{3,1,2,3,1,2,1,3});
	System.out.println();
	getMajorityElementsLinearSpace(new int[]{5, 3, 5});
	System.out.println();
	getMajorityElementsLinearSpace(new int[]{7, 7, 7, 3, 4, 4, 4, 5});
        
	}

   
       //Solution Approach: Sort the Array
    
    
    public static void getMajorityElements(int[] arr)
    {
        Arrays.sort(arr);
        int n=arr.length;
        int third=n/3;
        int majority=arr[0];
        int count=1;
        
        
        for(int i=0;i<n-1;i++)
        {
            if(count>third){
                System.out.print(majority+" ");
            }
            
            if(arr[i]==arr[i+1]){
                count++;
                majority=arr[i];
            }
            else
            {
                majority=arr[i+1];
                count=1;
            }
        }
        if(count>third){
                System.out.print(majority+" ");
            }
    }
    
    
     Solution Approach Based on Moore's Vooting Algorithm
     Idea: In an array of size n there cannot be more than 2 elements
     having count>n/3
    
    public static int[] getMajorityCandidates(int[] arr)
    {
        int cand1=arr[0];
        int cand2=arr[1];
        int cand1Count=1;
        int cand2Count=1;
        int n=arr.length;
        int third=n/3;
        
        for(int i=2;i<arr.length;i++)
        {
            if(cand1==arr[i])
            cand1Count++;
            else if(cand2==arr[i])
            cand2Count++;
            else if(cand1Count==0)
            {
                cand1=arr[i+1];
                cand1Count=1;
            }
            else if(cand2Count==0)
            {
                cand2=arr[i+1];
                cand2Count=1;
            }
            else
            {
                cand1Count--;
                cand2Count--;
            }
        }
        int[] res=new int[2];
        res[0]=cand1;
        res[1]=cand2;
        //System.out.println(cand1+" "+cand2);
        return res;
    }
    
    public static void getMajorityElementsLinearSpace(int[] arr)
    {
        int[] candidates=getMajorityCandidates(arr);
        int third=arr.length/3;
        int cand1Count=0;
        int cand2Count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(candidates[0]==arr[i])
            cand1Count++;
            if(candidates[1]==arr[i])
            cand2Count++;
        }
        if(cand1Count>third && cand2Count>third)
        System.out.println(candidates[0]+" "+candidates[1]);
        else if(cand1Count>third)
        System.out.println(candidates[0]);
        else if(cand2Count>third)
        System.out.println(candidates[1]);
        else
        System.out.println("No Majority Elements");
    }
}
*/
}
