package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by mac on 02.05.16.
 */
public class SquareTests {

   @Test
   public void testArea(){

      Square s = new Square(5);
      Assert.assertEquals(s.area(),25.0);


   }

}
