package topupit;

import java.util.Scanner;

/*
//@title: Assignment-1 of TopUpIT 
//@author: Istyak Rana
//@email: istyak.rana@gmail.com
//@date:07-09-2016 
*/
public class A7
{
    public static void main(String[] args) 
    {
        System.out.println("Input Your Birthday DD/MM/YYYY:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine() ;
        String []bDay = str.split("/");
        try 
        {
            
            int day = Integer.parseInt( bDay[0]);
            int month = Integer.parseInt( bDay[1]);
            int year = Integer.parseInt( bDay[2]);
            
            if(day>31 ||month > 12 || year > 2016 || year < 1900) 
            {
                System.out.println("Invalid Date");               
            }
            else 
            {
                System.out.println("Day :"+ day);
                System.out.println("Month :"+ month);
                System.out.println("Year :"+ year);
            }
        }
        catch (Exception e)
        {
            System.out.println("Invalid Date");
        }
   
       
        
       
       
       
    }
    
}
