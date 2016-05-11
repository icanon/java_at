package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by i.sokolov on 11.05.2016.
 */
public class EquationTests {

   @Test
   public void testEquation0(){
      Equation e = new Equation(1, 1, 1);
      Assert.assertEquals(e.rootnumber(), 0);
   }

   @Test
   public void testEquation1(){
      Equation e = new Equation(1, 2, 1);
      Assert.assertEquals(e.rootnumber(), 1);
   }

   @Test
   public void testEquation2(){
      Equation e = new Equation(1, 5, 6);
      Assert.assertEquals(e.rootnumber(), 2);
   }





}
