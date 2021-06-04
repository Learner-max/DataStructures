/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Rotate Array by 90 degree in Anti-Clockwise direction
		
		 int mat[][] = { 
            { 1, 2, 3}, 
            { 4,5,6 }, 
            { 7,8,9 }
            
        }; 
  
    //    rotateMatrix(mat);
     //   displayMatrix(mat);
        rotateMatrixClockWise(mat);
        displayMatrix(mat);
	}
	
	public static void rotateMatrixAntiClockWise(int[][] matrix)
	{
	    int rows=matrix.length;
	    int columns=matrix[0].length;
	    // reverse array
	    for(int i=0;i<rows;i++)
	    {
	        for(int j=0, k=columns-1;j<k;j++,k--)
	        {
	            int temp=matrix[i][j];
	            matrix[i][j]=matrix[i][k];
	            matrix[i][k]=temp;
	        }
	    }
	    
	    //Transpose
	    for(int i=0;i<rows;i++)
	    {
	        for(int j=i;j<columns;j++)
	        {
	            int temp=matrix[i][j];
	            matrix[i][j]=matrix[j][i];
	            matrix[j][i]=temp;
	        }
	    }
	   
	}
	
	public static void rotateMatrixClockWise(int[][] matrix)
	{
	    int rows=matrix.length;
	    int columns=matrix[0].length;
	    
	    //Transpose
	    for(int i=0;i<rows;i++)
	    {
	        for(int j=i;j<columns;j++)
	        {
	            int temp=matrix[i][j];
	            matrix[i][j]=matrix[j][i];
	            matrix[j][i]=temp;
	        }
	    }
	    
	     
	    // reverse array
	    for(int i=0;i<rows;i++)
	    {
	        for(int j=0, k=columns-1;j<k;j++,k--)
	        {
	            int temp=matrix[i][j];
	            matrix[i][j]=matrix[i][k];
	            matrix[i][k]=temp;
	        }
	    }
	}
	public static void displayMatrix(int[][] mat)
	{
	    for(int i=0;i<mat.length;i++)
	    {
	        for(int j=0;j<mat.length;j++)
	        {
	            System.out.print(mat[i][j]+" ");
	        }
	        
	        System.out.println();
	    }
	}

     // Rotate Matrix by 90 degree in  single pass
	
	public static void rotateMatrixInSinglePass(int[][] matrix)
	{
		int n=matrix.length;
		
		for(int i=0;i<(n/2+n%2);i++)
		{
			for(int j=0;j<n/2;j++)
			{
				int temp=matrix[n-1-j][i];
				matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
				matrix[j][n-1-j]=matrix[i][j];
				matrix[i][j]=temp;
			}
		}
	}

		   
			    
}
