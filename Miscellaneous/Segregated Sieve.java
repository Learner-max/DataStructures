/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static List<Integer> prime=new ArrayList<>();
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int low=110;
		
		int high=130;
		
		segmentedSieve(low,high);
	}
	
	public static void segmentedSieve(int low, int high){
	    simpleSieve(high);
	    boolean[] segprimes=new boolean[high-low+1];
	    int r=high-low+1;
	    Arrays.fill(segprimes,true);
	    
	    for(int p:prime)
	    {
	        int L=low/p;
	        if(L<=1)
	        {
	            L=p*p;
	            
	        }else if(low%p!=0)
	        {
	            L=(L*p)+p;
	        }else {
	            L=L*p;
	        }
	        
	        for(int j=L;j<high;j+=p)
	        {
	            segprimes[j-low]=false;
	        }
	    }
	    
	    /*for(int i=0;i<r;i++)
	    {
	        if(segprimes[i])
	        {
	            prime.add(i);
	        }
	    }*/
	    
	    for(int i=low;i<high;i++)
	    {
	       if(segprimes[i-low]){
	           System.out.print(i+" ");
	       }
	    }
	}
	
	public static void simpleSieve(int high)
	{
	    int h = (int)Math.sqrt(high);
	    boolean[] primes =new boolean[h+1];
	    Arrays.fill(primes,true);
	    
	    primes[0]=false;
	    primes[1]=false;
	    
	    for(int i=2;i<=h;i++){
	        
	        if(primes[i]){
	        
    	        for(int j=i*i;j<=h;j+=i)
    	        {
    	            primes[j]=false;
    	        }
	        }
	    }
	    
	    for(int i=2;i<=h;i++)
	    {
	        if(primes[i]){
	            prime.add(i);
	        }
	    }
	    System.out.println(prime);
	    
	}
}
