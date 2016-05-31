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

public class ContactModificationTest extends TestBase {

   @BeforeMethod
   public void ensurePrecondisions() {
      app.goTo().homePage();
      if (app.сontact().all().size() == 0) {
         app.сontact().create(new ContactData().withFirstName("11111111"));
      }
   }

   @Test
   public void testContactModification() {

      Contacts before = app.сontact().all();
      ContactData modifyContact = before.iterator().next();
      ContactData contact = new ContactData().withId(modifyContact
              .getId())
              .withFirstName("f222")
              .withLastName("l2222");
      app.сontact().modify(contact);
      Contacts after = app.сontact().all();
      assertEquals(after.size(), before.size());
      assertThat(after, equalTo(
              before.without(modifyContact).withAdded(contact)));


   }


}
