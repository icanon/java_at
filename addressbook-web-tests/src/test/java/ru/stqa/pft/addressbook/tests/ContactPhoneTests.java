package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created on 02.06.2016.
 */
public class ContactPhoneTests  extends TestBase{


   WebDriver webDriver;



   @Test
   public void testContactPhone() {
      app.goTo().homePage();

      System.out.println(webDriver.findElement(By.xpath("//tbody/tr/td/input[@id='61']/../../td[6]")).getText());

      /*ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);*/

      //tbody/tr/td/input[@id='61']/../../td[6]

   }
}
