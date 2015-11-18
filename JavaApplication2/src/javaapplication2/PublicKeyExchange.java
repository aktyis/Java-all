package javaapplication2;

import java.math.BigInteger;
import java.security.SecureRandom;
/* @author IstyakRM */
public class PublicKeyExchange 
{
    byte[] ui ={127};
    
    SecureRandom rand = new SecureRandom(ui);
    //4620//83
    private BigInteger bobP = new BigInteger("4433434312877665559897787787878787878787809889898989832300003375557557232323323232398989889898989898985");
    private BigInteger bobg = new BigInteger("9999878743231211156789099986555555557777757773");
    private BigInteger bobx = new BigInteger("673");
    private BigInteger bobKey = new BigInteger("0");
    
    public void calculateBobKey()
    {
        this.bobKey = this.bobg.modPow(this.bobx,this.bobP);
    }
    public BigInteger getbobPublicPrime()
    {
        return this.bobP ;
    }
    public BigInteger getbobPublicG()
    {
        return this.bobg ;
    }
    public void setbobPublicx(BigInteger x)
    {
        this.bobx = x ;
    }
    public BigInteger getbobPublicx()
    {
        return this.bobx ;
    }
    public BigInteger getbobPublicKey()
    {
        return this.bobKey ;
    }
    //bob end
    
    //alice start
    private BigInteger alicek = new BigInteger("23");
    private BigInteger aliceK = new BigInteger("0");
    private BigInteger aliceC1 = new BigInteger("0");
    private BigInteger chipherText = new BigInteger("0");
    private BigInteger aliceC2 = new BigInteger("0");
    
    public BigInteger getAliceKey()
    {
        this.aliceK = this.bobKey.modPow(this.alicek,this.bobP);
        return this.aliceK;
    }
    public BigInteger getaliceC1()
    {
        this.aliceC1=this.bobg.modPow(this.alicek,this.bobP);
        return this.aliceC1;
    }
    public void calculatealiceC2(BigInteger chipherText)
    {
        this.aliceC2 = (chipherText.multiply(this.aliceK)).mod(this.bobP); 
    } 
    public BigInteger getaliceC2()
    {
        return  this.aliceC2;  
    } 
    //alice end
}
    


