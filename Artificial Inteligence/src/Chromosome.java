import java.util.Arrays;

public class Chromosome
{

    private  String[] population = new String [5];
    private  String intNumber;
    private int variable;
    private int function;
    private double offSpringFitness;
    private int offSpringFitnessRpunded;
    public Chromosome(String[] pop)
    {
        population = pop;
        
        String intNumber;
        
        intNumber = population[0]+ population[1]+ population[2]+ population[3]+ population[4];
        intNumber.trim();
        
        int number = Integer.parseInt(intNumber, 2);
       
        this.variable = number;
        this.function = this.variable * this.variable  ;
        //this.function = this.variable * this.variable *this.variable ;
        System.out.println("this is variable "+this.variable + "   this is Func "+this.function );
    }
    public void calculate()
    {
        
        
        
        intNumber = population[0]+ population[1]+ population[2]+ population[3]+ population[4];
        intNumber.trim();
        
        int number = Integer.parseInt(intNumber, 2);
       
        this.variable = number;
        this.function = this.variable * this.variable  ;
        //this.function = this.variable * this.variable *this.variable ;
        System.out.println("this is variable "+this.variable + "   this is Func "+this.function );
    }
    /**
     * @return the variable
     */
    public int getVariable() {
        return variable;
    }

    /**
     * @return the function
     */
    public int getFunction() {
        return function;
    }


    /**
     * @return the offSpringFitness
     */
    public double getOffSpringFitness() {
        return offSpringFitness;
    }

    /**
     * @param offSpringFitness the offSpringFitness to set
     */
    public void setOffSpringFitness(int fAvarage) 
    {
        this.offSpringFitness = (double)this.function/fAvarage;
        this.offSpringFitnessRpunded = (int)Math.ceil(offSpringFitness);
    }

    /**
     * @return the offSpringFitnessRpunded
     */
    public float getOffSpringFitnessRpunded() {
        return offSpringFitnessRpunded;
    }
   

    /**
     * @return the population
     */
    public String[] getPopulation() {
        return population;
    }      
    public String showPopulation() {
        return  intNumber ;
    } 
 
        
}
