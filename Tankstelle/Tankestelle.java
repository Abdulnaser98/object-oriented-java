/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankestelleaufgabe;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author User
 */
public class Tankestelle {
 private Kasse ka=new Kasse();
    private int numberZapfsaeule;
    LinkedList<Zapfsaeule> zapfsaeulen=new LinkedList<>();
    LinkedList<Auto> wartezeiten = new LinkedList<Auto>();
    int time = 0; 
    int TOTAL_TIME;
    int minfortanken;
    int maxfortanken;
    int minforbezahlen;
    int maxforbezahlen;
    int minforverlassen;
    int maxforverlassen;
    int ankunft;
    int protokol;
    
   public Tankestelle(int protokol,int numberZapfsaeule,int minfortanken,int maxfortanken,int minforbezahlen,int maxforbezahlen,int minforverlassen,int maxforverlassen)
   {
        for(int i =0;i<numberZapfsaeule;i++)
        {
             zapfsaeulen.add(new Zapfsaeule(i));
        }
        this.numberZapfsaeule=numberZapfsaeule;
        this.minfortanken=minfortanken;
        this.maxfortanken=maxfortanken;
        this.minforbezahlen=minforbezahlen;
        this.maxforbezahlen=maxforbezahlen;
        this.minforverlassen=minforverlassen;
        this.maxforverlassen=maxforverlassen;
        this.protokol=protokol;
    }
  
public void vorgang()
  {
    time=0;
    Random r=new Random();
    int endTimefortanken=(r.nextInt(maxfortanken-minfortanken))+minfortanken;
    int endtimeforbezahlen=(r.nextInt(maxforbezahlen-minforbezahlen)+minforbezahlen);
    int endtimeforverlassen=(r.nextInt(maxforverlassen-minforverlassen)+minforverlassen);
    Auto a = null;
    int i = 0;
    int abstand=protokol*60;
    int TOTAL_TIME=5*3600;
    System.out.println(endTimefortanken);
    System.out.println(endtimeforbezahlen);
    System.out.println(endtimeforverlassen);
    int u=0;
    int n=0;
    int y=0;
    int totamTime;
    while(time<3600)
         {
             
             if(time%abstand==0)
               {
                  a =new Auto(minfortanken,maxfortanken,minforbezahlen,maxforbezahlen,minforverlassen,maxforverlassen);
                  i=numderWarteschlange();
                  if(i!=-1)
                  {
                      zapfsaeulen.get(i).addtoschlange(a);
                      
                  }
                  else{
                        Zapfsaeule k=warten();
                        k.addtoschlange(a);
                      }
                }
             
          for(int j=0;j<zapfsaeulen.size();j++)
          {
              if(zapfsaeulen.get(j).lenght()>0)
               {
                  Auto erstesAuto=zapfsaeulen.get(j).getAuto();
                  //Erstes Auto tanken
                  int timefortanken=erstesAuto.gettimetanken();
                  if(timefortanken>1)
                  {
                       erstesAuto.miusfortanken();
                  }
                   // Ersten Autofahrer, wenn fertig zum zahlen schicken.
                  if(timefortanken==1) {
		      erstesAuto.miusfortanken();
		      ka.addtoschlange(a);
                     }
                  
                   // Erstes Auto raeumen
                   if(timefortanken==0&&(erstesAuto.getZahlen()==0))
                   {
                        erstesAuto.raeumen();
                   }
                   
                   //Erstes Auto wegfahren
                   if(erstesAuto.getraeumen()==0)
                   {
                        wartezeiten.addLast(erstesAuto);
                        zapfsaeulen.get(j).removeformschlange();
                   }
                   
                  
           }
              
          if(zapfsaeulen.get(j).lenght()>1)
            {
                 zapfsaeulen.get(j).iterator();
            }
        }
          
        //zahlen an der Kasse
        if(ka.length()>1)
        {
            if(ka.getschlange().getFirst().getZahlen()==1)
              {
                 ka.getschlange().getFirst().zahlen();
                 ka.removeformschlange();
              }
             else{
                ka.getschlange().getFirst().zahlen();
            }
            //Alle Anderen warten
            if(ka.length()>1)
            {
               Iterator<Auto> iterator=ka.getiterator();
               while(iterator.hasNext())
               {
                     iterator.next().warten();
               }
            }
        }
        
        //Protokol 
         
        if(time%(10)==0)
        { 
          
               System.out.println(time);
           
                    System.out.println("Zapfsaeule 1 : "+zapfsaeulen.get(0).lenght()+" "+"Zapfsaeule 2 : "+zapfsaeulen.get(1).lenght()+" "+"Zapfsaeule 3 : "+zapfsaeulen.get(2).lenght());
                    System.out.println("Kasse : "+ka.length());
               
             	
        }
        
              
              
              
              
              
              
  time++;        
         
  }//end while
         
          
          
}//end vorgang
            
   


 public int numderWarteschlange()
 {
    for(int i=0;i<zapfsaeulen.size();i++)
    {
        if(zapfsaeulen.get(i).lenght()==0)
        {
           return i;
        }
    }
    return -1;
 }



  public Zapfsaeule warten()
   {
      Random r=new Random(); 
      return zapfsaeulen.get(r.nextInt(zapfsaeulen.size()));
   }





   
}
