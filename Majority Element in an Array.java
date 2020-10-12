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
		
		int[] arr={ 1, 1, 2, 1, 3, 5, 1};
		int candidate=getMajorityCandidate(arr);
		System.out.println(getMajorityElement(arr,candidate)?"Majority Element: "+candidate:"No Majority Element");
		
	}
	
	public static int getMajorityCandidate(int[] arr)
	{
	      int Votee=arr[0];
	      int Vote=1;
	      
	      for(int i=1;i<arr.length;i++)
	      {
	            if(arr[i]==Votee)
	            Vote++;
	            else
	            Vote--;
	            if(Vote==0)
	            {
	                  Votee=arr[i];
	                  Vote=1;
	            }
	            
	      }
	      return Votee;
	}
	
	public static boolean getMajorityElement(int[] arr, int majorityElement)
	{
	      int count=0;
	      for(int i=0;i<arr.length;i++)
	      {
	            if(arr[i]==majorityElement)
	            count++;
	      }
	      
	      if(count>arr.length/2)
	      return true;
	      else
	      return false;
	}
}
