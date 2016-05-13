package ru.stqa.pft.sandbox;

/**
 * Created by i.sokolov on 11.05.2016.
 */
public class Equation {

   private double a;
   private double b;
   private double c;

   private int n;

   public Equation(double a, double b, double c) {


      this.a = a;
      this.b = b;
      this.c = c;


      double d = b*b - 4*a*c;

      if (d > 0) {
         n = 2;
      }  else {
         if (d == 0){
            n = 1;
         }  else {
            n = 0;
         }
      }
   }

   public int rootnumber(){
      return n;
   }

}