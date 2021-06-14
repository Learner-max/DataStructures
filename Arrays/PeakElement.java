/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public int findPeakElement(int[] arr) {
        
        int n=arr.length;
        if(n==0 )
            return -1;
        if(n==1)
            return 0;
        
        int l=0;
        int h=n-1;
        
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            
            int next=(mid+1)%n;
            int prev=(mid+n-1)%n;
            
            if((mid==0 && arr[mid]>arr[next]) ||
               (mid==n-1 && arr[mid]>arr[prev]) ||
               (arr[mid]>arr[prev] && arr[mid]>arr[next]))
                return mid;
            else if(arr[mid]<arr[mid+1])
                l=mid+1;
            else
                h=mid-1;
        }
        return -1;
    }
}
