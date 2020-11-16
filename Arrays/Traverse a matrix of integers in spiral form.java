/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Traverse array in Spiral form in clock-wise direction
		
		/*
		
		Input:  1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
        Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
        Explanation: The output is matrix in spiral format. 
        
        Input:  1   2   3   4  5   6
                7   8   9  10  11  12
                13  14  15 16  17  18
        Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
        Explanation :The output is matrix in spiral format.

*/
        int R = 3;
        int C = 6;
        int a[][] = { { 1, 2, 3, 4, 5, 6 },
                    { 7, 8, 9, 10, 11, 12 },
                    { 13, 14, 15, 16, 17, 18 } };
		printMatrixInSpiral(a,R,C);
	}
	
	public static void printMatrixInSpiral(int[][] a,int R,int C)
	{
	    int left=0;
	    int right=C-1;
	    int top=0;
	    int down=R-1;
	    int dir=0;
	    List<Integer> list=new ArrayList<>();
	    while(left<=right && top<=down)
	    {
	        if(dir==0)
	        {
	            for(int i=left;i<=right;i++)
	            {
	                list.add(a[top][i]);
	            }
	              top++;
	        }
	      
	        if(dir==1)
	        {
	            for(int i=top;i<=down;i++)
	            {
	                list.add(a[i][right]);
	            }
	            right--;
	        }
	        
	        if(dir==2)
	        {
	            for(int i=right;i>=left;i--)
	            {
	                list.add(a[down][i]);
	            }
	              down--;
	        }
	      
	        if(dir==3)
	        {
	            for(int i=down;i>=top;i--)
	            {
	                list.add(a[i][left]);
	            }
	            left++;
	        }
	        
	        dir=(dir+1)%4;
	    }
	    
	    System.out.println(list);
	}
	
}
