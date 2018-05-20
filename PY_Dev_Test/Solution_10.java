import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution_10 {

    
    static int findMaxMoney(int n, int unlucky) {
	    int total =0;
	    for (int i =1; i<= n; i++)
	    { 
		    total += i;
		    if (total == unlucky)
		    {
			    total -= 1;
		    }
		    //~ System.out.println(" The result"+ total );
	    }
	    
	    return total;
	
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args)  {
        

        int n = scan.nextInt();

        int unlucky = scan.nextInt();


        int result = findMaxMoney(n, unlucky);
	System.out.println( " Maximum Money is " + result );
  
    }
}
