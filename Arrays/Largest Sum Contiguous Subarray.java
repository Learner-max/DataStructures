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

   public int maxContiguousSubarraySum(int[] nums)
  {
    /*
      We default to say the the best maximum seen so far is the first
      element.

      We also default to say the the best max ending at the first element
      is...the first element.
    */
    int maxSoFar = nums[0];
    int maxEndingHere = nums[0];

    /*
      We will investigate the rest of the items in the array from index
      1 onward.
    */
    for (int i = 1; i < nums.Length; i++) 
    {
      /*
        We are inspecting the item at index i.

        We want to answer the question:
        "What is the Max Contiguous Subarray Sum we can achieve ending at index i?"

        We have 2 choices:

        maxEndingHere + nums[i] (extend the previous subarray best whatever it was)
          1.) Let the item we are sitting at contribute to this best max we achieved
          ending at index i - 1.

        nums[i] (start and end at this index)
          2.) Just take the item we are sitting at's value.

        The max of these 2 choices will be the best answer to the Max Contiguous
        Subarray Sum we can achieve for subarrays ending at index i.

        Example:

        index     0  1   2  3   4  5  6   7  8
        Input: [ -2, 1, -3, 4, -1, 2, 1, -5, 4 ]
                 -2, 1, -2, 4,  3, 5, 6,  1, 5    'maxEndingHere' at each point
        
        The best subarrays we would take if we took them:
          ending at index 0: [ -2 ]           (snippet from index 0 to index 0)
          ending at index 1: [ 1 ]            (snippet from index 1 to index 1) [we just took the item at index 1]
          ending at index 2: [ 1, -3 ]        (snippet from index 1 to index 2)
          ending at index 3: [ 4 ]            (snippet from index 3 to index 3) [we just took the item at index 3]
          ending at index 4: [ 4, -1 ]        (snippet from index 3 to index 4)
          ending at index 5: [ 4, -1, 2 ]     (snippet from index 3 to index 5)
          ending at index 6: [ 4, -1, 2, 1 ]  (snippet from index 3 to index 6)
          ending at index 7: [ 4, -1, 2, 1, -5 ]    (snippet from index 3 to index 7)
          ending at index 8: [ 4, -1, 2, 1, -5, 4 ] (snippet from index 3 to index 8)

        Notice how we are changing the end bound by 1 everytime.
      */
      maxEndingHere = Math.Max(maxEndingHere + nums[i], nums[i]);

      // Did we beat the 'maxSoFar' with the 'maxEndingHere'?
      maxSoFar = Math.Max(maxSoFar, maxEndingHere);  
    }

    return maxSoFar;
  }
}
