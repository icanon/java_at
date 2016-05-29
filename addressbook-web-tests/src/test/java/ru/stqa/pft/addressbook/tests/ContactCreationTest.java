package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTest extends TestBase {


   @Test()
   public void testContactCreation() {
      app.goTo().homePage();
      Set<ContactData> before = app.сontact().all();
      ContactData contact = new ContactData().withFirstName("111").withLastName("last2");
      app.сontact().create(contact);

      Set<ContactData> after = app.сontact().all();
      Assert.assertEquals(after.size(), before.size() + 1);
      before.add(contact);
      Assert.assertEquals(before, after);






   }


}
