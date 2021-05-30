/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankestelleaufgabe;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class Zapfsaeule {
  private int number;
    private boolean frei=true;
    public LinkedList<Auto> zapfsauelwarteschlange = new LinkedList<>();
    public Zapfsaeule(int number)
    {
       this.number=number;
    }
    public boolean belegt()
    {
       if(this.frei)
       {
          this.frei=false;
          return true;
       }
       else{
         return false;
       }
    }
    public void debelegt()
    {
       if(!this.frei)
       {
          this.frei=true;
       }
    }
    public int lenght()
    {
        return zapfsauelwarteschlange.size();
    }
    public void addtoschlange(Auto auto)
    {
         zapfsauelwarteschlange.addFirst(auto);
    }
    public void removeformschlange()
    {
         zapfsauelwarteschlange.removeFirst();
    }
    public boolean isEmpty()
    {
      return  zapfsauelwarteschlange.isEmpty();
    }
 
   public void iterator()
   {
      Iterator<Auto> iter=zapfsauelwarteschlange.iterator();
      while(iter.hasNext())
      {
         iter.next().warten();
      }
   }

    Auto getAuto() {
        return   zapfsauelwarteschlange.getFirst();
}
       
}
