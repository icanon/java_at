package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by i.sokolov on 11.05.2016.
 */
public class ContactDeletionTest extends TestBase {


   @BeforeMethod
   public void ensurePrecondisions() {
      app.goTo().homePage();
      if (! app.сontact().isThereAContact()) {
         app.сontact().
                 create(new ContactData(null, "11111111", "111111", "+777777777777", "ya@ya.ru"));
      }
   }

   @Test(enabled = false)
   public void testContactDeletion() {
      List<ContactData> before = app.сontact().list();
      app.сontact().selectContact();
      app.сontact().deletedSelectContact();
      app.сontact().clicAlert();
      app.goTo().homePage();
      List<ContactData> after = app.сontact().list();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(before.size() - 1);
      Assert.assertEquals(before, after);

      
   }
}
