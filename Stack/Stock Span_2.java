/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        int S[] = new int[n];
 
        // Fill the span values in array S[]
        //calculateSpan(price, n, S);
        efficientEvalSpan(price,n);
	}
	public static void calculateSpan(int[] arr,int n, int[] S)
	{
	    Stack<Integer> st=new Stack<>();
	    st.push(0);
	    S[0]=1;
	    
	    for(int i=1;i<n;i++)
	    {
	        if(arr[st.peek()]>arr[i])
	        {
	            S[i]=i-st.peek();
	        }else
	        {
	            while(!st.isEmpty() && arr[st.peek()]<=arr[i])
	            {
	                st.pop();
	            }
	            if(!st.isEmpty())
	            S[i]=i-st.peek();
	            else
	            S[i]=i+1;
	        }
	        st.push(i);
	    }
	    
	    for(int a:S)
	    {
	        System.out.print(a+" ");
	    }
	}
	
	
	//Calculate Span in TC :O(n) and SC:O(1) ---1D DP problem
	public static void efficientEvalSpan(int[] arr, int n)
	{
	    int[] ans=new int[n];
	    ans[0]=1;
	    
	    for(int i=1;i<n;i++)
	    {
	        int counter=1;
	        while((i-counter)>=0 && arr[i]>=arr[i-counter])
	        {
	            counter+=ans[i-counter];
	        }
	        ans[i]=counter;
	    }
	    
	    for(int a:ans)
	    {
	        System.out.print(a+" ");
	    }
	}
	
}
