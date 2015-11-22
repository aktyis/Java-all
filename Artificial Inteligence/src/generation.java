
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class generation 
{
    private pop pop1 ;
    private pop pop2 ;
    private pop pop3 ;
    private pop pop4 ;
    
    private int sumOfFunction;
    private int avgOfFunction;
    private int maxOfFunction;
    
    public generation(String[] one1,String[] one2,String[] one3,String[] one4)
    {
        this.pop1 = new pop(one1);
        this.pop2 = new pop(one2);
        this.pop3 = new pop(one3);
        this.pop4 = new pop(one4);
        
        this.sumOfFunction = pop1.getFunction() + pop2.getFunction() + pop3.getFunction()+ pop4.getFunction();
        this.avgOfFunction = this.sumOfFunction/4;
        this.maxOfFunction = pop1.getFunction();
        
        if( this.maxOfFunction < pop2.getFunction())
        {
            this.maxOfFunction = pop2.getFunction();
        }
        else if(this.maxOfFunction < pop3.getFunction())
        {
            this.maxOfFunction = pop2.getFunction();
        }
        else if(this.maxOfFunction < pop4.getFunction())
        {
            this.maxOfFunction = pop4.getFunction();
        }        
    }
    
    public void calculate()
    {
        this.sumOfFunction = pop1.getFunction() + pop2.getFunction() + pop3.getFunction()+ pop4.getFunction();
        this.avgOfFunction = this.sumOfFunction/4;
       
        
        int[] maxArray = {pop1.getFunction(), pop2.getFunction(),pop3.getFunction(),pop4.getFunction()};
        Arrays.sort(maxArray);
        
        this.maxOfFunction = maxArray[3];
    }
    
    public void mutatateFunc() 
    {
        // 1 2 ,3 4 / 1 3 , 2 4 / 1 4 /  2 3/ 2 4 / 3 4
        
        Random rand = new Random() ;
        int randomNum = rand.nextInt((1000 - 1) + 1) + 1;
         
        if (randomNum <= 100)
        {
            this.swap(pop1.getPopulation(),pop2.getPopulation());
            this.swap(pop3.getPopulation(),pop4.getPopulation());
        }
        else
        {
            if (randomNum <= 200)
            {
                this.swap(pop1.getPopulation(),pop3.getPopulation());
                this.swap(pop2.getPopulation(),pop4.getPopulation());
            }
            else 
            {                
                this.swap(pop1.getPopulation(),pop4.getPopulation());
                this.swap(pop2.getPopulation(),pop3.getPopulation());   
            }
        }
      
        this.pop1.calculate();
        this.pop2.calculate();
        this.pop3.calculate();
        this.pop4.calculate();
        
    }
    public void swap(String[] str1, String[] str2) 
    {
        Random rand = new Random() ;
        int randomNum = rand.nextInt((5 - 0) + 1) + 1;
        int point = randomNum-1;        
        String temp;
        
        for(  ; point < str1.length ; point++)
        {
           temp = str1[point];
           str1[point] = str2[point];
           str2[point] = temp;
        }        
    }
    
    
    /**
     * @return the sumOfFunction
     */
    public int getSumOfFunction() 
    {
        return sumOfFunction;
    }


    /**
     * @return the avgOfFunction
     */
    public int getAvgOfFunction() 
    {
        return avgOfFunction;
    }

    
    /**
     * @return the maxOfFunction
     */
    public int getMaxOfFunction() 
    {
        return maxOfFunction;
    }
public pop getPop1() {
        return pop1;
    }

    /**
     * @return the pop2
     */
    public pop getPop2() {
        return pop2;
    }

    /**
     * @return the pop3
     */
    public pop getPop3() {
        return pop3;
    }

    /**
     * @return the pop4
     */
    public pop getPop4() {
        return pop4;
    }

    
    
    
    
    
    
    
    
}
