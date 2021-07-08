/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class Pair{
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
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        //System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
        System.out.println(getMaxAreaSingleRun(hist, hist.length));
	}
	public static int getMaxArea(int[] arr, int n)
	{
	    int[] NSL=new int[n];
	    int[] NSR= new int[n];
	    
	    NSL=getNSL(arr, NSL,n);
	    System.out.println();
	    NSR=getNSR(arr,NSR,n);
	    System.out.println();
	    int maxArea=0;
	    for(int i=0;i<n;i++)
	    {
	        int width=(NSR[i]-NSL[i])-1;
	        int area=width*arr[i];
	        if(maxArea<area)
	        {
	            maxArea=area;
	        }
	    }
	    
	    return maxArea;
	}
	
	public static int[] getNSL(int[] arr,int[] NSL,int n)
	{
	    Stack<Pair> s=new Stack<>();
	    
	    //NSL-> Next Smaller Element to left
	    for(int i=0;i<n;i++)
	    {
	        if(s.isEmpty())
	        {
	            NSL[i]=-1;
	        }else if(s.peek().ele<arr[i])
	        {
	            NSL[i]=s.peek().index;
	        }else
	        {
	            while(!s.isEmpty() && s.peek().ele>=arr[i])
	            {
	                s.pop();
	            }
	            if(!s.isEmpty())
	            NSL[i]=s.peek().index;
	            else
	            NSL[i]=-1;
	        }
	        s.push(new Pair(arr[i],i));
	    }
	    for(int x:NSL)
	   System.out.print(x+" ");
	    return NSL;
	}
	
	public static int[] getNSR(int[] arr,int[] NSR, int n)
	{
	    //int psudeoIndex=n;
	    Stack<Pair> s=new Stack<>();
	    
	    //NSL-> Next Smaller Element to Right
	    for(int i=n-1;i>=0;i--)
	    {
	        if(s.isEmpty())
	        {
	            NSR[i]=n;
	        }else if(s.peek().ele<arr[i])
	        {
	            NSR[i]=s.peek().index;
	        }else
	        {
	            while(!s.isEmpty() && s.peek().ele>=arr[i])
	            {
	                s.pop();
	            }
	            if(!s.isEmpty())
	            NSR[i]=s.peek().index;
	            else
	            NSR[i]=n;
	        }
	        s.push(new Pair(arr[i],i));
	    }
	    /*int l=0;
	    int h=n-1;
	    while(l<=h)
	    {
	        int temp=NSR[l];
	        NSR[l]=NSR[h];
	        NSR[h]=temp;
	        l++;
	        h--;
	    }*/
	   for(int x:NSR)
	   System.out.print(x+" ");
	    return NSR;
	}
	
	// Efficient approach 
	public static int getMaxAreaSingleRun(int[] arr,int n)
	{
	    Stack<Integer> s=new Stack<>();
	    int width=0;
	    int maxWidth=0;
	    for(int i=0;i<n;)
	    {
	        if(s.isEmpty() || arr[s.peek()]<=arr[i])
	        {
	            s.push(i++);
	        }else
	        {
	            while(!s.isEmpty() && arr[s.peek()]>arr[i])
	            {
	                int top=s.pop();
	                width=arr[top]*(s.isEmpty()?i:i-s.peek()-1);
	                if(maxWidth<width)
	                {
	                    maxWidth=width;
	                }
	            }
	        }
	    }
	    return maxWidth;
	}
}
