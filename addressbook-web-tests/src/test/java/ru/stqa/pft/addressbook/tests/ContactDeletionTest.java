package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

   @BeforeMethod
   public void ensurePrecondisions() {
      app.goTo().homePage();
      if (app.сontact().all().size() == 0) {
         app.сontact().
                 create(new ContactData().withFirstName("firstName1"));
      }
   }

   @Test
   public void testContactDeletion() {
      Contacts before = app.сontact().all();
      ContactData deletedContact = before.iterator().next();
      app.сontact().delete(deletedContact);
      Contacts after = app.сontact().all();
      assertEquals(after.size(), before.size() - 1);
      assertThat(after, equalTo(before.without(deletedContact)));

   }

}
