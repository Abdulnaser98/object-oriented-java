package aufgabe4;

import java.util.ArrayList;

/**
 *
 * @author Abu3hed
 */
public class Fisch implements Cloneable {
   private String typ;
   private int preis;
   private ArrayList<Fisch> nichtVertraeglich=new ArrayList<>();
   private ArrayList<Fisch> bestSolution=new ArrayList<>();
   boolean markiert=false;
   int nsol=0;
   Fisch(String typ,int preis)
   {
      this.typ=typ;
      this.preis=preis;
    
   }
   
   
   
   public boolean isVertraegich(Fisch f)
   {
       if(this.nichtVertraeglich.contains(f))
       {
           return false;
       }
   return true;
   }
 
   
   public String getTyp()
   {
      return typ;
   }
   
   
   public int getPreis()
   {
      return preis;
   }
   
   
   public ArrayList<Fisch> getarrL()
   {
      return new ArrayList<>(this.nichtVertraeglich);
   }
   
   
   public boolean equals(Object object2) {
    return object2 instanceof Fisch && typ.equals(((Fisch)object2).typ);
   }
    
    public void setnichtvertraglcihList(ArrayList<Fisch> fi)
    {
        this.nichtVertraeglich=fi;
     
    }
   
    
    
    public void store(ArrayList<Fisch> arr)
    {
       if(arr.size()>0)
       {
         for(int i=0;i<arr.size();i++)
         {
             this.bestSolution.add(arr.get(i));
         }
       }
    }
        
    
    public ArrayList<Fisch> vertraglich(ArrayList<Fisch> fische)
    {
       ArrayList<Fisch> ar;
       ar = new ArrayList<>();
     for(int i=0;i<fische.size();i++)
        {
            if(!this.nichtVertraeglich.contains(fische.get(i))&&(!this.getTyp().equals(fische.get(i).getTyp())))
            {
                ar.add(fische.get(i));          
            }
        }
     return ar;
    }

    
    
    public void clear()
    {
       this.bestSolution.clear();
    }
    public ArrayList<Fisch> getbestSolution()
    {
       return bestSolution;
    }
    
 
    public boolean markieren()
    {
       if(!this.markiert)
       {
          this.markiert=true;
          return true;
       }
       return false;
    }
    
    public void unmarkieren()
    {
       if(this.markiert==true)
       {
           this.markiert=false;
       }
    }
    
    
    
   @Override
    public Fisch clone() throws  CloneNotSupportedException{
       return (Fisch)super.clone();
    }
 
    
    
    
   
}