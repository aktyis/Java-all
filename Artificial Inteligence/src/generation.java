import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class generation 
{
    private Chromosome chromosome1 ;
    private Chromosome chromosome2 ;
    private Chromosome chromosome3 ;
    private Chromosome chromosome4 ;
    
    private int sumOfFunction;
    private int avgOfFunction;
    private int maxOfFunction;
    
    public generation(String[] one1,String[] one2,String[] one3,String[] one4)
    {
        this.chromosome1 = new Chromosome(one1);
        this.chromosome2 = new Chromosome(one2);
        this.chromosome3 = new Chromosome(one3);
        this.chromosome4 = new Chromosome(one4);
        
        this.sumOfFunction = chromosome1.getFunction() + chromosome2.getFunction() + chromosome3.getFunction()+ chromosome4.getFunction();
        this.avgOfFunction = this.sumOfFunction/4;
        this.maxOfFunction = chromosome1.getFunction();
        
        if( this.maxOfFunction < chromosome2.getFunction())
        {
            this.maxOfFunction = chromosome2.getFunction();
        }
        else if(this.maxOfFunction < chromosome3.getFunction())
        {
            this.maxOfFunction = chromosome2.getFunction();
        }
        else if(this.maxOfFunction < chromosome4.getFunction())
        {
            this.maxOfFunction = chromosome4.getFunction();
        }        
    }
    
    public void calculate()
    {
        this.sumOfFunction = chromosome1.getFunction() + chromosome2.getFunction() + chromosome3.getFunction()+ chromosome4.getFunction();
        this.avgOfFunction = this.sumOfFunction/4;
       
        
        int[] maxArray = {chromosome1.getFunction(), chromosome2.getFunction(),chromosome3.getFunction(),chromosome4.getFunction()};
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
            this.cross(chromosome1.getPopulation(),chromosome2.getPopulation());
            this.cross(chromosome3.getPopulation(),chromosome4.getPopulation());
        }
        else
        {
            if (randomNum <= 200)
            {
                this.cross(chromosome1.getPopulation(),chromosome3.getPopulation());
                this.cross(chromosome2.getPopulation(),chromosome4.getPopulation());
            }
            else 
            {                
                this.cross(chromosome1.getPopulation(),chromosome4.getPopulation());
                this.cross(chromosome2.getPopulation(),chromosome3.getPopulation());   
            }
        }
      
        this.chromosome1.calculate();
        this.chromosome2.calculate();
        this.chromosome3.calculate();
        this.chromosome4.calculate();
        
    }
    public void cross(String[] str1, String[] str2) 
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
public Chromosome getChromosome1() {
        return chromosome1;
    }

    /**
     * @return the pop2
     */
    public Chromosome getChromosome2() {
        return chromosome2;
    }

    /**
     * @return the pop3
     */
    public Chromosome getChromosome3() {
        return chromosome3;
    }

    /**
     * @return the pop4
     */
    public Chromosome getChromosome4() {
        return chromosome4;
    }

    
    
    
    
    
    
    
    
}
