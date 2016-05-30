package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by i.sokolov on 11.05.2016.
 */
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

      Set<ContactData> before = app.сontact().all();
      ContactData modifyContact = before.iterator().next();
      int index = before.size();
      ContactData contact = new ContactData().withId(modifyContact
              .getId())
              .withFirstName("f222")
              .withLastName("l2222");
      app.сontact().modify(contact);
      
      Set<ContactData> after = app.сontact().all();
      Assert.assertEquals(after.size(), before.size());

      before.remove(modifyContact);
      before.add(contact);
      Assert.assertEquals(before, after);

   }


}
