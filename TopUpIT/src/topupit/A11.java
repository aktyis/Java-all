package topupit;

import java.util.Scanner;

/*
//@title: Assignment-1 of TopUpIT 
//@author: Istyak Rana
//@email: istyak.rana@gmail.com
//@date:07-09-2016 
*/
public class A11
{
    public static void main(String[] args) 
    {
        System.out.println("Input ##### Five digit number:");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(),tempNmber,newNumber=0;
        tempNmber = number;
        int divisor = 10000;
        int []arr = {0,0,0,0,0};
        int temp[]= new int[5];
        
        for (int i = 0; i < 5; i++) 
        {
            arr[i] = number /divisor;
            
            number = number % divisor;
            divisor = divisor/10;        
        }
         //System.out.println("Sum of First and Last Digit: "+ Arrays.toString(arr) );
        for (int j = 0,i = 4; j < 5; j++,i--) 
        {
            temp[j] = arr[i];
            
        }
        divisor = 1;
        for (int i = 4; i >= 0 ; i--) 
        {
                        
            newNumber += (temp[i] * divisor);
            divisor = divisor*10;   
            
        }
        System.out.println( "Reverse Number " +newNumber );
        if(number == newNumber)
            System.out.println( "Both Numbers are Equal" );
        else
            System.out.println( "Both Numbers are Not Equal" );
    }
    
}
