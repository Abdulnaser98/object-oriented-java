/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe3;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class verwaltung {
    
    Eingabe ei=new Eingabe();
    
    
    public void verwalten() throws IOException
    {
       int []prinumbers=ei.eingabe1();
       String []io=ei.eingabe2();
       schleusselgenerator sg=new schleusselgenerator(prinumbers[0],prinumbers[1]);
       verschlusseulung vers=new verschlusseulung(sg.getphi());
       Inputoutput iao=new Inputoutput(io[0],io[1]);
       String in=iao.read();
       ArrayList<BigInteger>verss=new ArrayList<>();
       verss=vers.encrypt(in,sg.offendeSchluessel());
       ArrayList<BigInteger>decc=new ArrayList<>();
       decc=vers.decrypt(verss,sg.privateSchluessel());
       iao.write(decc,io[1]);
       
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
}
