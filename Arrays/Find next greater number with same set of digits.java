/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Next greater number with same set of digits
		/* 
		    Input:  n = "218765"
            Output: "251678"
            
            Input:  n = "1234"
            Output: "1243"
            
            Input: n = "4321"
            Output: "Not Possible"
            
            Input: n = "534976"
            Output: "536479"
*/
		int s=534976;
		nextGreaterElement(s);
	}
	
	public static void nextGreaterElement(int n1) {
        
        if(n1<10)
        {
           System.out.println("Not possibele");
           return;
        }
        
        String s=Integer.toString(n1);
        int[] arr=new int[s.length()];
        int i=0;
        for(int j=0;j<arr.length;j++)
            arr[j]=s.charAt(j)-'0';
        
        int n=arr.length;
        
        for(i=n-1;i>=0;i--)
        {
            if(i>0 &&arr[i]>arr[i-1])
                break;
            if(i==0)
            {
                System.out.println("Not possibele");
                return;
            }
        }
        int pivot=arr[i-1];
        int smallest=i;
        
        for(int j=i+1;j<n;j++)
        {
            if(arr[j]>pivot && arr[j]<arr[smallest])
                smallest=j;
        }
        
        //swap element at smallest index and with pivot element
        int temp=arr[smallest];
        arr[smallest]=arr[i-1];
        arr[i-1]=temp;
        
        //reverse array after index i
        int l=i;
        int r=n-1;
        while(l<r)
        {
            if(arr[l]>arr[r]){
            int temp1=arr[l];
            arr[l]=arr[r];
            arr[r]=temp1;
            l++;r--;
        }
            else
            {
                l++;
            }
        }
       // Arrays.sort(arr, i, n); 
        String res="";
        for(int x:arr)
        {
            res+=x;
        }
         try
            {
               System.out.println(Integer.parseInt(res.toString())); 
            }
            catch (Exception e)
            {
                 System.out.println("Not possible");
            }
    }

}
