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
      if (app.сontact().list().size() == 0) {
         app.сontact().
                 create(new ContactData().withFirstName("firstName1"));
      }
   }

   @Test
   public void testContactDeletion() {
      List<ContactData> before = app.сontact().list();
      int index = before.size() - 1;
      app.сontact().delete(index);

      List<ContactData> after = app.сontact().list();
      Assert.assertEquals(after.size(), before.size() - 1);
      before.remove(before.size() - 1);
      Assert.assertEquals(before, after);

      
   }

}
