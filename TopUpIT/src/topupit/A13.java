package topupit;

import java.util.Scanner;

/*
//@title: Assignment-1 of TopUpIT 
//@author: Istyak Rana
//@email: istyak.rana@gmail.com
//@date:07-09-2016 
*/
public class A13
{
    public static void main(String[] args) 
    {//
        System.out.println("Input Steel Info below ?");
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Hardness :");
        int hardness = sc.nextInt();

        System.out.print("Carbone Content :");
        double carbone = sc.nextDouble();  
       
        
        System.out.print("Tensile strength :");
        int tensile = sc.nextInt();
        
        int gradeOfSteel = 5;
        
        boolean one=false,two = false,three = false;
        
        if(hardness >56 )
        {
            one = true;
        }
        if(carbone < 0.7)
        {
            two = true;
        }
        if(tensile >5600)
        {
            three = true;
        }
        if( one && two  && three )
        {
            gradeOfSteel = 10;
        }
        else if(  one  && two)
        {
            gradeOfSteel = 9;
        }
        else if(  three  && two)
        {
            gradeOfSteel = 8;
        }
        else if( one  && three )
        {
            gradeOfSteel= 7;
        }
        else if( one  || two || three )
        {
            gradeOfSteel= 6;
        }
       
        System.out.println( "Steel Grade is : " + gradeOfSteel);
        
    }
    
}
