/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		/*
		        Given a non negative integer number num. 
		        For every numbers i in the range 0 ≤ i ≤ num calculate the 
		        number of 1's in their binary representation and 
		        return them as an array.

                Example 1:
                
                Input: 2
                Output: [0,1,1]
                Example 2:
                
                Input: 5
                Output: [0,1,1,2,1,2]
		            
		*/
		
		
		int n=20;
		
		for(int a:countSetBits(n))
		System.out.print(a+" ");
		System.out.println();
		System.out.println("++++++++++Method #2 DP +++++++++++++++++");
		
		for(int a1:countBits(n))
		System.out.print(a1+" ");
		System.out.println();
	    System.out.println(countTotalSetBits(n));
	}
	// Using Kernighan's algo
 public static int[] countSetBits(int num) {
        int[] res=new int[num+1];
        int j=0;
        int x=0;
        for(int i=0;i<=num && j<res.length;i++,j++)
        {
           int temp=x;
            while(temp!=0)
            {
            
                int rsbm=temp & -temp;
              
                temp=temp-rsbm;
               
                res[i]++;
               
            }
            x++;
             
        }
        return res;
        
    }
    
    //Using DP TC:O(n) SC:O(n)
    public static int[] countBits(int num)
    {
        int[] res=new int[num+1];
        res[0]=0;
        for(int i=1;i<res.length;i++)
        {
            res[i]=res[i/2]+i%2;
        }
        
        return res;
    }
    
    //Count Set Bits in First N natural numbers | Total Set Bits from 1 to N | Bit Manipulation
    
    public static int countTotalSetBits(int num)
    {
        if(num==0)
        return 0;
        int x=powerOf2(num)-1;  //Largest power of 2 less than or equal to num
        
        int bTill2x=x*(1<<(x-1));
        int msb2xTon=num-(1<<x)+1;
        int rem=num-(1<<x);
        int ans=bTill2x+msb2xTon+countTotalSetBits(rem);
        return ans;
        
        
    }
    
    public static int powerOf2(int num)
    {
        int x=0;
        
        while((1<<x)<=num)
        {
            x++;
            
        }
        
        return x;
    }
}
