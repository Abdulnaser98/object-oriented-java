/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankestelleaufgabe;

import java.util.Random;

/**
 *
 * @author User
 */
public class Auto {
    private int nummer;
    private int tanken; 
    Random r =new Random();
    private int raeumen;
    private int zahlen;
    private int warten;
    public Auto(int minfortanken,int maxfortanken,int minforbeazhlen,int maxforbezahlen,int minforverlassen,int maxforverlassen)
    {
        this.tanken=r.nextInt(maxfortanken-minfortanken)+minfortanken;
        this.raeumen=r.nextInt(maxforbezahlen-minforbeazhlen)+minforbeazhlen;
        this.zahlen=r.nextInt(maxforverlassen-minforverlassen)+minforverlassen;
        this.warten=0;
    }

    Auto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int zufallzahlgenerator()
    {
        r =new Random();
        return r.nextInt(1000000);
    }
   public int gettimetanken()
   {
       return this.tanken;
   }
   public void miusfortanken()
   {
      this.tanken--;
   }
   
   public int getraeumen()
   {
       return raeumen;
   }
    public void raeumen() {
        this.raeumen--;
     }


    public int getZahlen()
     {
        return zahlen;
    }
    public void zahlen()
    {
       zahlen--;
    }
    public int getWarten() {
	return warten;
    }
    
    public void warten() {
      this.warten++;
    }
    
}
