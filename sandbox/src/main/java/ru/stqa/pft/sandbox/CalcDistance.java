package ru.stqa.pft.sandbox;

/**
 * Created by mac on 01.05.16.
 */
public class CalcDistance {
   public static void main (String[] args){

      Point p1 = new Point(1.0, 2.5);
      Point p2 = new Point(2.1, 4.5);
//      System.out.println("Получаем :" + distance(p1, p2));

      System.out.println(p1.distance(2.1, 4.5));
   }

   public static double distance(Point pPoint1, Point pPoint2){

      return Math.sqrt(Math.pow(pPoint2.x - pPoint1.x, 2) + Math.pow(pPoint2.y - pPoint1.y,2));

   }

}
