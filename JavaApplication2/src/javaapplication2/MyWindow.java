package javaapplication2;

import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.math.BigInteger;
import javax.swing.*;

//* @author IstyakRM */
class MyWindow extends JFrame implements ActionListener
{
    static int S = 1 ;
    PublicKeyExchange pKE;
    private  String temptext,fName = "CypherText.txt";
    private String ciphertext;
    private JPanel panel;
    private JTextArea tz = new JTextArea("");
    private JLabel label1;
    private JTextField tf;
    private JButton EncryptButton,DecryptButton,SaveButton;
    public MouseSensor m =new MouseSensor(this);
    public MouseSensor2 m1 =new MouseSensor2(this);
    
    BigInteger code;
    int checker=0,bchecker=0;
   
    public MyWindow(PublicKeyExchange pKE)
    {
        InitializeComponent();
         this.pKE = pKE;
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        String command = e.getActionCommand();
        
        if(command.equals("Encrypt"))
        {    
            bchecker++;
            //Encrypt
            checker++;
            String text = this.tf.getText();
            if(text.length() < 1)
            {temptext=" Null String is not Supported ";}
            else{
                code = new BigInteger(text.getBytes());

                //build initials data
                pKE.calculateBobKey();           // bobs public Y key
                pKE.getAliceKey();              // alices K 
                pKE.getaliceC1();               //alices C1 public key
                pKE.calculatealiceC2(code);     //alices C2 public key

                //Encryption  end 
                ciphertext = new String(pKE.getaliceC1()+" , "+pKE.getaliceC1());

                System.out.println("EnCrypted Massage  : "+pKE.getaliceC1()+" , "+pKE.getaliceC2());
                this.temptext = new String(pKE.getaliceC1()+"\n , "+pKE.getaliceC2());
            }
                this.showMessage(temptext);
            
        }
        else if(command.equals("Decrypt"))
        {
            bchecker++;
             BigInteger K= new BigInteger("0") ;
            BigInteger K1 = new BigInteger("0");
            BigInteger M = new BigInteger("0");
            
            if(checker==0)
            {  
                String[] text = this.tf.getText().split(",");
                if(text.length == 2)
                {
                BigInteger tC1 = new BigInteger(text[0].trim());
                BigInteger tC2 = new BigInteger(text[1].trim());

                //DeEncryption Start
                pKE.calculateBobKey();           // bobs public Y key
                pKE.getAliceKey();              // alices K 
               

                //end build initials data
                K1 = tC1.modPow(pKE.getbobPublicx(),pKE.getbobPublicPrime());
                K = K1.modInverse(pKE.getbobPublicPrime());
                M = (K.multiply(tC2)).mod(pKE.getbobPublicPrime());
                 ciphertext = new String(M.toByteArray());
                 //DeEncryption end
                }
                else
                    ciphertext = " Invalid Cyphertext ";
                    
            }
            else if(checker >= 1)
            {
                pKE.calculateBobKey(); // bobs public Y key
                pKE.getAliceKey(); // alices K 
                pKE.getaliceC1();  //alices C1 public key

                //end build initials data
                K1 = pKE.getaliceC1().modPow(pKE.getbobPublicx(),pKE.getbobPublicPrime());
                K = K1.modInverse(pKE.getbobPublicPrime());
                M = (K.multiply(pKE.getaliceC2())).mod(pKE.getbobPublicPrime());
                 ciphertext = new String(M.toByteArray());
            }
        
            System.out.println("Decrypted Massage  : "+ciphertext);
            this.showMessage(ciphertext);          
        }
        else if(command.equals("Save"))
        {
            String filetext;
            bchecker++;
             try {
                File out =new File(fName);
                out.createNewFile();
                if(!out.isFile())
                {
                    this.fName = "CypherText.txt";
                  
                }
                else
                {
                    this.fName = new String( "CypherText__"+S + ".txt");
                    this.S++;
                }
                PrintWriter textout = new PrintWriter(fName);
                textout.write(ciphertext);
                textout.flush();
                textout.close();
                filetext=new String ("File saved in " + out.getAbsolutePath());
                this.showMessage(filetext);
                System.out.println("File Saved");
            }
            catch (FileNotFoundException ex) {
                System.out.println(ex.toString()); 
                System.out.println("File creation error !");
                 this.showMessage("File Not Found");
            } 
            catch(Exception ex){
                System.out.println("File creation error !");
                 this.showMessage("File Saving Failed");
            }
             
        }
    }
            
    
    public void InitializeComponent()
    {
        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setBackground(Color.GRAY);
        
        //this.addMouseListener(m);
	//this.addMouseMotionListener(m);
        
        this.add(this.panel);
        this.setSize(1200, 350);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.label1 = new JLabel("Enter Text");
        this.label1.setForeground(Color.BLUE);
        this.label1.setBounds(20, 25, 100, 20);
        this.panel.add(this.label1);

        this.tf = new JTextField("  String < 42 ");
        this.tf.setBounds(140, 20, 500, 30);
        this.tf.addMouseListener(m);
        this.panel.add(this.tf);
        
        
        this.tz.setBounds(10, 120, 450 , 500);
        this.tz.setEditable(false);
        this.tz.setSize(1150, 180);
        this.tz.addMouseListener(m1);
        this.panel.add(this.tz);
        
        this.DecryptButton = new JButton("Decrypt");
        this.DecryptButton.setBounds(140, 80, 100, 20);
        this.DecryptButton.addActionListener(this);
        this.panel.add(this.DecryptButton);

        this.EncryptButton = new JButton("Encrypt");
        this.EncryptButton.setBounds(260, 80, 100, 20);
        this.EncryptButton.addActionListener(this);
        this.panel.add(this.EncryptButton);

        this.SaveButton = new JButton("Save");
        this.SaveButton.setBounds(380, 80, 100, 20);
        this.SaveButton.addActionListener(this);
        this.panel.add(this.SaveButton);  
    }
    public void showTextField(String text)
    {
        tf.setText(text);
    }
    public void showMessage(String text)
    {
         tz.setText(new String("\n\n\n\n\t\t\t\t"+text));
    }
}


