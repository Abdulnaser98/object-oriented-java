/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author User
 */
public class schleusselgenerator {
 
    
 private BigInteger primNum1;
 private BigInteger primNum2;
 private BigInteger generatenumber;
 private BigInteger[]offendeSchluesselarr;
 private BigInteger[]privateSchluesselarr;
 private BigInteger phi;
 private BigInteger e;
 BigInteger d;
 
 public schleusselgenerator(int primNum1,int primNum2)
 {
     offendeSchluesselarr=new BigInteger[2];
     privateSchluesselarr=new BigInteger[2];
     this.primNum1=BigInteger.valueOf(primNum1);
     this.primNum2=BigInteger.valueOf(primNum2);
     generatenumber=this.primNum1.multiply(this.primNum2);
     phi=(this.primNum1.subtract(BigInteger.ONE)).multiply(this.primNum2.subtract(BigInteger.ONE));
 }
 
 
 public BigInteger[] offendeSchluessel()
 {
     BigInteger f=new BigInteger("3");
     BigInteger publickey[]=new BigInteger[2];
     int phii=phi.intValue();
     e=GCD(f,phi);
     d = e.modInverse(phi);
     publickey[0]=e;
     publickey[1]=generatenumber;
     return publickey;
 }
 
 
 public BigInteger[] privateSchluessel()
 {
    privateSchluesselarr[0]=d;
    privateSchluesselarr[1]=generatenumber;
    return privateSchluesselarr;
 }
  public BigInteger GCD(BigInteger x,BigInteger y)
  {
   int gcd = 0;
    int h=x.intValue();
    int d=y.intValue();
    while(gcd!=1&&h<=d)
    {
       for(int i=1; i <= h && i <= d; i++)
         {
            // Checks if i is factor of both integers
            if(h%i==0 && d%i==0)
            gcd = i;
         }
      if(gcd!=1)
      {
        h++;
      }  
    }
    System.out.println(h);
    BigInteger s=BigInteger.valueOf(h);
     return s;
   
}
  
 public BigInteger getphi()
 {
    return phi;
 }
 
 
}