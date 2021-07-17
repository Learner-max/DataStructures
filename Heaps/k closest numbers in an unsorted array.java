/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class Pair
    {
        public Integer value;
        public Integer diff;
        Pair(int value,int diff)
        {
            this.value=value;
            this.diff=diff;
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
        int arr[] = {10, 2, 14, 4, 7, 6 };
        int x = 5, k = 3;
        int n = arr.length;
     
        printKclosest(arr, n, x, k);
	}
	
	public static void printKclosest(int[] arr, int n, int x, int k)
	{
	    //Create MaxHeap
	    PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>()
	    {
	            public int compare(Pair p1,Pair p2)
	            {
	               return  p2.diff.compareTo(p1.diff);
	            }
	    }    
	    );
	    
	    for(int i=0;i<k;i++) //O(k)
	    {
	        pq.add(new Pair(arr[i],Math.abs(arr[i]-x)));
	    }
	    
	    for(int i=k;i<n;i++)//O((n-k)logk);
	    {
	        int df=Math.abs(arr[i]-x);
	        
	        if(pq.peek().diff>df)
	        {
	            pq.remove();
	            pq.add(new Pair(arr[i],df));
	        }
	    }
	    
	    while(pq.size()>0)
	    {
	        System.out.println(pq.peek().value);
	        pq.remove();
	    }
	}
	
}	
