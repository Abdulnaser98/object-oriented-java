/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe3;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class verschlusseulung {
    
    BigInteger phi;
    public verschlusseulung(BigInteger phi)
    {
       this.phi=phi;
    }
    
  public ArrayList<BigInteger> encrypt(String s,BigInteger[]pulickey)
   {
     BigInteger m;
     BigInteger x;
     BigInteger y;
     String enc="";
     ArrayList<BigInteger>a=new ArrayList<>();
     byte[]b=s.getBytes();
     for(byte f:b)
     {
        System.out.print(f);
        y=BigInteger.valueOf(f);
        x=y.pow(pulickey[0].intValue());
        m=x.mod(pulickey[1]);
        a.add(m);
     }
     for(BigInteger r:a)
     {
        System.out.println(r);
     }
     return a;
  }

  
  
  
   public ArrayList<BigInteger>decrypt(ArrayList<BigInteger> j,BigInteger[] privatekey)
  {
      
      BigInteger s;
      BigInteger p;
      String text="";
      ArrayList<BigInteger> y=new  ArrayList<BigInteger>();
      for(BigInteger f:j)
      {
         s=f.pow(privatekey[0].intValue());
         p=s.mod(privatekey[1]);
         y.add(p);
      }
      for(BigInteger q:y)
         {
           int l=q.intValue();
           char c=(char)l;
           System.out.print(c);
        }
     System.out.println();
     for(BigInteger q:y)
        {
          int l=q.intValue();
          System.out.print(l);
        }
        System.out.println();
        return y;
   }
   
  
   
   
}
  
    
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    
  










  
    
    
    
    
    
    

