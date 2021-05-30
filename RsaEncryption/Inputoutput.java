/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Inputoutput {
    String pfadin;
    String pfadout;
    public Inputoutput(String infile,String outfile)
    {
       this.pfadin=infile;
       this.pfadout=outfile;
    }
    
    public String read() throws IOException
    {
        StringBuilder sb=new StringBuilder();
        FileReader inputStream=null;
        try{
        inputStream=new FileReader(pfadin);
        int c;
        while((c=inputStream.read())!=-1)
        {
               sb.append((char)c);
        }
     }catch(IOException e)
     {
        System.out.println("Error in Reading from File");
     }
     finally{
      if(inputStream!=null)
      {
         inputStream.close();
      }
  }
   return sb.toString();  
}
    
  
    public void write(ArrayList<BigInteger> Str,String outpfad) throws IOException
    {
      
     FileWriter outputstream=null;
      try{
      outputstream=new FileWriter(outpfad);
      for(BigInteger bi:Str)
      {
          int c=bi.intValue();
          outputstream.write((char)c);
         
      }
    }
      catch(IOException io)
      {
         System.out.println("couldn't find ouput path");
      }
 }      
      
      
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
}
