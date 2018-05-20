import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution_18 {

    static int findMaxDiff(int n, int [] arr) {
	    int max =0;
	    
	    for (int i =0; i< n; i++)
	    { 
		    for (int j =0; j< i; j++)
			{ 
				int diff = arr[i]-arr[j] ;
				if ( diff > max)
				{
					max = diff;
				}
				//~ System.out.println(" The result"+ diff + "  " );
			}
		    //~ System.out.println("");
	    }
	    
	    return max;
	
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args)  {
        

        //~ int n = scan.nextInt();
	int n = 7;
	int [] arry  = {2, 3, 10, 2, 4, 8, 1};
	
	int result = findMaxDiff(n, arry);
	System.out.println( " Maximum Difference is " + result );
  
    }
}
