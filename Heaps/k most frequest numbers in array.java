/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int n = arr.length;
        int k = 4   ;
         
        // Function call
        print_N_mostFrequentNumber(arr, n, k);
	}
	
	public static void print_N_mostFrequentNumber(int[] arr,int n,int k)
	{
	    //create a hashmap
	    LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
	    
	    for(int i=0;i<n;i++)
	    {
	        if(map.containsKey(arr[i]))
	        {
	            map.put(arr[i],map.get(arr[i])+1);
	        }else
	        {
	            map.put(arr[i],1);
	        }
	    }
	    System.out.println(map);
	    PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(new Comparator<Map.Entry<Integer,Integer>>()
	    {
	       public int compare(Map.Entry<Integer,Integer> e1,Map.Entry<Integer,Integer> e2)
	       {
	           return e1.getValue().compareTo(e2.getValue());
	       }
	    });
	    
	    int t=1;
	   /* for(Map.Entry e:map.entrySet())
	    {
            if(t>k)
            break;
	        pq.add(e);
	        t++;
	    } */  
	    //Create MinHeap
	    for(Map.Entry<Integer,Integer> e:map.entrySet())
	    {
	        if(t>k){
	        if(pq.peek().getValue()==e.getValue())
	        {
	            if(pq.peek().getKey()<e.getKey())
	            {
	                pq.remove();
	                pq.add(e);
	            }
	        }else if(pq.peek().getValue()<e.getValue())
	        {
	            pq.remove();
	           pq.add(e);
	        }
	        }else
	        {
	            pq.add(e);
	        }
	        t++;
	    }
	    
	    while(pq.size()>0)
	    {
	        System.out.println(pq.peek().getKey());
	        pq.remove();
	    }
	}
}
