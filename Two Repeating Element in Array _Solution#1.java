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
		
		int[] nums={1,4,5,6,3,2,5,2};
		
		repeatingElements(nums);
	}
	
	public static void repeatingElements(int[] arr) {
        
        HashMap<Integer,Integer> m = new HashMap<>();
        
        for(int i=0;i<arr.length;i++)
        {
            if(m.containsKey(arr[i]))
            {
                m.put(arr[i],m.get(arr[i])+1);
            }
            else{
                m.put(arr[i],1);
            }
        }
        
        for(int a:m.keySet())
        {
            int count=m.get(a);
            if(count==2)
            {
            System.out.println(a);
            }
        }
    }
}

