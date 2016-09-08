package topupit;

import java.util.Scanner;
/*
//@title: Assignment-1 of TopUpIT 
//@author: Istyak Rana
//@email: istyak.rana@gmail.com
//@date:07-09-2016 
*/
public class A14
{
    public static void main(String[] args) 
    {//
        System.out.println("Input Order Info below ?");
        Scanner sc = new Scanner(System.in);
        
        boolean customerCredit = false;
        
        System.out.print("Order Quantity :");
        int order = sc.nextInt();
        
        System.out.print("Current Supply :");
        int supply = sc.nextInt();
        
        System.out.print("Customer Credit :");
        int temp = sc.nextInt();
        if( temp > 0)
        {
            customerCredit = true;
        }
       
        if(customerCredit && order <= supply)
        {
            System.out.println(" Supply can be done");
        }
        else if( !customerCredit )
        {
            System.out.println(" Do not Supply & send Intimation");
        }
        else if(customerCredit && order > supply)
        {
             System.out.println(" Supply & send Intimation");
        }
    }
    
}
