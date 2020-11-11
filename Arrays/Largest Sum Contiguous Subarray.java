/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main(String[] args){
	/*
	    Maximum sum subarray
	    
     */
     
    int arr1[] = {-2,-3,4,-1,-2,1,5,-3} ;
   
    //largestSumSubArrayMethod_1(arr1);
    largestSumSubArrayMethod_2(arr1);
}

/*
        Here idea is if arr[i-1]>0 tehn only update arr[i]=arr[i]+arr[i-1] , then 
        determine if cur_diff=Math.max(curr_diff,arr[i]);
*/
    public static void largestSumSubArrayMethod_1(int[] arr) {
	        
	      
	        int j=1;
	      
	         int curr_diff=arr[0];
	         
	         for(int i=1;i<arr.length;i++)
	         {
	             if(arr[i-1]>0)
	             {
	                 arr[i]=arr[i]+arr[i-1];
	             }
	             curr_diff=Math.max(curr_diff,arr[i]);
	         }
	        
	       
	         System.out.println(curr_diff);
	        
	    }
/*
    Here idea is if curr_maxsum+arr[i]>0 then update it to curr_maxsum+=arr[i]
    else reset the curr_maxsum value  then max_sumSubarry=Math.max(curr_maxsum, max_sumSubarry)
*/
    public static void largestSumSubArrayMethod_2(int[] arr) {
        
     	int curr_maxsum=0;
        int max_sumSubarray=0;
        int start=0;
        int end=0;
        int s=0;
        for(int i=0;i<arr.length;i++)
        {
            if(curr_maxsum+arr[i]<0)
            {
                curr_maxsum=0;
                s=i+1;
            }
            else
              curr_maxsum+=arr[i];
             
            if(curr_maxsum>max_sumSubarray)
            {
            max_sumSubarray=curr_maxsum;
            start=s;
            end=i;
            }
        }
        
        System.out.println(max_sumSubarray+" found at indexes: "+ start+" " +end);
        
        
        
    }

}
