package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

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
      Set<ContactData> before = app.сontact().all();
      ContactData deletedContact = before.iterator().next();
      app.сontact().delete(deletedContact);
      Set<ContactData> after = app.сontact().all();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(deletedContact);
      Assert.assertEquals(before, after);

      
   }

}
