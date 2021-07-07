/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class Pair
    {
        int ele;
        int index;
        Pair(int ele, int index)
        {
            this.ele=ele;
            this.index=index;
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int price[] = {10,4,5,90,120,80};
        int n = price.length;
        //int S[] = new int[n];
        printStockSpan(price,n);
	}
	public static List<Integer> getNGEToLeft(int[] arr, int n)
	{
	    Stack<Pair> s=new Stack<>();
	    ArrayList<Integer> list=new ArrayList<>();
	    for(int i=0;i<n;i++)
	    {
	        if(s.size()==0)
	        {
	            list.add(-1);
	        }else if(s.peek().ele>arr[i])
	        {
	            list.add(s.peek().index);
	        }else
	        {
	            while(!s.isEmpty() && s.peek().ele<=arr[i])
	            {
	                s.pop();
	            }
	            if(!s.isEmpty())
	            list.add(s.peek().index);
	            else
	            list.add(-1);
	        }
	        s.push(new Pair(arr[i],i));
	    }
	    
	    return list;
	}
	public static void printStockSpan(int[] price, int n)
	{
	    List<Integer> list=getNGEToLeft(price,n);
	    Stack<Integer> s=new Stack<>();
	    ArrayList<Integer> spn=new ArrayList<>();
	    for(int i=0;i<n;i++)
	    {
	        spn.add(i-list.get(i));
	    }
	    System.out.println(spn);
	}
}
