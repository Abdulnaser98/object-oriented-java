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
public class Kasse {
    LinkedList<Auto> kassewarteschlange =new LinkedList<>();
boolean getankt=false;
boolean bezahlt=false;
public Kasse()
{}
public int length()
{
   return kassewarteschlange.size();
}
public void addtoschlange(Auto a)
{
    kassewarteschlange.addFirst(a);
}
public void removeformschlange()
{
    kassewarteschlange.removeFirst();
}
public boolean isEmpty()
{
    return kassewarteschlange.isEmpty();
}
public boolean check()
{
   if(kassewarteschlange.getFirst().getZahlen()==1)
   {
      return true;
   }
   return false;
}
public LinkedList<Auto> getschlange()
{
   return kassewarteschlange;
}

public Iterator<Auto> getiterator()
{
    return kassewarteschlange.iterator();
}

}
