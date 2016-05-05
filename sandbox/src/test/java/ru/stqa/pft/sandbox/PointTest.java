package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by mac on 03.05.16.
 */
public class PointTest {

   CalcDistance cd = new CalcDistance();
   Point p1 = new Point(1.0, 2.0);
   Point p2 = new Point(5.0, 6.0);

   @Test
   public void testPoint() {

      Assert.assertEquals(cd.distance(p1, p2), 5.66);

   }


   @Test
   public void testPoint2() {

      Assert.assertEquals(p1.distance(5.0, 6.0), 5.66);

   }

}
