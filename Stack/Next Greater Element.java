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
    	int arr[] = { 11, 13, 21, 3 };
        int n = arr.length;
        printNGE(arr, n);
	}
	
	public static void printNGE(int[] arr,int n)
	{
	    ArrayList<Integer> list=new ArrayList<>();
	    
	    Stack<Integer> s=new Stack<>();
	    
	    for(int i=n-1;i>=0;i--)
	    {
	        if(s.size()==0)
	        {
	            list.add(-1);
	            
	        }else if(s.peek()>arr[i])
	        {
	            list.add(s.peek());
	        }else
	        {
	            while(!s.isEmpty() && s.peek()<=arr[i])
	            {
	                s.pop();
	            }
	            if(!s.isEmpty())
	            list.add(s.peek());
	            else
	            list.add(-1);
	            
	        }
	        s.push(arr[i]);
	    }
	    Collections.reverse(list);
	    System.out.println(list);
	}
}
