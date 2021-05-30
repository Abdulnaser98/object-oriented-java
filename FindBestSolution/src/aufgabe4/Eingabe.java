package aufgabe4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Eingabe {
    
    
    
    Scanner sc=new Scanner(System.in);
    
    
    
    
    public int getPreis()
    {
       System.out.println("How is the Price totally?");
       int totalprice=getFischPreis();
       return totalprice;
    }
    
    
    public ArrayList<Fisch> getFisch()
    {
       ArrayList<Fisch> getFisches=new ArrayList<>();
       System.out.println("how many Fisch do you want to Input?");
       int num=getFischPreis();
       int count=0;
       while(count<num)
       {
         System.out.println("what is the type of the "+" "+count+" "+"Fisch and the price %d ?");
         String type=getFischType(getFisches);
         System.out.println();
         int pr=getFischPreis();
         Fisch f=new Fisch(type,pr);
         getFisches.add(f);
         count++;
       }
       int j=0;
       while(j<num)
       {
           System.out.printf("How about the Number of the unvertag-List of the"+" "+j+" "+" Fisch");
           int zahl=getFischPreis();
           int k=0;
           ArrayList<Fisch> it=new ArrayList<>();
           while(k<zahl)
           {
               String in=getFischType(it);
               for(int i=0;i<getFisches.size();i++)
               {
                    if(getFisches.get(i).getTyp().equals(in))
                    {
                       it.add(getFisches.get(i));
                    }
               } 
               k++;    
           }
           getFisches.get(j).setnichtvertraglcihList(it);
           j++;
       }
        return getFisches;
       
    }




  public String getFischType(ArrayList<Fisch> arrL) 
   {
      Scanner sc=new Scanner(System.in);
      System.out.println("Plaese Entre the Fisch Type?");
      boolean getScuss=false;
      String in="";
      while(!getScuss){
            getScuss=true;
            in=sc.nextLine();
           if(!checkifString(in))
            {
               System.out.println("The Input you have just entered is not a valid String, please Entre again");
               getScuss=false;
            }
           if(!arrL.isEmpty()&&(contin(in,arrL)))
             {
               System.out.println("The Input you have just entered is already here , please Entre another fisch-type again");
               getScuss=false; 
             }
     }
      return in;
   }
  
  
   public int getFischPreis()
   {
      System.out.print("Enter an integer: "); 
      while(!sc.hasNextInt())
      {
         sc.next();
         System.out.print("the Number you have just input is not valid,please Entre again"); 
      }
      int price=sc.nextInt();
      return price;
   }
   
   
   
   public boolean checkifString(String s)
   {
       int i=0;
       while(i<s.length())
       {
          if(Character.isDigit(s.charAt(i)))
          {
             return false;
          }
         i++;
       }
   return true;
   }
   
   
   
   
   public boolean contin(String in,ArrayList<Fisch>arrL)
   {
      for(int i=0;i<arrL.size();i++)
      {
          if(arrL.get(i).getTyp().equals(in))
          {
             return true;
          }
      }
   return false;
 }
   
   
   
   
   
   
   
   
   



}