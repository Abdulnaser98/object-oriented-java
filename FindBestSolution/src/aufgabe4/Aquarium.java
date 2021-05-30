package aufgabe4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Abu3hed
 */
public class Aquarium {
    ArrayList<Fisch> arrL=new ArrayList<>();
    int preis;
    ArrayList<Fisch> d=new  ArrayList<>();
    ArrayList<Fisch> getbestSolution=new ArrayList<>();
    public Aquarium(ArrayList<Fisch> arrL,int preis)
    {
         this.arrL=arrL;
         this.preis=preis;
    }
    
    
      public void permute(ArrayList<Fisch> arr) throws CloneNotSupportedException
      {
        String str[];
        str=getString(arr);
        int count[]=new int[arr.size()];
        for(int i=0;i<arr.size();i++)
        {
           count[i]=1;
        }
        String result[]=new String[arr.size()];
        getbestSolutoin(str,count,result,0);
      }
       
    
      public void getbestSolutoin(String []str,int count[],String result[],int level) throws CloneNotSupportedException
      {
         if(level==result.length)
         {
            ArrayList<Fisch> sol=new ArrayList<>();
            for(int i=0;i<result.length;i++)
            {
                if(i==0)
                {
                    for(int j=0;j<arrL.size();j++)
                    {
                       if(arrL.get(j).getTyp().equals(result[i]))
                       {
                          sol.add(arrL.get(j));
                       }
                    }
                }
                else{
                for(int k=0;k<arrL.size();k++)
                    {
                       if(arrL.get(k).getTyp().equals(result[i])&&(isCompatibleWithAllFisch(sol,arrL.get(k)))&&(checkPreis(sol,arrL.get(k).getPreis(),preis)))
                       {
                          sol.add(arrL.get(k));
                       }
                    }
                }
                
            }
            print(sol);
            storSol(sol);
            return ;
         }
         
         for(int i=0;i<str.length;i++)
         {
            if(count[i]==0)
            {
               continue;
            }
           result[level]=str[i];
           count[i]--;
           getbestSolutoin(str,count,result,level+1);
           count[i]++;
         }
      
         
      }
         
         
     
    
     
     public boolean isCompatibleWithAllFisch(ArrayList<Fisch> fisc,Fisch f)
    {
       
        for(int i=0;i<fisc.size();i++)
        {
            if(!fisc.get(i).isVertraegich(f))
            {
               return false;
            } 
        }
        
        return true;
    }
   
    
    
    
    
    public boolean checkPreis(ArrayList<Fisch> arrL,int preisofFisch,int preis)
    {
       int pr=0;
       for(int i=0;i<arrL.size();i++)
       {
            pr+=arrL.get(i).getPreis();
       }
       if(pr+preisofFisch>preis)
       {
          return false;
       }
       else{
           return true;
       }
    }
    
    
  public void print(ArrayList<Fisch>f)
  {
     for(int i=0;i<f.size();i++)
     {
         System.out.print(f.get(i).getTyp());
         System.out.print("->");
     }
     System.out.println();
  
  
  }
   
   public void CopytheOrginaltoBestSoluion(ArrayList<Fisch> arr) throws CloneNotSupportedException
   {
       this.getbestSolution=new ArrayList<>(arr.size());
       for(Fisch f:arr)
       {
          this.getbestSolution.add((f.clone()));
       }
   }
  
  
   public void storSol(ArrayList<Fisch> sol) throws CloneNotSupportedException
   {
      if(!this.getbestSolution.isEmpty())
      {
        if(sol.size()>this.getbestSolution.size())
        {
            CopytheOrginaltoBestSoluion(sol);
        }
        if(sol.size()==this.getbestSolution.size()&&(getTotalPreis(sol)<getTotalPreis(this.getbestSolution)))
        {
            CopytheOrginaltoBestSoluion(sol);
        }
      }
      else{
          CopytheOrginaltoBestSoluion(sol); 
      }
   }
  
   
   
   
   public String[] getString(ArrayList<Fisch>arr)
   {
      String fisches[]=new String[arr.size()];
      for(int i=0;i<arr.size();i++)
      {
          fisches[i]=arr.get(i).getTyp();
      }
   return fisches;
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    
    public ArrayList<Fisch> copy(ArrayList<Fisch> arrL,ArrayList<Fisch> helpedArr) throws CloneNotSupportedException
    {
       for(int i=0;i<arrL.size();i++)
       {
          if(!helpedArr.contains(arrL.get(i)))
          {
              helpedArr.add(arrL.get(i));
          }
       }
        return helpedArr;
       
    }
   
   
   
   
   public int getTotalPreis(ArrayList<Fisch> arr)
   {
      int total=0;
      for(int i=0;i<arr.size();i++)
      {
         total=total+arr.get(i).getPreis();
      }
      return total;
   }
   
   
 
 

    
  
  
  
  
  
  
  
  
  
   

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   


   





}