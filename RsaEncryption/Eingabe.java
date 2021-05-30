/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe3;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;
import java.math.BigInteger;

/**
 *
 * @author User
 */
public class Eingabe {
   
    
  private int prim1;
  private int prim2;
  public Eingabe()
   {
   }
 
  
  public int[] eingabe1()
  {
      int []PN=new int[2];
      prim1=checkforvalidinput("First");
      prim2=checkforvalidinput("Second");
      PN[0]=prim1;
      PN[1]=prim2;
      return PN;
  }
  public String[]eingabe2()
  {
      String io[]=new String[2];
      String inputfile=checkforvalidFile("Input");
      String outputfile=checkforvalidFile("output");
      io[0]=inputfile;
      io[1]=outputfile;
      return io;
  }
  
  
  public int checkforvalidinput(String str)
  {
     int num=0 ;
     boolean validnumber=false;
     Scanner sc=new Scanner(System.in);
     while(!validnumber)
     {
            System.out.printf("Please Entre the %s prim number : ",str);
            try{   
            num=sc.nextInt();
            if(checkforPrimNumber(num))
            {
               validnumber=true;
            }
            }catch(InputMismatchException e)
                  {
                      System.out.println("you didn't Entre a valid Input"); 
                      checkforvalidinput(str);
                  }
     }
  
     return num;
 }
  
  
  public boolean checkforPrimNumber(int num)
  {
       for(int i=2;i<Math.sqrt(num);i++)
          {
            if(num%i==0)
              {
                 System.out.println("The Number you have entered is not a Prim Number");
                 return false;
              }
          }
       return true;
  }
  
 
  
 public String checkforvalidFile(String str)
 {
   String filename = null;
   Scanner user=new Scanner(System.in); 
   System.out.printf("Please Entre the %sFile Name ?",str);
   try{
       filename=user.nextLine().trim();
   }catch(Exception ioe)
   {
      System.out.println("could not find File");
   }
   return filename;
 }
  
  
  
  
  
    
  
  
  
}  