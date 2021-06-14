/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main(String[] args)
	{
	    int mat[][] = { { 10, 20, 30, 40 },
                   { 15, 25, 35, 45 },
                   { 27, 29, 37, 48 },
                   { 32, 33, 39, 50 } };
 
    searchElement(mat, 4,4, 29);
	}
	
	public static void searchElement(int[][] arr,int n, int m,int target)
	{
	    int i=0;
	    int j=m-1;
	    
	    while(i>=0 && i<n && j>=0 && j<m)
	    {
	        
	        if(arr[i][j]==target)
	        {
	            System.out.println(i+" "+j);
	            return;
	        }
	        else if(arr[i][j]>target)
	        j--;
	        else
	        i++;
	    }
	    System.out.println("Not Found");
	}
}
