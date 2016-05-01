package ru.stqa.pft.sandbox;

/**
 * Created by mac on 30.04.16.
 */
public class Point {

   public double x;
   public double y;



   public Point(double x, double y) {
      this.x = x;
      this.y = y;
   }



   public double distance(double x, double y){
      return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y,2));

   }


}






