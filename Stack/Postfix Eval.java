/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Evaluation of PostFix Expression
		String postFix="100 200 + 2 / 5 * 7 +";
		System.out.println(eval(postFix));
	}
	public static int eval(String exp)
	{
         if(exp==null || exp.length()==0)
           return -1;
         //int res=0;
         Stack<Integer> s=new Stack<>();
         
         for(int i=0;i<exp.length();i++)
         {
              if(exp.charAt(i)==' ' || exp.charAt(i)==',')
              continue;
              if(IsNumeric(exp.charAt(i)))
                {
                     int num=0;
                     while(i<exp.length() && IsNumeric(exp.charAt(i)))
                     {
                          num=(num*10)+exp.charAt(i)-'0';
                          i++;
                     }
                     i--;
                     s.push(num);
                }
               else if(IsOperator(exp.charAt(i)))
                {
                    int op2=s.pop();
                    int op1=s.pop();
                    
                    int res=performOperation(exp.charAt(i),op1,op2);
                    s.push(res);
                }
         }
         
         return s.pop();
	}
	
	public static boolean IsNumeric(char ch)
	{
	     if(ch>='0' && ch<='9')
	     return true;
	     return false;
	}
	
	public static boolean IsOperator(char ch)
	{
	     if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
	     return true;
	     return false;
	}
	
	public static int performOperation(char op,int val1,int val2)
	{
	     switch(op)
	    {
	         case'+':
	               return val1+val2;
	               
	         case '-':
	               return val1-val2;
	             
	         case '*':
	               return val1*val2;
	             
	         case '/':
	              return val1/val2;
	             
	    }
	    return -1;
	}
}
