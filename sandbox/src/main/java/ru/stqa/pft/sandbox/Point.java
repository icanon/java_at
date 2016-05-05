package ru.stqa.pft.sandbox;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

      double dist = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y,2));
      return new BigDecimal(dist).setScale(2, RoundingMode.UP).doubleValue();

   }


}






