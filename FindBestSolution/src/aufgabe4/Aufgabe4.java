package aufgabe4;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Aufgabe4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
     
     Eingabe ei=new Eingabe();
     ArrayList<Fisch> arr=new ArrayList<>();
     int pr=ei.getPreis();
     arr=ei.getFisch();
     Aquarium aq=new Aquarium(arr,pr);
     aq.permute(arr);
     System.out.println("==================================0");
     System.out.println("The Best Solution for the Problem is :  ");
     for(int i=0;i<aq.getbestSolution.size();i++)
     {   
         System.out.print(aq.getbestSolution.get(i).getTyp());
         System.out.print("->");
     }
     System.out.println("The Taotal Price is : "+" "+aq.getTotalPreis(aq.getbestSolution));
     System.out.println();
     
    
    
     
      
      
    }
    
    
    
}