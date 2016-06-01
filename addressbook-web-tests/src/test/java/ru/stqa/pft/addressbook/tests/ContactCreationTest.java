package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase {


   @Test
   public void testContactCreation() {
      app.goTo().homePage();
      Contacts before = app.сontact().all();
      ContactData contact = new ContactData()
              .withFirstName("111")
              .withLastName("last2")
              .withAddress("765")
              .withEmail("tyut@ya.ru")
              .withMobile("+765453234554");
      app.сontact().create(contact);
      Contacts after = app.сontact().all();
      assertEquals(after.size(), before.size() + 1);
      assertThat(after, equalTo(
              before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));






   }


}
