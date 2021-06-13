/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	    public char nextGreatestLetter(char[] letters, char target) {
        
        int n=letters.length;
        if(n==0)
            return '#';
        if(n==1 && letters[n-1]>target)
            return letters[n-1];
        
        int l=0;
        int h=n-1;
        int res=-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
          
            
            if(letters[mid]==target)
                l=mid+1;
            else if(letters[mid]>target)
            {
                res=mid;
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        
        return res>-1?letters[res]:letters[0];
    }
}
