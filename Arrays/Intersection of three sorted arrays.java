/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main(String[] args){
	/*
	    Input:
        ar1[] = {1, 5, 10, 20, 40, 80}
        ar2[] = {6, 7, 20, 80, 100}
        ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
        Output: 20, 80
        
        Input:
        ar1[] = {1, 5, 5}
        ar2[] = {3, 4, 5, 5, 10}
        ar3[] = {5, 5, 10, 20}
        Output: 5, 5
     */
     
    /* int[] ar1 = {1, 5, 10, 20, 40, 80};
     int[] ar2 = {6, 7, 20, 80, 100};
     int[] ar3 = {3, 4, 15, 20, 30, 70, 80, 120};*/
     
     int ar1[] = {1, 5, 5};
     int ar2[] = {3, 4, 5, 5, 10};
     int ar3[] = {5, 5, 10, 20};
     
     commonElements(ar1,ar2,ar3);
}
    public static void commonElements(int[] ar1, int[] ar2, int[] ar3)
    {
        int i=0;int j=0; int k=0;
        
        while(i< ar1.length && j<ar2.length && k<ar3.length)
        {
            if(ar1[i]==ar2[j] && ar2[j]==ar3[k])
            {
                System.out.print(ar1[i]+" ");
                i++;
                j++;
                k++;
            }else if(ar1[i]<ar2[j])
            {
                i++;
            }else if(ar2[j]<ar3[k])
            {
                j++;
                
            }else
            {
                k++;
            }
        }
    }
}
