package topupit;

import java.util.Scanner;

/*
//@title: Assignment-1 of TopUpIT 
//@author: Istyak Rana
//@email: istyak.rana@gmail.com
//@date:07-09-2016 
*/
public class A12
{
    public static void main(String[] args) 
    {//
        System.out.println("Input Personal Info below ?");
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Name :");
        String name = sc.nextLine();

        System.out.print("Age :");
        String ag = sc.nextLine();  
        int age = Integer.parseInt(ag);
        
        System.out.print("Sex is Male or Female :");
        String sex = sc.nextLine();
        
        System.out.print("Health Condition is excellent or poor :");
        String health = sc.nextLine();
        
        System.out.print("Lives in City or Village:");
        String location = sc.nextLine();
        
        int premium = 0, policyAmmount = 0;
    
        if( health.equalsIgnoreCase("excellent") && (age >=25 & age <= 35)&& location.equalsIgnoreCase("city"))
        {
            if(sex.equalsIgnoreCase("male"))
            {
                premium = 4;
                policyAmmount = 200000;
            }
            else if(sex.equalsIgnoreCase("female"))
            {
                premium = 3;
                policyAmmount = 100000;
            }
                       
        }
        else if( health.equalsIgnoreCase("poor") && (age >=25 & age <= 35)&& location.equalsIgnoreCase("village") && sex.equalsIgnoreCase("male"))
        {
            premium = 6;
            policyAmmount = 10000;
            
        }
        else
        {
            System.out.println( name +" Is not Insured" );
        }
        if(premium > 0)
        {
            System.out.println( name +" Is Insured" );
            System.out.println( "Premium Per Thousand : " + premium + " tk");
            System.out.println( "Maximum Policy Amount : " + policyAmmount+ " tk");
        }
    }
    
}
