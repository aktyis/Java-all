import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class GeneticAlgo
{
        public static void main(String[] args)
	{
            
            String[] gene1 = {"0","1","1","0","1"}; 
            String[] gene2 = {"1","1","0","0","0"}; 
            String[] gene3 = {"0","1","0","0","0"}; 
            String[] gene4 = {"1","0","0","1","1"};
            
            generation[] gen = new generation[2100];
            
            gen[0] = new generation(gene1,gene2,gene3,gene4);
            System.out.println("this is max "+gen[0].getMaxOfFunction() + "  this is sum "+gen[0].getSumOfFunction()  + "    this is avg "+gen[0].getAvgOfFunction() );
            
         
            for(int i =1 ;i < 2100 ;i++)
            {
                System.out.println("-------------  Generation : " + i + "---------------");
                gen[i] = gen[i-1];            
                gen[i].mutatateFunc();
                gen[i].calculate();
                System.out.println("   this is max "+gen[i].getMaxOfFunction() + "  this is sum "+gen[i].getSumOfFunction()  + "   this is avg "+gen[i].getAvgOfFunction() );
                if (gen[i].getMaxOfFunction() >= 950)
                {
                    System.out.println("Population \n 1---" + gen[i].getPop1().showPopulation()+"\n 2---"+ gen[i].getPop1().showPopulation()+"\n 3---" +gen[i].getPop3().showPopulation()+"\n 4---"+ gen[i].getPop4().showPopulation() );
                    break;
                }
            
            }
            
            }
        
}


