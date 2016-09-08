package topupit;

import java.util.Scanner;

/*
//@title: Assignment-1 of TopUpIT 
//@author: Istyak Rana
//@email: istyak.rana@gmail.com
//@date:07-09-2016 
*/
public class A10
{
    public static void main(String[] args) 
    {
        System.out.println("Input #### four digit number:");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int divisor = 1000;
        int sum;
        int []arr = {0,0,0,0};
        
        for (int i = 0; i < 4; i++) 
        {
            arr[i] = number /divisor;
            
            number = number % divisor;
            divisor = divisor/10;        
        }
        sum = arr[0]+arr[3];
        System.out.println("Sum of First and Last Digit: "+ sum );
    }
    
}
